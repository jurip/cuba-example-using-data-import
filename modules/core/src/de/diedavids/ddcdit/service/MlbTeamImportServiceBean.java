package de.diedavids.ddcdit.service;

import com.google.common.collect.Lists;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import de.diedavids.cuba.dataimport.DataImportAPI;
import de.diedavids.cuba.dataimport.entity.ImportConfiguration;
import de.diedavids.cuba.dataimport.entity.ImportExecution;
import de.diedavids.cuba.dataimport.entity.ImportExecutionDetail;
import de.diedavids.cuba.dataimport.entity.ImportExecutionDetailCategory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(MlbTeamImportService.NAME)
public class MlbTeamImportServiceBean implements MlbTeamImportService {

    @Inject
    protected DataImportAPI dataImportAPI;

    @Inject
    protected DataManager dataManager;


    @Override
    public ImportExecution importMlbTeams(FileDescriptor fileDescriptor) {
        ImportConfiguration importConfiguration = loadImportConfigurationForMlbTeam();
        try {
            return dataImportAPI.importFromFile(importConfiguration, fileDescriptor);
        } catch (FileStorageException e) {
            e.printStackTrace();
            return createFailedImportExecution(importConfiguration);
        }
    }

    private ImportExecution createFailedImportExecution(ImportConfiguration importConfiguration) {

        ImportExecution importExecution = dataManager.create(ImportExecution.class);
        importExecution.setConfiguration(importConfiguration);
        importExecution.setSuccess(false);

        List<ImportExecutionDetail> executionDetails = Lists.newArrayList();

        ImportExecutionDetail errorDetail = dataManager.create(ImportExecutionDetail.class);

        errorDetail.setCategory(ImportExecutionDetailCategory.PERSISTENCE);
        errorDetail.setImportExecution(importExecution);
        errorDetail.setMessage("Failed to open file");


        executionDetails.add(errorDetail);

        importExecution.setDetails(executionDetails);

        CommitContext commitContext = new CommitContext();
        commitContext.addInstanceToCommit(importExecution);
        commitContext.addInstanceToCommit(errorDetail);

        dataManager.commit(commitContext);

        return importExecution;
    }

    private ImportConfiguration loadImportConfigurationForMlbTeam() {
        return dataManager.load(ImportConfiguration.class)
                .query("select e from ddcdi$ImportConfiguration e where e.entityClass = :entityClass")
                .parameter("entityClass", "ddcdit$MlbTeam")
                .view("importConfiguration-view")
                .one();
    }
}