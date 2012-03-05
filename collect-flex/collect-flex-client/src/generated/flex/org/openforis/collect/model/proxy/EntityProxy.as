/**
 * Generated by Gas3 v2.2.0 (Granite Data Services).
 *
 * NOTE: this file is only generated if it does not exist. You may safely put
 * your custom code here.
 */

package org.openforis.collect.model.proxy {
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ArrayList;
	import mx.collections.IList;
	
	import org.granite.collections.IMap;
	import org.openforis.collect.metamodel.proxy.AttributeDefinitionProxy;
	import org.openforis.collect.metamodel.proxy.EntityDefinitionProxy;
	import org.openforis.collect.util.CollectionUtil;
	import org.openforis.collect.util.StringUtil;

    [Bindable]
    [RemoteClass(alias="org.openforis.collect.model.proxy.EntityProxy")]
    public class EntityProxy extends EntityProxyBase {
		
		private var nodesMap:Dictionary;
		
		public function getSingleAttribute(attributeName:String):AttributeProxy {
			var attributes:IList = childrenByName.get(attributeName);
			if(attributes != null) {
				if(attributes.length == 1) {
					var attribute:AttributeProxy = attributes.getItemAt(0) as AttributeProxy;
					return attribute;
				} else if (attributes.length > 1) {
					throw new Error("Single attribute expected");
				}
			}
			return null;
		}
		
		public function getChildren(nodeName:String = null):IList {
			if(nodeName != null) {
				return childrenByName.get(nodeName);
			} else {
				var result:ArrayCollection = new ArrayCollection();
				var listsOfChildren:ArrayCollection = childrenByName.values;
				for each (var list:IList in listsOfChildren) {
					result.addAll(list);
				}
				return result;
			}
		}

		public function getChild(nodeName:String, index:int):NodeProxy {
			var children:IList = getChildren(nodeName);
			if(children != null && children.length > index) {
				return children.getItemAt(index) as NodeProxy;
			} else {
				return null;
			}
		}
		
		public function getChildById(id:int):NodeProxy {
			if(nodesMap == null) {
				nodesMap = new Dictionary();
			}
			var child:NodeProxy = nodesMap[id];
			if(child != null) {
				return child;
			} else {
				var values:ArrayCollection = childrenByName.values;
				for each (var childList:IList in values) {
					for each (child in childList) {
						if(child.id == id) {
							nodesMap[id] = child;
							return child;
						}
					}
				}
			}
			return null;
		}
		
		public function getNode(id:int):NodeProxy {
			var child:NodeProxy = getChildById(id);
			if(child != null) {
				return child;
			} else {
				//search in child entities
				var entities:IList = getChildEntities();
				for each (var e:EntityProxy in entities) {
					child = e.getNode(id);
					if(child != null) {
						return child;
					}
				}
			}
			return null;
		}
		
		public function getChildEntities():IList {
			var entities:IList = new ArrayCollection();
			var values:IList = childrenByName.values;
			for each (var childList:IList in values) {
				for each (var child:NodeProxy in childList) {
					if(child is EntityProxy) {
						entities.addItem(child);
					}
				}
			}
			return entities;
		}
		
		public function addChild(node:NodeProxy):void {
			var name:String = node.name;
			var children:ArrayCollection = childrenByName.get(name);
			if(children == null) {
				children = new ArrayCollection();
				childrenByName.put(name, children);
			}
			children.addItem(node);
			if(nodesMap != null) {
				nodesMap[node.id] = node;
			}
		}
		
		public function removeChild(node:NodeProxy):void {
			var name:String = node.name;
			var children:IList = childrenByName.get(name);
			var index:int = children.getItemIndex(node);
			if(index >= 0) {
				children.removeItemAt(index);
				if(nodesMap != null) {
					nodesMap[node.id] = null;
				}
			}
		}
		
		public function replaceChild(oldNode:NodeProxy, newNode:NodeProxy):void {
			var name:String = oldNode.name;
			var children:ArrayCollection = childrenByName.get(name);
			var index:int = children.getItemIndex(oldNode);
			children.setItemAt(newNode, index);
			if(nodesMap != null) {
				nodesMap[oldNode.id] = newNode;
			}
		}
		
		public function getKeyLabel(entityDefinition:EntityDefinitionProxy):String {
			var keyDefs:IList = entityDefinition.keyAttributeDefinitions;
			var keyParts:Array = new Array();
			for each (var def:AttributeDefinitionProxy in keyDefs) {
				var key:AttributeProxy = getSingleAttribute(def.name);
				if(key != null) {
					var value:Object = key.getField(0).value;
					if(value != null) {
						var keyPart:String = value.toString();
						if(StringUtil.isNotBlank(keyPart)) {
							keyParts.push(keyPart);
						}
					}
				}
			}
			return StringUtil.concat(" - ", keyParts);
		}
		
		public function updateChildrenMinCountValiditationMap(map:IMap):void {
			CollectionUtil.updateMap(childrenMinCountValidationMap, map);
		}
		
		public function updateChildrenMaxCountValiditationMap(map:IMap):void {
			CollectionUtil.updateMap(childrenMaxCountValidationMap, map);
		}

		public function updateChildrenRelevanceMap(map:IMap):void {
			CollectionUtil.updateMap(childrenRelevanceMap, map);
		}

		public function updateChildrenRequiredMap(map:IMap):void {
			CollectionUtil.updateMap(childrenRequiredMap, map);
		}
	}
}