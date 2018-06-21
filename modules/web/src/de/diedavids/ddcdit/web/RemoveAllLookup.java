package de.diedavids.ddcdit.web;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup;

public class RemoveAllLookup extends AnnotatableAbstractLookup {

    protected void initRemoveAllAction(Table table, Button removeAllBtn) {
        RemoveAllAction removeAllAction = new RemoveAllAction();
        table.addAction(removeAllAction);
        removeAllBtn.setAction(removeAllAction);
    }
}