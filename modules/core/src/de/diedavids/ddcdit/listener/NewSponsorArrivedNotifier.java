package de.diedavids.ddcdit.listener;

import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Events;
import de.diedavids.cuba.dataimport.DataImportAPI;
import de.diedavids.cuba.dataimport.entity.ImportConfiguration;
import de.diedavids.ddcdit.entity.mlb.MlbPlayerSponsor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("ddcdit_NewSponsorArrivedNotifier")
public class NewSponsorArrivedNotifier {

    @Inject
    protected DataManager dataManager;

    @Inject
    protected Events events;


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    private void afterCommit(EntityChangedEvent<MlbPlayerSponsor, UUID> event) {
        Id<MlbPlayerSponsor, UUID> entityId = event.getEntityId();

        if (event.getType().equals(EntityChangedEvent.Type.CREATED)) {
            MlbPlayerSponsor sponsor = dataManager
                    .load(entityId)
                    .view("mlbPlayerSponsor-view")
                    .one();

            events.publish(new NewSponsorArrived(this, sponsor));

        }
    }
}
