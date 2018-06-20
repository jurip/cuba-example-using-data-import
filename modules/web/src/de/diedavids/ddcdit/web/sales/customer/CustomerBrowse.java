package de.diedavids.ddcdit.web.sales.customer;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import de.diedavids.ddcdit.entity.sales.Customer;
import de.diedavids.ddcdit.web.RemoveAllLookup;

import javax.inject.Inject;
import java.util.Map;

public class CustomerBrowse extends RemoveAllLookup {

    @Inject
    protected GroupTable<Customer> customersTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        initRemoveAllAction(customersTable, removeAllBtn);
    }

}