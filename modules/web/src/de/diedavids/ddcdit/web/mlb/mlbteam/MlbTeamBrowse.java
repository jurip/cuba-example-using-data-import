package de.diedavids.ddcdit.web.mlb.mlbteam;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import de.diedavids.cuba.dataimport.web.WithImport;
import de.diedavids.ddcdit.entity.mlb.MlbPlayer;
import de.diedavids.ddcdit.entity.mlb.MlbTeam;
import de.diedavids.ddcdit.web.RemoveAllLookup;

import javax.inject.Inject;
import java.util.Map;

@WithImport(listComponent = "mlbTeamsTable")
public class MlbTeamBrowse extends RemoveAllLookup {


    @Inject
    protected GroupTable<MlbPlayer> mlbTeamsTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(mlbTeamsTable, removeAllBtn);
    }
}