package de.diedavids.ddcdit.listener;

import de.diedavids.ddcdit.entity.mlb.MlbPlayerSponsor;
import org.springframework.context.ApplicationEvent;

public class NewSponsorArrived extends ApplicationEvent {

    MlbPlayerSponsor sponsor;

    public NewSponsorArrived(Object source, MlbPlayerSponsor sponsor) {
        super(source);
        this.sponsor = sponsor;
    }

    public MlbPlayerSponsor getSponsor() {
        return sponsor;
    }
}
