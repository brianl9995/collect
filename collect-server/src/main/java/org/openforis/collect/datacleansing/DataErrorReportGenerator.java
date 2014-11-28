package org.openforis.collect.datacleansing;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openforis.collect.datacleansing.DataErrorReportItem.Status;
import org.openforis.idm.model.Attribute;
import org.openforis.idm.model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author A. Modragon
 *
 */
@Component
public class DataErrorReportGenerator {
	
	@Autowired
	private DataQueryExecutor queryExecutor;
	@Autowired
	private DataCleansingManager dataCleansingManager;
	
	public DataErrorReport generate(DataErrorQuery query){
		DataErrorReport report = new DataErrorReport();
		report.setQuery(query);
		dataCleansingManager.save(report);
		DataQueryResultIterator it = queryExecutor.execute(query);
		ItemBatchPersister batchPersister = new ItemBatchPersister(report);
		while (it.hasNext()) {
			Attribute<?, ?> attr = (Attribute<?, ?>) it.next();
			DataErrorReportItem item = createReportItem(report, attr);
			batchPersister.add(item);
		}
		batchPersister.flush();
		return report;
	}

	private DataErrorReportItem createReportItem(DataErrorReport report,
			Attribute<?, ?> attr) {
		DataErrorReportItem item = new DataErrorReportItem(report);
		item.setRecordId(attr.getRecord().getId());
		item.setParentEntityId(attr.getParent().getInternalId());
		item.setAttributeValue(attr);
		item.setStatus(Status.PENDING);
		return item;
	}

	private class ItemBatchPersister {
		
		private static final int MAX_SIZE = 10000;
		
		private List<DataErrorReportItem> items;

		private DataErrorReport report;
		
		public ItemBatchPersister(DataErrorReport report) {
			items = new ArrayList<DataErrorReportItem>();
		}
		
		public void add(DataErrorReportItem item) {
			items.add(item);
			if (items.size() > MAX_SIZE) {
				flush();
			}
		}

		public void flush() {
			if (! items.isEmpty()) {
				dataCleansingManager.saveReportItems(report, items);
				items.clear();
			}
		}
		
	}
	
}
