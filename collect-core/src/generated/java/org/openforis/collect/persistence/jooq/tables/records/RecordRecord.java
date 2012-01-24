/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.1"},
                            comments = "This class is generated by jOOQ")
public class RecordRecord extends org.jooq.impl.UpdatableRecordImpl<org.openforis.collect.persistence.jooq.tables.records.RecordRecord> {

	private static final long serialVersionUID = -150667316;

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setId(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ID, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.Integer getId() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.root_entity_id]
	 * REFERENCES schema_definition [collect.schema_definition.id]
	 * </pre></code>
	 */
	public void setRootEntityId(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ROOT_ENTITY_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.root_entity_id]
	 * REFERENCES schema_definition [collect.schema_definition.id]
	 * </pre></code>
	 */
	public java.lang.Integer getRootEntityId() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ROOT_ENTITY_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.root_entity_id]
	 * REFERENCES schema_definition [collect.schema_definition.id]
	 * </pre></code>
	 */
	public org.openforis.collect.persistence.jooq.tables.records.SchemaDefinitionRecord fetchSchemaDefinition() {
		return create()
			.selectFrom(org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION)
			.where(org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION.ID.equal(getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ROOT_ENTITY_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setDateCreated(java.sql.Timestamp value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.DATE_CREATED, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getDateCreated() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.DATE_CREATED);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.created_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public void setCreatedById(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.CREATED_BY_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.created_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public java.lang.Integer getCreatedById() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.CREATED_BY_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.created_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public org.openforis.collect.persistence.jooq.tables.records.UserRecord fetchUserByCreatedById() {
		return create()
			.selectFrom(org.openforis.collect.persistence.jooq.tables.User.USER)
			.where(org.openforis.collect.persistence.jooq.tables.User.USER.ID.equal(getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.CREATED_BY_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setDateModified(java.sql.Timestamp value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.DATE_MODIFIED, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getDateModified() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.DATE_MODIFIED);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.modified_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public void setModifiedById(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODIFIED_BY_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.modified_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public java.lang.Integer getModifiedById() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODIFIED_BY_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.modified_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public org.openforis.collect.persistence.jooq.tables.records.UserRecord fetchUserByModifiedById() {
		return create()
			.selectFrom(org.openforis.collect.persistence.jooq.tables.User.USER)
			.where(org.openforis.collect.persistence.jooq.tables.User.USER.ID.equal(getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODIFIED_BY_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setModelVersion(java.lang.String value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODEL_VERSION, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getModelVersion() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODEL_VERSION);
	}

	/**
	 * An uncommented item
	 */
	public void setStep(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.STEP, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getStep() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.STEP);
	}

	/**
	 * An uncommented item
	 */
	public void setState(java.lang.String value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.STATE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getState() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.STATE);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.locked_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public void setLockedById(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.LOCKED_BY_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.locked_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public java.lang.Integer getLockedById() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.LOCKED_BY_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.record.locked_by_id]
	 * REFERENCES user [collect.user.id]
	 * </pre></code>
	 */
	public org.openforis.collect.persistence.jooq.tables.records.UserRecord fetchUserByLockedById() {
		return create()
			.selectFrom(org.openforis.collect.persistence.jooq.tables.User.USER)
			.where(org.openforis.collect.persistence.jooq.tables.User.USER.ID.equal(getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.LOCKED_BY_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setSkipped(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.SKIPPED, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getSkipped() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.SKIPPED);
	}

	/**
	 * An uncommented item
	 */
	public void setMissing(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MISSING, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getMissing() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.MISSING);
	}

	/**
	 * An uncommented item
	 */
	public void setErrors(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ERRORS, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getErrors() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.ERRORS);
	}

	/**
	 * An uncommented item
	 */
	public void setWarnings(java.lang.Integer value) {
		setValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.WARNINGS, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getWarnings() {
		return getValue(org.openforis.collect.persistence.jooq.tables.Record.RECORD.WARNINGS);
	}

	/**
	 * Create a detached RecordRecord
	 */
	public RecordRecord() {
		super(org.openforis.collect.persistence.jooq.tables.Record.RECORD);
	}
}
