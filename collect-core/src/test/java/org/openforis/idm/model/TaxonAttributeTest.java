package org.openforis.idm.model;

import org.junit.Test;
import org.openforis.idm.AbstractTest;

/**
 * @author G. Miceli
 * @author M. Togna
 */
public class TaxonAttributeTest extends AbstractTest {

	@Test
	public void testSetValidLanguageCode() {
		Entity cluster = getRootEntity();
		Entity plot = EntityBuilder.addEntity(cluster, "plot");
		Entity tree = EntityBuilder.addEntity(plot, "tree");
		TaxonOccurrence taxonOccurrence = new TaxonOccurrence("JUG/REG", "Juglans regia", "Noce bianco", "ita", "");
		EntityBuilder.addValue(tree, "species", taxonOccurrence);
	}

	@Test(expected=TaxonAttribute.LanguageCodeNotSupportedException.class)
	public void testSetInvalidLanguageCode() {
		Entity cluster = getRootEntity();
		Entity plot = EntityBuilder.addEntity(cluster, "plot");
		Entity tree = EntityBuilder.addEntity(plot, "tree");
		TaxonOccurrence taxonOccurrence = new TaxonOccurrence("JUG/REG", "Juglans regia", "Noce bianco", "itc", "");
		EntityBuilder.addValue(tree, "species", taxonOccurrence);
	}

	private Entity getRootEntity() {
		Record record = new Record(survey, "2.0");
		Entity entity = record.createRootEntity("cluster");
		return entity;
	}
}
