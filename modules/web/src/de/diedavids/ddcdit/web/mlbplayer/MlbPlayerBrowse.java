package de.diedavids.ddcdit.web.mlbplayer;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import de.diedavids.ddcdit.entity.mlb.MlbPlayer;
import de.diedavids.ddcdit.web.RemoveAllLookup;

import javax.inject.Inject;
import java.util.Map;

public class MlbPlayerBrowse extends RemoveAllLookup {


    @Inject
    protected GroupTable<MlbPlayer> mlbPlayersTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        initRemoveAllAction(mlbPlayersTable, removeAllBtn);
    }

}