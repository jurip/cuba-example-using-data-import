package de.diedavids.ddcdit.entity.mlb;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|sponsorName")
@Table(name = "DDCDIT_MLB_PLAYER_SPONSOR")
@Entity(name = "ddcdit_MlbPlayerSponsor")
public class MlbPlayerSponsor extends StandardEntity {
    private static final long serialVersionUID = 7927892719740451637L;

    @Column(name = "SPONSOR_NAME")
    protected String sponsorName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPONSORED_PLAYERS_FILE_ID")
    protected FileDescriptor sponsoredPlayersFile;

    @OneToMany(mappedBy = "sponsor")
    protected List<MlbPlayer> sponsoredPlayers;

    public List<MlbPlayer> getSponsoredPlayers() {
        return sponsoredPlayers;
    }

    public void setSponsoredPlayers(List<MlbPlayer> sponsoredPlayers) {
        this.sponsoredPlayers = sponsoredPlayers;
    }

    public FileDescriptor getSponsoredPlayersFile() {
        return sponsoredPlayersFile;
    }

    public void setSponsoredPlayersFile(FileDescriptor sponsoredPlayersFile) {
        this.sponsoredPlayersFile = sponsoredPlayersFile;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }
}