/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>collect</code> 
 * schema
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord> OFC_CODE_LIST_PKEY = UniqueKeys0.OFC_CODE_LIST_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> OFC_CONFIG_PKEY = UniqueKeys0.OFC_CONFIG_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcLogoRecord> OFC_LOGO_PKEY = UniqueKeys0.OFC_LOGO_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord> OFC_RECORD_PKEY = UniqueKeys0.OFC_RECORD_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord> PK_OFC_SAMPLING_DESIGN = UniqueKeys0.PK_OFC_SAMPLING_DESIGN;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord> OFC_SAMPLING_DESIGN_KEY = UniqueKeys0.OFC_SAMPLING_DESIGN_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_PKEY = UniqueKeys0.OFC_SURVEY_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_NAME_KEY = UniqueKeys0.OFC_SURVEY_NAME_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_URI_KEY = UniqueKeys0.OFC_SURVEY_URI_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_PKEY = UniqueKeys0.OFC_SURVEY_WORK_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_NAME_KEY = UniqueKeys0.OFC_SURVEY_WORK_NAME_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_URI_KEY = UniqueKeys0.OFC_SURVEY_WORK_URI_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_PKEY = UniqueKeys0.OFC_TAXON_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_ID_KEY = UniqueKeys0.OFC_TAXON_ID_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_PKEY = UniqueKeys0.OFC_TAXONOMY_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_NAME_KEY = UniqueKeys0.OFC_TAXONOMY_NAME_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_NAME_WORK_KEY = UniqueKeys0.OFC_TAXONOMY_NAME_WORK_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> OFC_TAXON_VERNACULAR_NAME_PKEY = UniqueKeys0.OFC_TAXON_VERNACULAR_NAME_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_PKEY = UniqueKeys0.OFC_USER_PKEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_USERNAME_KEY = UniqueKeys0.OFC_USER_USERNAME_KEY;
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRoleRecord> OFC_USER_ROLE_PKEY = UniqueKeys0.OFC_USER_ROLE_PKEY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_FKEY = ForeignKeys0.OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_WORK_FKEY = ForeignKeys0.OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_WORK_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord> OFC_CODE_LIST__OFC_CODE_LIST_PARENT_FKEY = ForeignKeys0.OFC_CODE_LIST__OFC_CODE_LIST_PARENT_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_RECORD__OFC_RECORD_SURVEY_FKEY = ForeignKeys0.OFC_RECORD__OFC_RECORD_SURVEY_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_CREATED_BY_USER_FKEY = ForeignKeys0.OFC_RECORD__OFC_RECORD_CREATED_BY_USER_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_MODIFIED_BY_USER_FKEY = ForeignKeys0.OFC_RECORD__OFC_RECORD_MODIFIED_BY_USER_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_OWNER_FKEY = ForeignKeys0.OFC_RECORD__OFC_RECORD_OWNER_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_FKEY = ForeignKeys0.OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_WORK_FKEY = ForeignKeys0.OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_WORK_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXON__OFC_TAXON_TAXONOMY_FKEY = ForeignKeys0.OFC_TAXON__OFC_TAXON_TAXONOMY_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON__OFC_TAXON_PARENT_FKEY = ForeignKeys0.OFC_TAXON__OFC_TAXON_PARENT_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_FKEY = ForeignKeys0.OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_WORK_FKEY = ForeignKeys0.OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_WORK_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_VERNACULAR_NAME__OFC_TAXON_VERNACULAR_NAME_TAXON_FKEY = ForeignKeys0.OFC_TAXON_VERNACULAR_NAME__OFC_TAXON_VERNACULAR_NAME_TAXON_FKEY;
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRoleRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_ROLE__OFC_USER_USER_ROLE_FKEY = ForeignKeys0.OFC_USER_ROLE__OFC_USER_USER_ROLE_FKEY;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord> OFC_CODE_LIST_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> OFC_CONFIG_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcConfig.OFC_CONFIG, org.openforis.collect.persistence.jooq.tables.OfcConfig.OFC_CONFIG.NAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcLogoRecord> OFC_LOGO_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcLogo.OFC_LOGO, org.openforis.collect.persistence.jooq.tables.OfcLogo.OFC_LOGO.POS);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord> OFC_RECORD_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord> PK_OFC_SAMPLING_DESIGN = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord> OFC_SAMPLING_DESIGN_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.SURVEY_ID, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.SURVEY_WORK_ID, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.LEVEL1, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.LEVEL2, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.LEVEL3);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY, org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_NAME_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY, org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY.NAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SURVEY_URI_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY, org.openforis.collect.persistence.jooq.tables.OfcSurvey.OFC_SURVEY.URI);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK, org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_NAME_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK, org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK.NAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SURVEY_WORK_URI_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK, org.openforis.collect.persistence.jooq.tables.OfcSurveyWork.OFC_SURVEY_WORK.URI);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_ID_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON.TAXON_ID, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON.TAXONOMY_ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_NAME_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.SURVEY_ID, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.NAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXONOMY_NAME_WORK_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.SURVEY_WORK_ID, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.NAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> OFC_TAXON_VERNACULAR_NAME_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName.OFC_TAXON_VERNACULAR_NAME, org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName.OFC_TAXON_VERNACULAR_NAME.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcUser.OFC_USER, org.openforis.collect.persistence.jooq.tables.OfcUser.OFC_USER.ID);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_USERNAME_KEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcUser.OFC_USER, org.openforis.collect.persistence.jooq.tables.OfcUser.OFC_USER.USERNAME);
		public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRoleRecord> OFC_USER_ROLE_PKEY = createUniqueKey(org.openforis.collect.persistence.jooq.tables.OfcUserRole.OFC_USER_ROLE, org.openforis.collect.persistence.jooq.tables.OfcUserRole.OFC_USER_ROLE.ID);
	}

	private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_PKEY, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST.SURVEY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_CODE_LIST__OFC_CODE_LIST_SURVEY_WORK_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_WORK_PKEY, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST.SURVEY_WORK_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord, org.openforis.collect.persistence.jooq.tables.records.OfcCodeListRecord> OFC_CODE_LIST__OFC_CODE_LIST_PARENT_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_CODE_LIST_PKEY, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST, org.openforis.collect.persistence.jooq.tables.OfcCodeList.OFC_CODE_LIST.PARENT_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_RECORD__OFC_RECORD_SURVEY_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_PKEY, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD.SURVEY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_CREATED_BY_USER_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD.CREATED_BY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_MODIFIED_BY_USER_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD.MODIFIED_BY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcRecordRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_RECORD__OFC_RECORD_OWNER_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD, org.openforis.collect.persistence.jooq.tables.OfcRecord.OFC_RECORD.OWNER_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_PKEY, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.SURVEY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcSamplingDesignRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_SAMPLING_DESIGN__OFC_SAMPLING_DESIGN_SURVEY_WORK_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_WORK_PKEY, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN, org.openforis.collect.persistence.jooq.tables.OfcSamplingDesign.OFC_SAMPLING_DESIGN.SURVEY_WORK_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord> OFC_TAXON__OFC_TAXON_TAXONOMY_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_TAXONOMY_PKEY, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON.TAXONOMY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON__OFC_TAXON_PARENT_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_TAXON_PKEY, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON, org.openforis.collect.persistence.jooq.tables.OfcTaxon.OFC_TAXON.PARENT_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyRecord> OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_PKEY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.SURVEY_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonomyRecord, org.openforis.collect.persistence.jooq.tables.records.OfcSurveyWorkRecord> OFC_TAXONOMY__OFC_TAXONOMY_SURVEY_WORK_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_SURVEY_WORK_PKEY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY, org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY.SURVEY_WORK_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, org.openforis.collect.persistence.jooq.tables.records.OfcTaxonRecord> OFC_TAXON_VERNACULAR_NAME__OFC_TAXON_VERNACULAR_NAME_TAXON_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_TAXON_PKEY, org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName.OFC_TAXON_VERNACULAR_NAME, org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName.OFC_TAXON_VERNACULAR_NAME.TAXON_ID);
		public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcUserRoleRecord, org.openforis.collect.persistence.jooq.tables.records.OfcUserRecord> OFC_USER_ROLE__OFC_USER_USER_ROLE_FKEY = createForeignKey(org.openforis.collect.persistence.jooq.Keys.OFC_USER_PKEY, org.openforis.collect.persistence.jooq.tables.OfcUserRole.OFC_USER_ROLE, org.openforis.collect.persistence.jooq.tables.OfcUserRole.OFC_USER_ROLE.USER_ID);
	}
}
