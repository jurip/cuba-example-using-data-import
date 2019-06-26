package de.diedavids.ddcdit.web.mlbplayersponsor;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.ddcdit.entity.mlb.MlbPlayerSponsor;

@UiController("ddcdit_MlbPlayerSponsor.browse")
@UiDescriptor("mlb-player-sponsor-browse.xml")
@LookupComponent("mlbPlayerSponsorsTable")
@LoadDataBeforeShow
public class MlbPlayerSponsorBrowse extends StandardLookup<MlbPlayerSponsor> {
}