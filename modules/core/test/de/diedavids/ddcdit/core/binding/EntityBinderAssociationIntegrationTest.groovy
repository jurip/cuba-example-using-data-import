package de.diedavids.ddcdit.core.binding

import de.diedavids.cuba.dataimport.dto.ImportData
import de.diedavids.cuba.dataimport.entity.ImportAttributeMapper
import de.diedavids.cuba.dataimport.entity.ImportConfiguration
import de.diedavids.ddcdit.entity.mlb.MlbPlayer
import de.diedavids.ddcdit.entity.mlb.MlbTeam
import de.diedavids.ddcdit.entity.mlb.State
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

class EntityBinderAssociationIntegrationTest extends AbstractEntityBinderIntegrationTest {


    @Before
    void setUp() throws Exception {
        super.setUp()

        clearTable("DDCDIT_MLB_PLAYER")
        clearTable("DDCDIT_MLB_TEAM")
    }

    @Test
    void "bindAttributes creates an Entity with a association value"() {


        ImportData importData = createData([
                [team: "BAL"]
        ])


        MlbTeam balTeam = metadata.create(MlbTeam)
        balTeam.name = 'Baltimore Orioles'
        balTeam.code = 'BAL'
        balTeam.state = State.MA

        dataManager.commit(balTeam)

        importConfiguration = new ImportConfiguration(
                entityClass: 'ddcdi$MlbPlayer',
                importAttributeMappers: [
                        new ImportAttributeMapper(entityAttribute: 'ddcdi$MlbPlayer.team.code', fileColumnAlias: 'team'),
                ]
        )


        MlbPlayer entity = sut.bindAttributes(importConfiguration, importData.rows[0], new MlbPlayer()) as MlbPlayer


        org.assertj.core.api.Assertions.assertThat(entity.getTeam()).isEqualTo(balTeam)

        cont.deleteRecord(balTeam)
    }


    @Test
    void "bindAttributes creates an Entity with a non-unique association value"() {


        ImportData importData = createData([
                [team_state: "MA"]
        ])


        MlbTeam team1InMaryland = metadata.create(MlbTeam)
        team1InMaryland.name = 'Baltimore Orioles'
        team1InMaryland.code = 'BAL'
        team1InMaryland.state = State.MA

        MlbTeam team2InMaryland = metadata.create(MlbTeam)
        team2InMaryland.name = 'Hagerstown Owls'
        team2InMaryland.code = 'HOW'
        team2InMaryland.state = State.MA

        dataManager.commit(team1InMaryland)
        dataManager.commit(team2InMaryland)

        importConfiguration = new ImportConfiguration(
                entityClass: 'ddcdi$MlbPlayer',
                importAttributeMappers: [
                        new ImportAttributeMapper(entityAttribute: 'ddcdi$MlbPlayer.team.state', fileColumnAlias: 'team_state'),
                ]
        )


        MlbPlayer entity = sut.bindAttributes(importConfiguration, importData.rows[0], new MlbPlayer()) as MlbPlayer


        Assertions.assertThat(entity.getTeam()).isNull()

        cont.deleteRecord(team1InMaryland)
        cont.deleteRecord(team2InMaryland)
    }

}