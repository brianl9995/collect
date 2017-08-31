import { Identifiable } from '../Identifiable';
import { Serializable } from '../Serializable';
import { UIConfiguration } from './UIConfiguration';
import { TabSetDefinition } from './TabSetDefinition';
import { Survey } from '../Survey';

export class UIModelObjectDefinition extends Serializable implements Identifiable {
    parent;
    id;
    hidden;
    
    constructor(id, parent) {
        super();
        this.id = id;
        this.parent = parent;
    }
    
    get rootTabSet() {
        let currentObj = this;
        while (currentObj.parent != null) {
            currentObj = currentObj.parent;
        }
        return currentObj;
    }
    
    get uiConfiguration() {
        return this.rootTabSet.uiConfiguration;
    }
    
    get survey() {
        return this.rootTabSet.survey;
    }

}
