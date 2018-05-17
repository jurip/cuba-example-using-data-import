package de.diedavids.ddcdit.web;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import de.diedavids.ddcdit.entity.mlb.MlbTeam;

import javax.inject.Inject;
import java.util.Map;

public class RemoveAllLookup extends AbstractLookup {

    protected void initRemoveAllAction(Table table, Button removeAllBtn) {
        RemoveAllAction removeAllAction = new RemoveAllAction();
        table.addAction(removeAllAction);
        removeAllBtn.setAction(removeAllAction);
    }
}