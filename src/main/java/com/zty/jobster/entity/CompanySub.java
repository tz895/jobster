package com.zty.jobster.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Entity
@Table(name = "companysub")
@AssociationOverrides({
        @AssociationOverride(name = "pk.company",
                joinColumns = @JoinColumn(name = "cid")),
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "sid")) })
public class CompanySub implements Serializable{


    private static final long serialVersionUID = -5481217643610273314L;

    @EmbeddedId
    private CompanySubId pk = new CompanySubId();

    public CompanySub(CompanySubId pk) {
        this.pk = pk;
    }

    public CompanySub() {
    }

    public CompanySubId getPk() {
        return pk;
    }

    public void setPk(CompanySubId pk) {
        this.pk = pk;
    }
}
