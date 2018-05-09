package com.zty.jobster.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "postmessage")
@AssociationOverrides({
        @AssociationOverride(name = "pk.sender",
                joinColumns = @JoinColumn(name = "senderid")),
        @AssociationOverride(name = "pk.receiver",
                joinColumns = @JoinColumn(name = "receiverid")) })
public class PostMessage implements Serializable{

    private static final long serialVersionUID = -6559747562901154382L;

    @EmbeddedId
    private PostMessageId pk = new PostMessageId();



    @Column(name = "pm")
    private String content;

    public PostMessage(PostMessageId pk, String content) {
        this.pk = pk;
        this.content = content;
    }

    public PostMessage() {
    }

    public PostMessageId getPk() {
        return pk;
    }

    public void setPk(PostMessageId pk) {
        this.pk = pk;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
