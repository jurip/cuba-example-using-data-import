package de.diedavids.ddcdit.web.customer;

import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.web.WithImportWizard;
import de.diedavids.ddcdit.entity.sales.Customer;

import javax.inject.Inject;

@UiController("ddcdit$Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {

}