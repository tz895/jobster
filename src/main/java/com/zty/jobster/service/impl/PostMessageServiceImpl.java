package com.zty.jobster.service.impl;

import com.zty.jobster.dao.PostMessageDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.PostMessage;
import com.zty.jobster.entity.PostMessageId;
import com.zty.jobster.service.PostMessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostMessageServiceImpl implements PostMessageService{

    private PostMessageDao postMessageDao;

    private StudentDao studentDao;

    public PostMessageServiceImpl(PostMessageDao postMessageDao, StudentDao studentDao) {
        this.postMessageDao = postMessageDao;
        this.studentDao = studentDao;
    }

//    @Override
//    public List<PostMessage> getMessageByPk(int sid, int rid) {
//        return postMessageDao.getMessageByPk(int sid, int rid);
//    }

    @Override
    public List<PostMessage> getMessageBySender(int sid) {
        return postMessageDao.getMessageBySender(studentDao.getStudentById(sid));
    }

    @Override
    public List<PostMessage> getMessageByReceiver(int rid) {
        return postMessageDao.getMessageByReceiver(studentDao.getStudentById(rid));
    }

    @Override
    public void addMessage(int sid,int rid,String message) {
        PostMessage postMessage = new PostMessage();
        postMessage.setPk(new PostMessageId(studentDao.getStudentById(sid),studentDao.getStudentById(rid),LocalDateTime.now()));
        postMessage.setContent(message);
        postMessageDao.addMessage(postMessage);
    }

//    @Override
//    public void deleteMessage(int sid,int rid) {
//        postMessageDao.deleteMessage(new PostMessageId(studentDao.getStudentById(sid),studentDao.getStudentById(rid),LocalDateTime.now()));
//    }
}
