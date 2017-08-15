/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.openforis.collect.persistence.jooq.tables.OfcDataQuery;
import org.openforis.collect.persistence.jooq.tables.records.OfcDataQueryRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OfcDataQueryDao extends DAOImpl<OfcDataQueryRecord, org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery, Integer> {

	/**
	 * Create a new OfcDataQueryDao without any configuration
	 */
	public OfcDataQueryDao() {
		super(OfcDataQuery.OFC_DATA_QUERY, org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery.class);
	}

	/**
	 * Create a new OfcDataQueryDao with an attached configuration
	 */
	public OfcDataQueryDao(Configuration configuration) {
		super(OfcDataQuery.OFC_DATA_QUERY, org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchById(Integer... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery fetchOneById(Integer value) {
		return fetchOne(OfcDataQuery.OFC_DATA_QUERY.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByUuid(String... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.UUID, values);
	}

	/**
	 * Fetch records that have <code>survey_id IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchBySurveyId(Integer... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.SURVEY_ID, values);
	}

	/**
	 * Fetch records that have <code>title IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByTitle(String... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.TITLE, values);
	}

	/**
	 * Fetch records that have <code>description IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByDescription(String... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.DESCRIPTION, values);
	}

	/**
	 * Fetch records that have <code>creation_date IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByCreationDate(Timestamp... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.CREATION_DATE, values);
	}

	/**
	 * Fetch records that have <code>modified_date IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByModifiedDate(Timestamp... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.MODIFIED_DATE, values);
	}

	/**
	 * Fetch records that have <code>entity_id IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByEntityId(Integer... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.ENTITY_ID, values);
	}

	/**
	 * Fetch records that have <code>attribute_id IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByAttributeId(Integer... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.ATTRIBUTE_ID, values);
	}

	/**
	 * Fetch records that have <code>conditions IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByConditions(String... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.CONDITIONS, values);
	}

	/**
	 * Fetch records that have <code>type_id IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchByTypeId(Integer... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.TYPE_ID, values);
	}

	/**
	 * Fetch records that have <code>severity IN (values)</code>
	 */
	public List<org.openforis.collect.persistence.jooq.tables.pojos.OfcDataQuery> fetchBySeverity(String... values) {
		return fetch(OfcDataQuery.OFC_DATA_QUERY.SEVERITY, values);
	}
}
