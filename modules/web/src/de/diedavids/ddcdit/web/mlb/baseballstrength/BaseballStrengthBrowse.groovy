package de.diedavids.ddcdit.web.mlb.baseballstrength


import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.GroupTable
import de.diedavids.cuba.dataimport.web.WithImport
import de.diedavids.ddcdit.entity.mlb.MlbPlayer
import de.diedavids.ddcdit.web.RemoveAllAbstractLookup

import javax.inject.Inject

@WithImport(listComponent = "baseballStrengthsTable")
class BaseballStrengthBrowse extends RemoveAllAbstractLookup {


    @Inject
    protected GroupTable<MlbPlayer> baseballStrengthsTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(baseballStrengthsTable, removeAllBtn);
    }
}