package org.openforis.collect.persistence;

import static org.openforis.collect.persistence.jooq.Sequences.SCHEMA_DEFINITION_ID_SEQ;
import static org.openforis.collect.persistence.jooq.Sequences.SURVEY_ID_SEQ;
import static org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION;
import static org.openforis.collect.persistence.jooq.tables.Survey.SURVEY;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.Factory;
import org.openforis.idm.metamodel.Schema;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.Survey;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author G. Miceli
 * @author M. Togna
 */
public class SurveyDAO extends CollectDAO {
	
	@Transactional
	public void importModel(Survey survey) throws SurveyImportException {		
		String idml = marshalSurvey(survey);
		
		// Insert into SURVEY table
		Factory jf = getJooqFactory();
		int surveyId = jf.nextval(SURVEY_ID_SEQ).intValue();
		jf.insertInto(SURVEY)
		  .set(SURVEY.ID, surveyId)
		  .set(SURVEY.NAME, survey.getName())
		  .set(SURVEY.IDML, idml)
		  .execute();
		
		survey.setId(surveyId);
		
		// Insert SCHEMA_DEFINITIONs
		Schema schema = survey.getSchema();
		Collection<NodeDefinition> definitions = schema.getDefinitions();
		for ( NodeDefinition definition : definitions ) {
			int definitionId = jf.nextval(SCHEMA_DEFINITION_ID_SEQ).intValue();
			String path = definition.getPath();
			jf.insertInto(SCHEMA_DEFINITION)
			  .set(SCHEMA_DEFINITION.ID, definitionId)
			  .set(SCHEMA_DEFINITION.SURVEY_ID, surveyId)
			  .set(SCHEMA_DEFINITION.PATH, path)
			  .execute();
			definition.setId(definitionId);
		}
	}
	
	@Transactional
	public Survey load(int id) {
		// Load IDML from SURVEY table
		Factory jf = getJooqFactory();
		Record row = jf.select()
					  .from(SURVEY)
					  .where(SURVEY.ID.equal(id))
					  .fetchOne();
		Survey survey = processSurveyRow(row);
		// Load schema object definition ids from SCHEMA_DEFINITION table
		if ( survey != null ) {
			loadNodeDefinitions(survey);
		}
		return survey;
	}
	
	@Transactional
	public Survey load(String name) {
		// Load IDML from SURVEY table
		Factory jf = getJooqFactory();
		Record row = jf.select()
					  .from(SURVEY)
					  .where(SURVEY.NAME.equal(name))
					  .fetchOne();
		Survey survey = processSurveyRow(row);
		// Load schema object definition ids from SCHEMA_DEFINITION table 
		if ( survey != null ) {
			loadNodeDefinitions(survey);
		}
		return survey;
	}
	
	private Survey processSurveyRow(Record row) {
		try {
			if ( row == null ) {
				return null;
			}
			String idml = row.getValueAsString(SURVEY.IDML);
			Survey survey = unmarshalIdml(idml);
			survey.setId(row.getValueAsInteger(SURVEY.ID));
			return survey;
		} catch (IOException e) {
			throw new RuntimeException("Error deserializing IDML from database",e);
		}
	}

	private Survey unmarshalIdml(String idml) throws IOException {
		byte[] bytes = idml.getBytes("UTF-8");
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		Survey survey = Survey.unmarshal(is);
		return survey;
	}

	private void loadNodeDefinitions(Survey survey) {
		Factory jf = getJooqFactory();
		// Internal IDs by path and associate with each node in tree
		Schema schema = survey.getSchema();
		Result<Record> result = jf.select()
								  .from(SCHEMA_DEFINITION)
								  .where(SCHEMA_DEFINITION.SURVEY_ID.equal(survey.getId()))
								  .fetch();
		for (Record defnRecord : result) {
			int defnId = defnRecord.getValueAsInteger(SCHEMA_DEFINITION.ID);
			String path = defnRecord.getValueAsString(SCHEMA_DEFINITION.PATH);
			NodeDefinition defn = schema.getByPath(path);
			defn.setId(defnId);
		}
	}

	private String marshalSurvey(Survey survey) throws SurveyImportException {
		try {
			// Serialize Survey to XML
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			survey.marshal(os, false);
			return os.toString("UTF-8");
		} catch (IOException ex) {
			throw new SurveyImportException("Error unmarshalling survey", ex);
		}
	}
}
