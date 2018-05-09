package com.zty.jobster.dao;

import com.zty.jobster.entity.PostMessage;
import com.zty.jobster.entity.PostMessageId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface PostMessageDao {

//    List<PostMessage> getMessageByPk(int sid,int rid);
    List<PostMessage> getMessageBySender(Student sender);
    List<PostMessage> getMessageByReceiver(Student receiver);
    void addMessage(PostMessage postMessage);
//    void deleteMessage(PostMessageId postMessageId);
}
