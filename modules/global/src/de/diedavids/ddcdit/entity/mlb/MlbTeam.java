package de.diedavids.ddcdit.entity.mlb;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.UniqueConstraint;

@NamePattern("%s|name")
@Table(name = "DDCDIT_MLB_TEAM", uniqueConstraints = {
    @UniqueConstraint(name = "IDX_DDCDIT_MLB_TEAM_UNQ", columnNames = {"CODE", "DELETE_TS"})
})
@Entity(name = "ddcdit$MlbTeam")
public class MlbTeam extends StandardEntity {
    private static final long serialVersionUID = 5386043646213520645L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "STATE")
    protected String state;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    public void setState(State state) {
        this.state = state == null ? null : state.getId();
    }

    public State getState() {
        return state == null ? null : State.fromId(state);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}