package de.diedavids.ddcdit.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import de.diedavids.cuba.dataimport.DataImportAPI;
import de.diedavids.cuba.dataimport.entity.ImportConfiguration;
import de.diedavids.cuba.dataimport.entity.ImportLog;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(MlbTeamImportService.NAME)
public class MlbTeamImportServiceBean implements MlbTeamImportService {

    @Inject
    protected DataImportAPI dataImportAPI;

    @Inject
    protected DataManager dataManager;


    @Override
    public ImportLog importMlbTeams(FileDescriptor fileDescriptor) {
        ImportConfiguration importConfiguration = loadImportConfigurationForMlbTeam();
        try {
            return dataImportAPI.importFromFile(importConfiguration, fileDescriptor);
        } catch (FileStorageException e) {
            e.printStackTrace();
            return createFailedImportLog(importConfiguration);
        }
    }

    private ImportLog createFailedImportLog(ImportConfiguration importConfiguration) {
        ImportLog importLog = dataManager.create(ImportLog.class);
        importLog.setConfiguration(importConfiguration);
        importLog.setSuccess(false);
        return importLog;
    }

    private ImportConfiguration loadImportConfigurationForMlbTeam() {
        return dataManager.load(ImportConfiguration.class)
                .query("select e from ddcdi$ImportConfiguration e where e.entityClass = :entityClass")
                .parameter("entityClass", "ddcdit$MlbTeam")
                .view("importConfiguration-view")
                .one();
    }
}