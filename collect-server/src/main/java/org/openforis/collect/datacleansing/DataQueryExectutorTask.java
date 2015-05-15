package org.openforis.collect.datacleansing;

import java.util.Iterator;
import java.util.List;

import org.openforis.collect.datacleansing.xpath.XPathDataQueryEvaluator;
import org.openforis.collect.manager.RecordManager;
import org.openforis.collect.model.CollectRecord;
import org.openforis.collect.model.CollectSurvey;
import org.openforis.collect.model.RecordFilter;
import org.openforis.collect.model.CollectRecord.Step;
import org.openforis.concurrency.Task;
import org.openforis.idm.metamodel.EntityDefinition;
import org.openforis.idm.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author S. Ricci
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DataQueryExectutorTask extends Task {
	
	@Autowired
	private RecordManager recordManager;
	
	DataQueryExectutorTask.DataQueryExecutorTaskInput input;
	
	//output
	private List<DataQueryExectutorTask.DataQueryExecutorError> errors;

	@Override
	protected long countTotalItems() {
		RecordFilter recordsFilter = createRecordsFilter();
		int count = recordManager.countRecords(recordsFilter);
		return count;
	}
	
	@Override
	protected void execute() throws Throwable {
		CollectSurvey survey = input.query.getSurvey();
		
		DataQueryEvaluator queryEvaluator = createQueryEvaluator(input.query);

		RecordFilter filter = createRecordsFilter();
		
		List<CollectRecord> recordSummaries = recordManager.loadSummaries(filter);
		
		Iterator<CollectRecord> it = recordSummaries.iterator();
		while (it.hasNext() && isRunning()) {
			CollectRecord recordSummary = (CollectRecord) it.next();
			CollectRecord record = recordManager.load(survey, recordSummary.getId());
			List<Node<?>> nodes = queryEvaluator.evaluate(record);
			Iterator<Node<?>> nodesIt = nodes.iterator();
			while (nodesIt.hasNext()) {
				Node<?> node = (Node<?>) nodesIt.next();
				try {
					input.nodeProcessor.process(node);
				} catch(Exception e) {
					log().error(String.format("Error executing query %s", input.query.getId()), e);
					errors.add(new DataQueryExecutorError(record.getRootEntityKeyValues(), record.getId(), node.getPath(), e.getMessage()));
				}
			}
			incrementItemsProcessed();
		}
	}
	
	private RecordFilter createRecordsFilter() {
		CollectSurvey survey = input.query.getSurvey();
		EntityDefinition entityDef = (EntityDefinition) survey.getSchema().getDefinitionById(input.query.getEntityDefinitionId());
		EntityDefinition rootEntityDef = entityDef.getRootEntity();
		Integer rootEntityId = rootEntityDef.getId();

		RecordFilter filter = new RecordFilter(survey);
		filter.setStep(input.step);
		filter.setRootEntityId(rootEntityId);
		filter.setOffset(0);
		filter.setMaxNumberOfRecords(input.maxRecords);
		return filter;
	}
	
	private DataQueryEvaluator createQueryEvaluator(DataQuery query) {
		return new XPathDataQueryEvaluator(query);
	}
	
	public DataQueryExectutorTask.DataQueryExecutorTaskInput getInput() {
		return input;
	}
	
	public void setInput(DataQueryExectutorTask.DataQueryExecutorTaskInput input) {
		this.input = input;
	}
	
	public static class DataQueryExecutorError {
		private List<String> recordKeys;
		private int recordId;
		private String attributePath;
		private String errorMessage;
		
		public DataQueryExecutorError(List<String> recordKeys,
				int recordId, String attributePath, String errorMessage) {
			super();
			this.recordKeys = recordKeys;
			this.recordId = recordId;
			this.attributePath = attributePath;
			this.errorMessage = errorMessage;
		}

		public int getRecordId() {
			return recordId;
		}
		
		public List<String> getRecordKeys() {
			return recordKeys;
		}
		
		public String getAttributePath() {
			return attributePath;
		}
		
		public String getErrorMessage() {
			return errorMessage;
		}
	}
	
	public static class DataQueryExecutorTaskInput {
		
		private DataQuery query;
		private Step step;
		private Integer maxRecords;
		private NodeProcessor nodeProcessor;
		
		public DataQueryExecutorTaskInput(DataQuery query, Step step, NodeProcessor nodeProcessor, Integer maxRecords) {
			this(query, step, nodeProcessor);
		}

		public DataQueryExecutorTaskInput(DataQuery query, Step step, NodeProcessor nodeProcessor) {
			super();
			this.query = query;
			this.step = step;
			this.nodeProcessor = nodeProcessor;
		}

		public DataQuery getQuery() {
			return query;
		}
		
		public void setQuery(DataQuery query) {
			this.query = query;
		}
		
		public Step getStep() {
			return step;
		}
		
		public void setStep(Step step) {
			this.step = step;
		}
		
		public Integer getMaxRecords() {
			return maxRecords;
		}
		
		public void setMaxRecords(Integer maxRecords) {
			this.maxRecords = maxRecords;
		}
		
		public NodeProcessor getNodeProcessor() {
			return nodeProcessor;
		}
		
		public void setNodeProcessor(NodeProcessor nodeProcessor) {
			this.nodeProcessor = nodeProcessor;
		}
	}
}