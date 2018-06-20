package de.diedavids.ddcdit.web.mlb.mlbplayer;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup;
import de.diedavids.cuba.dataimport.web.WithImport;
import de.diedavids.ddcdit.entity.mlb.MlbPlayer;
import de.diedavids.ddcdit.web.RemoveAllAction;

import javax.inject.Inject;
import java.util.Map;

@WithImport(listComponent = "mlbPlayersTable")
public class MlbPlayerBrowse extends AnnotatableAbstractLookup {


    @Inject
    protected GroupTable<MlbPlayer> mlbPlayersTable;

    @Inject
    protected Button removeAllBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(mlbPlayersTable, removeAllBtn);
    }



    protected void initRemoveAllAction(Table table, Button removeAllBtn) {
        RemoveAllAction removeAllAction = new RemoveAllAction();
        table.addAction(removeAllAction);
        removeAllBtn.setAction(removeAllAction);
    }
}