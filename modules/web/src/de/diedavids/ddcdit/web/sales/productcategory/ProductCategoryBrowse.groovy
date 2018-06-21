package de.diedavids.ddcdit.web.sales.productcategory

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.TreeTable
import de.diedavids.cuba.dataimport.web.WithImport
import de.diedavids.ddcdit.entity.sales.ProductCategory
import de.diedavids.ddcdit.web.RemoveAllLookup

import javax.inject.Inject

@WithImport(listComponent = "productCategoriesTable")
class ProductCategoryBrowse extends RemoveAllLookup {


    @Inject
    protected TreeTable<ProductCategory> productCategoriesTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(productCategoriesTable, removeAllBtn);
    }
}