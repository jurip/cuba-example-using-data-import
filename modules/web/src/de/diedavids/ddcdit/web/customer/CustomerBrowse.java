package de.diedavids.ddcdit.web.customer;

import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.web.WithImportWizard;
import de.diedavids.ddcdit.entity.sales.Customer;

import javax.inject.Inject;

@UiController("ddcdit$Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> implements WithImportWizard {


    @Inject
    protected CollectionContainer<Customer> customersDc;

    @Inject
    protected GroupTable<Customer> customersTable;

    @Inject
    protected ButtonsPanel buttonsPanel;

    @Override
    public ListComponent getListComponent() {
        return customersTable;
    }

    @Override
    public CollectionContainer getCollectionContainer() {
        return customersDc;
    }

    @Override
    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }
}