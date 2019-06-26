package de.diedavids.ddcdit.web.mlbplayersponsor;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.ddcdit.entity.mlb.MlbPlayerSponsor;

@UiController("ddcdit_MlbPlayerSponsor.edit")
@UiDescriptor("mlb-player-sponsor-edit.xml")
@EditedEntityContainer("mlbPlayerSponsorDc")
@LoadDataBeforeShow
public class MlbPlayerSponsorEdit extends StandardEditor<MlbPlayerSponsor> {
}