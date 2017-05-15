/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.openforis.collect.persistence.jooq.Collect;
import org.openforis.collect.persistence.jooq.Keys;
import org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord;


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
public class OfcTaxon extends TableImpl<OfcTaxonRecord> {

	private static final long serialVersionUID = 864863638;

	/**
	 * The reference instance of <code>collect.ofc_taxon</code>
	 */
	public static final OfcTaxon OFC_TAXON = new OfcTaxon();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<OfcTaxonRecord> getRecordType() {
		return OfcTaxonRecord.class;
	}

	/**
	 * The column <code>collect.ofc_taxon.id</code>.
	 */
	public final TableField<OfcTaxonRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_taxon.taxon_id</code>.
	 */
	public final TableField<OfcTaxonRecord, Integer> TAXON_ID = createField("taxon_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>collect.ofc_taxon.code</code>.
	 */
	public final TableField<OfcTaxonRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "");

	/**
	 * The column <code>collect.ofc_taxon.scientific_name</code>.
	 */
	public final TableField<OfcTaxonRecord, String> SCIENTIFIC_NAME = createField("scientific_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_taxon.taxon_rank</code>.
	 */
	public final TableField<OfcTaxonRecord, String> TAXON_RANK = createField("taxon_rank", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_taxon.taxonomy_id</code>.
	 */
	public final TableField<OfcTaxonRecord, Integer> TAXONOMY_ID = createField("taxonomy_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_taxon.step</code>.
	 */
	public final TableField<OfcTaxonRecord, Integer> STEP = createField("step", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>collect.ofc_taxon.parent_id</code>.
	 */
	public final TableField<OfcTaxonRecord, Integer> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>collect.ofc_taxon.info01</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO01 = createField("info01", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info02</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO02 = createField("info02", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info03</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO03 = createField("info03", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info04</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO04 = createField("info04", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info05</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO05 = createField("info05", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info06</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO06 = createField("info06", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info07</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO07 = createField("info07", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info08</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO08 = createField("info08", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info09</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO09 = createField("info09", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info10</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO10 = createField("info10", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info11</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO11 = createField("info11", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info12</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO12 = createField("info12", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info13</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO13 = createField("info13", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info14</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO14 = createField("info14", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info15</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO15 = createField("info15", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info16</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO16 = createField("info16", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info17</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO17 = createField("info17", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info18</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO18 = createField("info18", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info19</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO19 = createField("info19", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>collect.ofc_taxon.info20</code>.
	 */
	public final TableField<OfcTaxonRecord, String> INFO20 = createField("info20", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>collect.ofc_taxon</code> table reference
	 */
	public OfcTaxon() {
		this("ofc_taxon", null);
	}

	/**
	 * Create an aliased <code>collect.ofc_taxon</code> table reference
	 */
	public OfcTaxon(String alias) {
		this(alias, OFC_TAXON);
	}

	private OfcTaxon(String alias, Table<OfcTaxonRecord> aliased) {
		this(alias, aliased, null);
	}

	private OfcTaxon(String alias, Table<OfcTaxonRecord> aliased, Field<?>[] parameters) {
		super(alias, Collect.COLLECT, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<OfcTaxonRecord> getPrimaryKey() {
		return Keys.OFC_TAXON_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<OfcTaxonRecord>> getKeys() {
		return Arrays.<UniqueKey<OfcTaxonRecord>>asList(Keys.OFC_TAXON_PKEY, Keys.OFC_TAXON_ID_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<OfcTaxonRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<OfcTaxonRecord, ?>>asList(Keys.OFC_TAXON__OFC_TAXON_TAXONOMY_FKEY, Keys.OFC_TAXON__OFC_TAXON_PARENT_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfcTaxon as(String alias) {
		return new OfcTaxon(alias, this);
	}

	/**
	 * Rename this table
	 */
	public OfcTaxon rename(String name) {
		return new OfcTaxon(name, null);
	}
}
