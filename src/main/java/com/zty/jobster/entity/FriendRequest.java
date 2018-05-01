package com.zty.jobster.entity;

import com.zty.jobster.entity.Enum.FriendRequestStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "friendrequest")
@AssociationOverrides({
        @AssociationOverride(name = "pk.sender",
                joinColumns = @JoinColumn(name = "senderid")),
        @AssociationOverride(name = "pk.receiver",
                joinColumns = @JoinColumn(name = "receiverid")) })
public class FriendRequest implements Serializable{


    private static final long serialVersionUID = 4069243131872787390L;

    @EmbeddedId
    private FriendRequestId pk = new FriendRequestId();

    @Column(name = "request_time")
    private LocalDateTime request_time;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FriendRequestStatus status;

    public FriendRequest(FriendRequestId pk, LocalDateTime request_time, FriendRequestStatus status) {
        this.pk = pk;
        this.request_time = request_time;
        this.status = status;
    }

    public FriendRequest() {
    }

    public FriendRequestId getPk() {
        return pk;
    }

    public void setPk(FriendRequestId pk) {
        this.pk = pk;
    }

    public LocalDateTime getRequest_time() {
        return request_time;
    }

    public void setRequest_time(LocalDateTime request_time) {
        this.request_time = request_time;
    }

    public FriendRequestStatus getStatus() {
        return status;
    }

    public void setStatus(FriendRequestStatus status) {
        this.status = status;
    }
}
