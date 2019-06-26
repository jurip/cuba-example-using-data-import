package de.diedavids.ddcdit.service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import de.diedavids.cuba.dataimport.entity.ImportLog;

public interface MlbTeamImportService {
    String NAME = "ddcdit_MlbTeamImportService";

    ImportLog importMlbTeams(FileDescriptor fileDescriptor);
}