package org.openforis.collect.datacleansing.controller;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.util.IOUtils;
import org.openforis.collect.concurrency.CollectJobManager;
import org.openforis.collect.datacleansing.DataErrorQuery.Severity;
import org.openforis.collect.datacleansing.DataErrorQueryGroup;
import org.openforis.collect.datacleansing.DataErrorReport;
import org.openforis.collect.datacleansing.DataErrorReportGeneratorJob;
import org.openforis.collect.datacleansing.DataErrorReportItem;
import org.openforis.collect.datacleansing.form.DataErrorReportForm;
import org.openforis.collect.datacleansing.form.DataErrorReportItemForm;
import org.openforis.collect.datacleansing.manager.DataErrorQueryGroupManager;
import org.openforis.collect.datacleansing.manager.DataErrorReportManager;
import org.openforis.collect.manager.RecordManager;
import org.openforis.collect.metamodel.CollectAnnotations;
import org.openforis.collect.model.CollectRecord;
import org.openforis.collect.model.CollectRecord.Step;
import org.openforis.collect.model.CollectSurvey;
import org.openforis.collect.utils.Controllers;
import org.openforis.collect.web.controller.AbstractSurveyObjectEditFormController;
import org.openforis.collect.web.controller.CollectJobController.JobView;
import org.openforis.collect.web.controller.PaginatedResponse;
import org.openforis.commons.io.csv.CsvWriter;
import org.openforis.commons.lang.Objects;
import org.openforis.commons.web.Response;
import org.openforis.idm.metamodel.AttributeDefinition;
import org.openforis.idm.metamodel.EntityDefinition;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.NodeDefinitionVisitor;
import org.openforis.idm.metamodel.NodeLabel.Type;
import org.openforis.idm.model.AbstractValue;
import org.openforis.idm.model.Attribute;
import org.openforis.idm.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value=WebApplicationContext.SCOPE_SESSION)
@RequestMapping(value = "/datacleansing/dataerrorreports")
public class DataErrorReportController extends AbstractSurveyObjectEditFormController<DataErrorReport, DataErrorReportForm, DataErrorReportManager> {
	
	@Autowired
	private DataErrorQueryGroupManager dataErrorQueryGroupManager;
	@Autowired
	private CollectJobManager collectJobManager;
	@Autowired
	private RecordManager recordManager;
	
	private DataErrorReportGeneratorJob generationJob;
	
	@Override
	@Autowired
	@Qualifier("dataErrorReportManager")
	public void setItemManager(DataErrorReportManager itemManager) {
		super.setItemManager(itemManager);
	}
	
	@Override
	protected DataErrorReportForm createFormInstance(DataErrorReport item) {
		DataErrorReportForm form = new DataErrorReportForm(item);
		int itemCount = itemManager.countItems(item);
		form.setItemCount(itemCount);
		return form;
	}
	
	@Override
	protected DataErrorReport createItemInstance(CollectSurvey survey) {
		return new DataErrorReport(survey);
	}
	
	@RequestMapping(value="generate.json", method = RequestMethod.POST)
	public @ResponseBody
	Response generate(@RequestParam int queryGroupId, @RequestParam Step recordStep) {
		CollectSurvey survey = sessionManager.getActiveSurvey();
		DataErrorQueryGroup queryGroup = dataErrorQueryGroupManager.loadById(survey, queryGroupId);
		generationJob = collectJobManager.createJob(DataErrorReportGeneratorJob.class);
		generationJob.setErrorQueryGroup(queryGroup);
		generationJob.setRecordStep(recordStep);
		collectJobManager.start(generationJob);
		Response response = new Response();
		return response;
	}
	
	@RequestMapping(value="{reportId}/export.csv", method = RequestMethod.GET)
	public void export(HttpServletResponse response, @PathVariable int reportId) throws Exception {
		export(response, reportId, GroupedByRecordCSVWriterDataErrorProcessor.class);
	}

	@RequestMapping(value="{reportId}/export-for-collect-earth.csv", method = RequestMethod.GET)
	public void exportForCollectEarth(HttpServletResponse response, @PathVariable int reportId) throws Exception {
		export(response, reportId, CollectEarthCSVWriterDataErrorProcessor.class);
	}
	
	private void export(HttpServletResponse response, int reportId,
			Class<? extends CSVWriterDataErrorItemProcessor> itemProcessorType)
			throws Exception {
		CollectSurvey survey = sessionManager.getActiveSurvey();
		DataErrorReport report = itemManager.loadById(survey, reportId);
		
		EntityDefinition rootEntityDefinition = survey.getSchema().getRootEntityDefinitions().get(0);
		CSVWriterDataErrorItemProcessor itemProcessor = Objects.newInstance(itemProcessorType, 
				new RecordProvider(recordManager), rootEntityDefinition);
		itemProcessor.init();
		int count = itemManager.countItems(report);
		int itemsPerPage = 100;
		int pages = Double.valueOf(Math.ceil((double) count / itemsPerPage)).intValue();
		for (int page = 1; page <= pages ; page++) {
			List<DataErrorReportItem> items = itemManager.loadItems(report, (page - 1) * itemsPerPage, itemsPerPage);
			for (DataErrorReportItem item : items) {
				itemProcessor.process(item);
			}
		}
		itemProcessor.close();
		File file = itemProcessor.getOutputFile();
		Controllers.writeFileToResponse(file, "text/csv", response, "data-error-report.csv");
	}
	
	@RequestMapping(value="{reportId}/items.json", method = RequestMethod.GET)
	public @ResponseBody
	PaginatedResponse loadItems(@PathVariable int reportId, 
			@RequestParam int offset, @RequestParam int limit) {
		CollectSurvey survey = sessionManager.getActiveSurvey();
		DataErrorReport report = itemManager.loadById(survey, reportId);
		int total = itemManager.countItems(report);
		List<DataErrorReportItem> items = itemManager.loadItems(report, offset, limit);
		List<DataErrorReportItemForm> rows = new ArrayList<DataErrorReportItemForm>(items.size());
		for (DataErrorReportItem item : items) {
			rows.add(new DataErrorReportItemForm(item));
		}
		return new PaginatedResponse(total, rows);
	}
	
	@RequestMapping(value="generate/job.json", method = RequestMethod.GET)
	public @ResponseBody
	JobView getCurrentGenearationJob(HttpServletResponse response) {
		if (generationJob == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return null;
		} else {
			return new JobView(generationJob);
		}
	}
	
	@RequestMapping(value="generate/job.json", method = RequestMethod.DELETE)
	public @ResponseBody Response cancelGenerationJob() {
		if (generationJob != null) {
			generationJob.abort();
		}
		return new Response();
	}
	
	private static abstract class CSVWriterDataErrorItemProcessor implements Closeable {
		
		protected CsvWriter csvWriter;
		protected RecordProvider recordProvider;
		
		//output
		private File tempFile;

		protected EntityDefinition rootEntityDefinition;


		public CSVWriterDataErrorItemProcessor(RecordProvider recordProvider, EntityDefinition rootEntityDefinition) {
			this.recordProvider = recordProvider;
			this.rootEntityDefinition = rootEntityDefinition;
		}
		
		public void init() throws Exception {
			tempFile = File.createTempFile("collect-data-error-report", ".csv");
			csvWriter = new CsvWriter(new FileOutputStream(tempFile), IOUtils.UTF_8, ',', '"');
			writeCSVHeader();
		}
		
		private void writeCSVHeader() {
			List<String> headers = determineHeaders();
			csvWriter.writeHeaders(headers.toArray(new String[headers.size()]));
		}

		protected List<String> determineHeaders() {
			List<String> headers = new ArrayList<String>();
			List<AttributeDefinition> keyAttributeDefinitions = rootEntityDefinition.getKeyAttributeDefinitions();
			for (AttributeDefinition def : keyAttributeDefinitions) {
				String keyLabel = def.getLabel(Type.INSTANCE);
				if (StringUtils.isBlank(keyLabel)) {
					keyLabel = def.getName();
				}
				headers.add(keyLabel);
			}
			headers.addAll(determineExtraHeaders());
			return headers;
		}

		protected List<String> determineExtraHeaders() {
			return new ArrayList<String>();
		}

		public abstract void process(DataErrorReportItem item);

		@Override
		public void close() throws IOException {
			csvWriter.close();
		}

		public File getOutputFile() {
			return tempFile;
		}
		
	}
	
	public static class GroupedByRecordCSVWriterDataErrorProcessor extends CSVWriterDataErrorItemProcessor {

		private static final String WARNINGS_HEADER = "warnings";
		private static final String ERRORS_HEADER = "errors";

		private RecordReportInfo lastRecordReportInfo;
		
		public GroupedByRecordCSVWriterDataErrorProcessor(
				RecordProvider recordProvider,
				EntityDefinition rootEntityDefinition) {
			super(recordProvider, rootEntityDefinition);
		}
		
		@Override
		public void process(DataErrorReportItem item) {
			if (lastRecordReportInfo != null && lastRecordReportInfo.getRecordId() != item.getRecordId()) {
				writeLastRecordInfo();
				lastRecordReportInfo = null;
			}
			if (lastRecordReportInfo == null) {
				lastRecordReportInfo = new RecordReportInfo(item.getRecordId(), item.getRecordKeyValues());
				lastRecordReportInfo.setExtraValues(determineExtraValues(item));
			}
			String queryTitle = item.getQuery().getTitle();
			if (item.getErrorQuery().getSeverity() == Severity.ERROR) {
				lastRecordReportInfo.addError(queryTitle);
			} else {
				lastRecordReportInfo.addWarning(queryTitle);
			}
		}
		
		protected List<String> determineExtraValues(DataErrorReportItem item) {
			return Collections.emptyList();
		}

		private void writeLastRecordInfo() {
			List<String> lineValues = new ArrayList<String>();
			lineValues.addAll(lastRecordReportInfo.getKeyValues());
			lineValues.addAll(lastRecordReportInfo.getExtraValues());
			lineValues.add(StringUtils.join(lastRecordReportInfo.getErrors(), "\r\n;"));
			lineValues.add(StringUtils.join(lastRecordReportInfo.getWarnings(), "\r\n;"));
			csvWriter.writeNext(lineValues.toArray(new String[lineValues.size()]));
		}
		
		@Override
		public void close() throws IOException {
			if (lastRecordReportInfo != null) {
				writeLastRecordInfo();
			}
			super.close();
		}
		
		@Override
		protected List<String> determineExtraHeaders() {
			List<String> headers = new ArrayList<String>();
			headers.add(ERRORS_HEADER);
			headers.add(WARNINGS_HEADER);
			return headers;
		}

		protected class RecordReportInfo {
			
			private int recordId;
			private List<String> keyValues;
			private List<String> extraValues;
			private List<String> errors = new ArrayList<String>();
			private List<String> warnings = new ArrayList<String>();
			
			public RecordReportInfo(int recordId, List<String> keyValues) {
				super();
				this.recordId = recordId;
				this.keyValues = keyValues;
			}
			
			public List<String> getKeyValues() {
				return keyValues;
			}
			
			public void addError(String error) {
				this.errors.add(error);
			}
			
			public void addWarning(String warning) {
				this.warnings.add(warning);
			}

			public int getRecordId() {
				return recordId;
			}
			
			public List<String> getExtraValues() {
				return extraValues;
			}
			
			public void setExtraValues(List<String> extraValues) {
				this.extraValues = extraValues;
			}
			
			public List<String> getErrors() {
				return errors;
			}
			
			public List<String> getWarnings() {
				return warnings;
			}
			
		}
	}
	
	public static class CollectEarthCSVWriterDataErrorProcessor extends GroupedByRecordCSVWriterDataErrorProcessor {

		private List<AttributeDefinition> fromCSVAttributes;

		public CollectEarthCSVWriterDataErrorProcessor(
				RecordProvider recordProvider,
				EntityDefinition rootEntityDefinition) {
			super(recordProvider, rootEntityDefinition);
			fromCSVAttributes = determineFromCSVAttributes();
		}
		
		@Override
		protected List<String> determineExtraHeaders() {
			List<String> extraHeaders = new ArrayList<String>(super.determineExtraHeaders());
			for (AttributeDefinition def : fromCSVAttributes) {
				extraHeaders.add(def.getName());
			}
			return extraHeaders;
		}
		
		@Override
		protected List<String> determineExtraValues(DataErrorReportItem item) {
			List<String> values = new ArrayList<String>(fromCSVAttributes.size());
			CollectRecord record = recordProvider.load((CollectSurvey) rootEntityDefinition.getSurvey(), item.getRecordId());
			for (AttributeDefinition def : fromCSVAttributes) {
				Attribute<?, ?> attr = record.findNodeByPath(rootEntityDefinition.getName() + "/" + def.getName());
				Value value = attr.getValue();
				values.add(toCSVValue(value));
			}
			return values;
		}
		
		private String toCSVValue(Value value) {
			if (value == null) {
				return "";
			} else if (value instanceof AbstractValue) {
				return ((AbstractValue) value).toPrettyFormatString();
			} else {
				return value.toString();
			}
		}

		private List<AttributeDefinition> determineFromCSVAttributes() {
			CollectSurvey survey = (CollectSurvey) rootEntityDefinition.getSurvey();

			final CollectAnnotations annotations = survey.getAnnotations();
			final List<AttributeDefinition> defs = new ArrayList<AttributeDefinition>();
			rootEntityDefinition.traverse(new NodeDefinitionVisitor() {
				public void visit(NodeDefinition def) {
					if (def instanceof AttributeDefinition) {
						if (annotations.isFromCollectEarthCSV((AttributeDefinition) def)) {
							defs.add((AttributeDefinition) def);
						}
					}
				}
			});
			return defs;
		}
		
	}
	
	public static class RecordProvider {
		
		private RecordManager recordManager;

		public RecordProvider(RecordManager recordManager) {
			super();
			this.recordManager = recordManager;
		}
		
		public CollectRecord load(CollectSurvey survey, int recordId) {
			CollectRecord record = recordManager.load(survey, recordId);
			return record;
		}
	}
	
}
