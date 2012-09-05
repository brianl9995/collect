package org.openforis.collect.model.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.openforis.idm.metamodel.Configuration;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.xml.ConfigurationAdapter;
import org.openforis.idm.util.CollectionUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * @author M. Togna
 * @author S. Ricci
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tabDefinitions" })
@XmlRootElement(name = "flex")
public class UIConfiguration implements Configuration, Serializable {

	public static final QName TAB_DEFINITION_ANNOTATION = new QName("http://www.openforis.org/collect/3.0/ui", "tabDefinition");
	public static final QName TAB_NAME_ANNOTATION = new QName("http://www.openforis.org/collect/3.0/ui", "tab");
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "tabDefinition", type = UITabDefinition.class)
	private List<UITabDefinition> tabDefinitions;

	public List<UITabDefinition> getTabDefinitions() {
		return CollectionUtil.unmodifiableList(tabDefinitions);
	}
	
	public UITab getTab(NodeDefinition nodeDefn) {
		UITab tab = null;
		String tabName = nodeDefn.getAnnotation(TAB_NAME_ANNOTATION);
		if ( nodeDefn.getParentDefinition() == null ) {
			String tabDefnName = nodeDefn.getAnnotation(TAB_DEFINITION_ANNOTATION);
			UITabDefinition tabDefinition = getTabDefinition(tabDefnName);
			tab = tabDefinition.getChildTab(tabName);
		} else {
			NodeDefinition parentDefn = nodeDefn.getParentDefinition();
			UITab parentTab = getTab(parentDefn);
			if ( ! StringUtils.isBlank(tabName) ) {
				tab = parentTab.getChildTab(tabName);
			}
		}
		return tab;
	}
	
	public UITabDefinition getTabDefinition(String name) {
		if ( tabDefinitions != null ) {
			for (UITabDefinition tabDefn : tabDefinitions) {
				if ( tabDefn.getName().equals(name) ) {
					return tabDefn;
				}
			}
		}
		return null;
	}
	
	public void addTabDefinition(UITabDefinition tabDefn) {
		if ( tabDefinitions == null ) {
			tabDefinitions = new ArrayList<UITabDefinition>();
		}
		tabDefinitions.add(tabDefn);
	}
	
	public void setTabDefinition(int index, UITabDefinition tabDefn) {
		if ( tabDefinitions == null ) {
			tabDefinitions = new ArrayList<UITabDefinition>();
		}
		tabDefinitions.set(index, tabDefn);
	}
	
	public void removeTabDefinition(UITabDefinition tabDefn) {
		tabDefinitions.remove(tabDefn);
	}
	
	public UITabDefinition updateTabDefinition(String name, String newName) {
		UITabDefinition tabDefn = getTabDefinition(name);
		tabDefn.setName(newName);
		return tabDefn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tabDefinitions == null) ? 0 : tabDefinitions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIConfiguration other = (UIConfiguration) obj;
		if (tabDefinitions == null) {
			if (other.tabDefinitions != null)
				return false;
		} else if (!tabDefinitions.equals(other.tabDefinitions))
			return false;
		return true;
	}

	public static class UIConfigurationAdapter implements ConfigurationAdapter<UIConfiguration> {

		private static DocumentBuilder documentBuilder;
		
		static{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			try {
				documentBuilder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public UIConfiguration unmarshal(Element elem) {
			try {
				JAXBContext jc = JAXBContext.newInstance(UIConfiguration.class);
				Unmarshaller unmarshaller = jc.createUnmarshaller();
				UIConfiguration configuration = (UIConfiguration) unmarshaller.unmarshal(elem);
				return configuration;
			} catch (JAXBException e) {
				throw new RuntimeException("Unable to marshal the UI configuration: "+ e.getMessage(), e);
			}
		}

		@Override
		public Element marshal(UIConfiguration config) {
			try {
				JAXBContext jc = JAXBContext.newInstance(UIConfiguration.class);
				Marshaller marshaller = jc.createMarshaller();
				Document document = documentBuilder.newDocument();
				marshaller.marshal(config, document);
				Element documentElement = document.getDocumentElement();
				return documentElement;
			} catch (JAXBException e) {
				throw new RuntimeException("Unable to marshal the UI configuration: "+ e.getMessage(), e);
			}
		}

	}

}
