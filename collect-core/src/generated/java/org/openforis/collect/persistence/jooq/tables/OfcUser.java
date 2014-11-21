/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OfcUser extends org.jooq.impl.TableImpl<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> {

	private static final long serialVersionUID = 2115496106;

	/**
	 * The singleton instance of <code>collect.ofc_user</code>
	 */
	public static final org.openforis.collect.persistence.jooq.tables.OfcUser OFC_USER = new org.openforis.collect.persistence.jooq.tables.OfcUser();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> getRecordType() {
		return org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord.class;
	}

	/**
	 * The column <code>collect.ofc_user.id</code>.
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_user.username</code>.
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord, java.lang.String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_user.password</code>.
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord, java.lang.String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_user.enabled</code>.
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord, java.lang.String> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.CHAR.length(1).nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>collect.ofc_user</code> table reference
	 */
	public OfcUser() {
		this("ofc_user", null);
	}

	/**
	 * Create an aliased <code>collect.ofc_user</code> table reference
	 */
	public OfcUser(java.lang.String alias) {
		this(alias, org.openforis.collect.persistence.jooq.tables.OfcUser.OFC_USER);
	}

	private OfcUser(java.lang.String alias, org.jooq.Table<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> aliased) {
		this(alias, aliased, null);
	}

	private OfcUser(java.lang.String alias, org.jooq.Table<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, org.openforis.collect.persistence.jooq.Collect.COLLECT, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> getPrimaryKey() {
		return org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord>>asList(org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY, org.openforis.collect.persistence.jooq.Keys.OFC_USER_USERNAME_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.collect.persistence.jooq.tables.OfcUser as(java.lang.String alias) {
		return new org.openforis.collect.persistence.jooq.tables.OfcUser(alias, this);
	}

	/**
	 * Rename this table
	 */
	public org.openforis.collect.persistence.jooq.tables.OfcUser rename(java.lang.String name) {
		return new org.openforis.collect.persistence.jooq.tables.OfcUser(name, null);
	}
}
