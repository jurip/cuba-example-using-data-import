package de.diedavids.ddcdit.web.mlb.mlbteam;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.screen.MessageBundle;
import com.haulmont.cuba.gui.screen.OpenMode;
import de.diedavids.cuba.dataimport.web.WithImport;
import de.diedavids.ddcdit.entity.mlb.MlbPlayer;
import de.diedavids.ddcdit.service.MlbTeamImportService;
import de.diedavids.ddcdit.web.RemoveAllAbstractLookup;
import de.diedavids.ddcdit.web.RemoveAllAction;

import javax.inject.Inject;
import java.util.Map;

@WithImport(listComponent = "mlbTeamsTable")
public class MlbTeamBrowse extends RemoveAllAbstractLookup {


    @Inject
    protected GroupTable<MlbPlayer> mlbTeamsTable;

    @Inject
    protected Button removeAllBtn;
    @Inject
    protected Button importFromFileBtn;
    @Inject
    protected ScreenBuilders screenBuilders;
    @Inject
    protected MlbTeamImportService mlbTeamImportService;
    @Inject
    protected MessageBundle messageBundle;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initRemoveAllAction(mlbTeamsTable, removeAllBtn);

        initImportFromFileAction(mlbTeamsTable, importFromFileBtn);
    }

    protected void initImportFromFileAction(Table table, Button targetBtn) {
        BaseAction baseAction = new BaseAction("importFromFile")
                .withCaption(messageBundle.getMessage("importFromFile"))
                .withIcon(CubaIcon.UPLOAD.source())
                .withHandler(actionPerformedEvent -> {
                    screenBuilders.lookup(FileDescriptor.class, this)
                            .withSelectHandler(fileDescriptors -> mlbTeamImportService.importMlbTeams(fileDescriptors.iterator().next()))
                            .withOpenMode(OpenMode.DIALOG)
                            .show();
                });

        table.addAction(baseAction);
        targetBtn.setAction(baseAction);
    }
}