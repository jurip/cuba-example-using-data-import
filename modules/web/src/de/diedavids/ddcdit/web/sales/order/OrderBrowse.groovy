package de.diedavids.ddcdit.web.sales.order

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.GroupTable
import de.diedavids.cuba.dataimport.web.WithImport
import de.diedavids.ddcdit.entity.sales.Order
import de.diedavids.ddcdit.web.RemoveAllLookup

import javax.inject.Inject

@WithImport(listComponent = "ordersTable")
class OrderBrowse extends RemoveAllLookup {


    @Inject
    protected GroupTable<Order> ordersTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(ordersTable, removeAllBtn);
    }
}