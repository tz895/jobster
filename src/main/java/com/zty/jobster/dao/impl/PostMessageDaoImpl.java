package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.PostMessageDao;
import com.zty.jobster.entity.PostMessage;
import com.zty.jobster.entity.PostMessageId;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostMessageDaoImpl implements PostMessageDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public List<PostMessage> getMessageByPk(int sid, int rid) {
//        String hql = "FROM PostMessage as p WHERE p.pk.sender.studentId = sid and ";
//        return (List<PostMessage>) entityManager.createQuery(hql).getResultList();
//    }

    @Override
    public List<PostMessage> getMessageBySender(Student sender) {
        return sender.getSenderMessageList();
    }

    @Override
    public List<PostMessage> getMessageByReceiver(Student receiver) {
        return receiver.getReceiverMessageList();
    }

    @Override
    public void addMessage(PostMessage postMessage) {
        entityManager.persist(postMessage);
    }

//    @Override
//    public void deleteMessage(PostMessageId postMessageId) {
//        entityManager.remove(getMessageByPk(postMessageId));
//    }
}
