package de.diedavids.ddcdit.web.screens.datatypeexample;

import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.web.WithImportWizard;
import de.diedavids.ddcdit.entity.DatatypeExample;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UiController("ddcdit_DatatypeExample.browse")
@UiDescriptor("datatype-example-browse.xml")
@LookupComponent("datatypeExamplesTable")
@LoadDataBeforeShow
public class DatatypeExampleBrowse extends StandardLookup<DatatypeExample> implements WithImportWizard {
    @Inject
    protected GroupTable<DatatypeExample> datatypeExamplesTable;
    @Inject
    protected CollectionContainer<DatatypeExample> datatypeExamplesDc;
    @Inject
    protected ButtonsPanel buttonsPanel;

    @Subscribe
    protected void onInit(InitEvent event) {
        LocalDateTime.parse("2020-01-02 15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Override
    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    @Override
    public ListComponent getListComponent() {
        return datatypeExamplesTable;
    }

    @Override
    public CollectionContainer getCollectionContainer() {
        return datatypeExamplesDc;
    }
}

