package de.diedavids.ddcdit.web.sales.product

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.GroupTable
import de.diedavids.cuba.dataimport.web.WithImport
import de.diedavids.ddcdit.entity.sales.Order
import de.diedavids.ddcdit.web.RemoveAllLookup

import javax.inject.Inject

@WithImport(listComponent = "productsTable")
class ProductBrowse extends RemoveAllLookup {


    @Inject
    protected GroupTable<Order> productsTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(productsTable, removeAllBtn);
    }
}