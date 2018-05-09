package com.zty.jobster.service;

import com.zty.jobster.entity.PostMessage;

import java.util.List;

public interface PostMessageService {
//    List<PostMessage> getMessageByPk(int sid,int rid);
    List<PostMessage> getMessageBySender(int sid);
    List<PostMessage> getMessageByReceiver(int rid);
    void addMessage(int sid,int rid,String message);
//    void deleteMessage(int sid,int rid);
}
