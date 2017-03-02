package org.openforis.collect.metamodel.uiconfiguration.view;

import org.openforis.collect.metamodel.ui.UIColumn;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.NodeLabel.Type;

public class UIColumnView extends UITableHeadingComponentView<UIColumn> {

	public UIColumnView(UIColumn uiObject) {
		super(uiObject);
	}
	
	@Override
	public String getType() {
		return "COLUMN";
	}
	
	public int getAttributeDefinitionId() {
		return uiObject.getAttributeDefinitionId();
	}
	
	public String getLabel() {
		NodeDefinition nodeDef = getNodeDefinition(getAttributeDefinitionId());
		String label = nodeDef.getFailSafeLabel(Type.ABBREVIATED, Type.INSTANCE);
		return label;
	}
}