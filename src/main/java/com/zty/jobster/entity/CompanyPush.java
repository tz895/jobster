package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zty.jobster.entity.Enum.CompanyPushStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "companypush",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"jid", "sid"}))
@AssociationOverrides({
        @AssociationOverride(name = "pk.job",
                joinColumns = @JoinColumn(name = "jid")),
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "sid")) })
public class CompanyPush implements Serializable{

    private static final long serialVersionUID = 8055025578793374444L;

    @EmbeddedId
    private CompanyPushId pk = new CompanyPushId();

    @Column(name = "push_time")
    private LocalDateTime push_time;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CompanyPushStatus status;

    public CompanyPush(CompanyPushId pk, LocalDateTime push_time, CompanyPushStatus status) {
        this.pk = pk;
        this.push_time = push_time;
        this.status = status;
    }

    public CompanyPush() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CompanyPushId getPk() {
        return pk;
    }

    public void setPk(CompanyPushId pk) {
        this.pk = pk;
    }

    public LocalDateTime getPush_time() {
        return push_time;
    }

    public void setPush_time(LocalDateTime push_time) {
        this.push_time = push_time;
    }

    public CompanyPushStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyPushStatus status) {
        this.status = status;
    }
}


