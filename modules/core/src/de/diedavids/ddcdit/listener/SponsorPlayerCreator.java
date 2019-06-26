package de.diedavids.ddcdit.listener;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.importexport.ReferenceImportBehaviour;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.security.app.Authentication;
import de.diedavids.cuba.dataimport.DataImportAPI;
import de.diedavids.cuba.dataimport.entity.ImportConfiguration;
import de.diedavids.ddcdit.entity.mlb.MlbPlayerSponsor;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class SponsorPlayerCreator implements ApplicationListener<NewSponsorArrived> {

    @Inject
    protected Authentication authentication;

    @Inject
    protected TransactionalDataManager dataManager;


    @Inject
    protected DataImportAPI dataImportAPI;
    @Inject
    protected Persistence persistence;


    @Async
    @Override
    public void onApplicationEvent(NewSponsorArrived event) {

        MlbPlayerSponsor sponsor = event.getSponsor();

        Transaction transaction = persistence.createTransaction();
        try {
            dataImportAPI.importFromFile(
                    loadImportConfigurationForMlbPlayer(),
                    sponsor.getSponsoredPlayersFile(),
                    ParamsMap.of("sponsor", sponsor),
                    entityImportView -> entityImportView.addManyToOneProperty("sponsor", ReferenceImportBehaviour.IGNORE_MISSING)
            );
        } catch (FileStorageException e) {
            e.printStackTrace();
        }
        finally {
            transaction.end();
        }
    }


    private ImportConfiguration loadImportConfigurationForMlbPlayer() {
        return dataManager.load(ImportConfiguration.class)
                .query("select e from ddcdi$ImportConfiguration e where e.entityClass = :entityClass")
                .parameter("entityClass", "ddcdit$MlbPlayer")
                .view("importConfiguration-view")
                .one();
    }

}
