package org.openforis.collect.event;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openforis.collect.relational.ReportingRepositories;

public class RepositoryEventHandlerTest {
	
	private RepositoryEventHandler handler;
	private FakeReportingRepositories repositories;
	private int maxTries;

	@Before
	public void init() {
		repositories = new FakeReportingRepositories();
		maxTries = 1;
		handler = new RepositoryEventHandler(repositories);
		handler.setRetryDelay(0);
		handler.setMaxRetryCount(maxTries);
	}
	
	@Test
	public void testSurveyCreatedEventCreatesRepositories() {
		handle(new SurveyCreatedEvent("test"));
		
		assertEquals(1, repositories.createRepositoriesCalls);
	}

	@Test
	public void testSurveyCreatedEventFails() {
		repositories.createRepositoriesFails = maxTries;
		handle(new SurveyCreatedEvent("test"));
		assertEquals(1, repositories.createRepositoriesCalls);
		
		repositories.reset();
		handle(new SurveyCreatedEvent("test")); //events for same survey should be ignored
		assertEquals(0, repositories.createRepositoriesCalls);
		
		repositories.reset();
		handle(new SurveyCreatedEvent("test2")); //events from other surveys are handled
		assertEquals(1, repositories.createRepositoriesCalls);
	}

	@Test
	public void testFailingRecordTransactionRecreatesRepositoryAndHandlesTransaction() {
		String surveyName = "test";
		
		repositories.processFails = maxTries;
		handle(recordTransaction(surveyName));
		assertEquals(1, repositories.deleteRepositoriesCalls);
		assertEquals(1, repositories.createRepositoriesCalls);
		assertEquals(maxTries + 1, repositories.processCalls); //max tries, after recreation
		
		repositories.reset();
		handle(recordTransaction(surveyName)); //after repository recreation, events are handled
		assertEquals(1, repositories.processCalls);
		assertEquals(0, repositories.createRepositoriesCalls);
	}
	
	@Test
	public void testFailingRecordTransactionFailsToRecreateRepositoryThenEventsAreIgnored() {
		String surveyName = "test";
		
		repositories.processFails = maxTries + 1;
		handle(recordTransaction(surveyName));
		assertEquals(1, repositories.deleteRepositoriesCalls);
		assertEquals(1, repositories.createRepositoriesCalls);
		assertEquals(maxTries + 1, repositories.processCalls); //max tries, after recreation
		
		repositories.reset();
		handle(recordTransaction(surveyName)); //after failing repository recreation, events are ignored
		assertEquals(0, repositories.processCalls);
		
		repositories.reset();
		handle(recordTransaction("test2")); //events from other surveys are handled
		assertEquals(1, repositories.processCalls);
	}

	private RecordTransaction recordTransaction(String surveyName) {
		return new RecordTransaction(surveyName, -1, RecordStep.ENTRY, Collections.<RecordEvent>emptyList());
	}
	
	private void handle(SurveyEvent event) {
		handler.handle(event, null);
	}

	private static final class FakeReportingRepositories implements
			ReportingRepositories {
		int processCalls;
		int createRepositoryCalls;
		int createRepositoriesCalls;
		int updateRepositoriesCalls;
		int deleteRepositoriesCalls;
		int getRepositoryPathsFails;
		int createRepositoryFails;
		int createRepositoriesFails;
		int updateRepositoriesFails;
		int deleteRepositoriesFails;
		int processFails;
		int getRepositoryPathsCalls;
		
		@Override
		public void createRepository(String surveyName, RecordStep recordStep) {
			createRepositoryCalls ++;
			if (createRepositoryFails > 0) {
				createRepositoryFails --;
				throw new RuntimeException("createRepository failed");
			}
		}
		
		@Override
		public void createRepositories(String surveyName) {
			createRepositoriesCalls ++;
			if (createRepositoriesFails > 0) {
				createRepositoriesFails --;
				throw new RuntimeException("createRepositories failed");
			}
		}
		
		@Override
		public void updateRepositories(String surveyName) {
			updateRepositoriesCalls ++;
			if (updateRepositoriesFails > 0) {
				updateRepositoriesFails --;
				throw new RuntimeException("updateRepositories failed");
			}
		}
		
		@Override
		public void deleteRepositories(String surveyName) {
			deleteRepositoriesCalls ++;
			if (deleteRepositoriesFails > 0) {
				deleteRepositoriesFails --;
				throw new RuntimeException("deleteRepositories failed");
			}
		}
		
		@Override
		public void process(RecordTransaction recordTransaction) {
			processCalls ++;
			if (processFails > 0) {
				processFails --;
				throw new RuntimeException("Process failed");
			}
		}
		
		@Override
		public List<String> getRepositoryPaths(String surveyName) {
			getRepositoryPathsCalls ++;
			if (getRepositoryPathsFails > 0) {
				getRepositoryPathsFails --;
				throw new RuntimeException("getRepositoryPaths failed");
			}
			return Collections.emptyList();
		}
		
		public void reset() {
			processCalls = 0;
			getRepositoryPathsCalls = 0;
			createRepositoryCalls = 0;
			createRepositoriesCalls = 0;
			updateRepositoriesCalls = 0;
			deleteRepositoriesCalls = 0;
			processFails = 0;
			getRepositoryPathsFails = 0;
			createRepositoryFails = 0;
			createRepositoriesFails = 0;
			deleteRepositoriesFails = 0;
			updateRepositoriesFails = 0;
		}

	}
	
}
