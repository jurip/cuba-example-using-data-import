package de.diedavids.ddcdit.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import de.diedavids.cuba.dataimport.entity.ImportExecution;

public interface MlbTeamImportService {
    String NAME = "ddcdit_MlbTeamImportService";

    ImportExecution importMlbTeams(FileDescriptor fileDescriptor);
}