import { UIModelObjectDefinition } from './UIModelObjectDefinition';
import { TabContainers } from './TabContainers';

export class TabDefinition extends UIModelObjectDefinition {

    items = [];
    tabs = [];
    totalColumns;
    totalRows;
    
    constructor(id, parent) {
        super(id, parent);
        this.items = [];
        this.tabs = [];
    }
    
    fillFromJSON(jsonObj) {
        super.fillFromJSON(jsonObj);
        this.tabs = TabContainers.createTabsFromJSON(jsonObj.tabs, this);
        this.items = TabContainers.createItemsFromJSON(jsonObj.children, this);
    }
    
}
