package com.zty.jobster.entity;

import com.zty.jobster.entity.Enum.JobApplyStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jobapply")
@AssociationOverrides({
        @AssociationOverride(name = "pk.job",
                joinColumns = @JoinColumn(name = "jid")),
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "sid")) })
public class Jobapply implements Serializable{

    private static final long serialVersionUID = 5742307014512990941L;

    @EmbeddedId
    private JobapplyId pk = new JobapplyId();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private JobApplyStatus status;

    public Jobapply(JobapplyId pk, JobApplyStatus status) {
        this.pk = pk;
        this.status = status;
    }

    public Jobapply() {
    }

    public JobapplyId getPk() {
        return pk;
    }

    public void setPk(JobapplyId pk) {
        this.pk = pk;
    }

    public JobApplyStatus getStatus() {
        return status;
    }

    public void setStatus(JobApplyStatus status) {
        this.status = status;
    }
}
