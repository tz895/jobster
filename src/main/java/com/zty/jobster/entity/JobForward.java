package com.zty.jobster.entity;

import com.zty.jobster.entity.Enum.FriendRequestStatus;
import com.zty.jobster.entity.Enum.JobForwardStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobforward")
@AssociationOverrides({
        @AssociationOverride(name = "pk.sender",
                joinColumns = @JoinColumn(name = "senderid")),
        @AssociationOverride(name = "pk.job",
                joinColumns = @JoinColumn(name = "jid")),
        @AssociationOverride(name = "pk.receiver",
                joinColumns = @JoinColumn(name = "receiverid")) })
public class JobForward implements Serializable {

    private static final long serialVersionUID = 628879167466383688L;

    @EmbeddedId
    private JobForwardId pk = new JobForwardId();

    @Column(name = "forward_time")
    private LocalDateTime forward_time;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private JobForwardStatus status;

    public JobForward(JobForwardId pk, LocalDateTime forward_time, JobForwardStatus status) {
        this.pk = pk;
        this.forward_time = forward_time;
        this.status = status;
    }

    public JobForward() {
    }

    public JobForwardId getPk() {
        return pk;
    }

    public void setPk(JobForwardId pk) {
        this.pk = pk;
    }

    public LocalDateTime getForward_time() {
        return forward_time;
    }

    public void setForward_time(LocalDateTime forward_time) {
        this.forward_time = forward_time;
    }

    public JobForwardStatus getStatus() {
        return status;
    }

    public void setStatus(JobForwardStatus status) {
        this.status = status;
    }
}
