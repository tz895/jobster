package com.zty.jobster.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friendrelation")
@AssociationOverrides({
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "sid")),
        @AssociationOverride(name = "pk.friend",
                joinColumns = @JoinColumn(name = "fid")) })
public class FriendRelation implements Serializable{


    private static final long serialVersionUID = 5264196162518226976L;

    @EmbeddedId
    private FriendRelationId pk = new FriendRelationId();

    public FriendRelation(FriendRelationId pk) {
        this.pk = pk;
    }

    public FriendRelation() {
    }

    public FriendRelationId getPk() {
        return pk;
    }

    public void setPk(FriendRelationId pk) {
        this.pk = pk;
    }
}
