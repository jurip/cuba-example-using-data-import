package de.diedavids.ddcdit.web;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.actions.BaseAction;

public class RemoveAllAction extends BaseAction {

    DataManager dataManager = AppBeans.get(DataManager.NAME);

    public RemoveAllAction() {
        super("removeAll");
        setCaption("Remove All");
        setIcon("REMOVE");
    }

    @Override
    public void actionPerform(Component component) {
        target.getDatasource().getItems().forEach(item -> dataManager.remove((Entity) item));

        target.getDatasource().refresh();
    }
}
