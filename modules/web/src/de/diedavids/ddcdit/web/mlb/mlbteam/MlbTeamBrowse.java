package de.diedavids.ddcdit.web.mlb.mlbteam;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import de.diedavids.ddcdit.entity.mlb.MlbTeam;
import de.diedavids.ddcdit.web.RemoveAllLookup;

import javax.inject.Inject;
import java.util.Map;

public class MlbTeamBrowse extends RemoveAllLookup {


    @Inject
    protected GroupTable<MlbTeam> mlbTeamsTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        initRemoveAllAction(mlbTeamsTable, removeAllBtn);
    }

}