package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.FriendRequestDao;
import com.zty.jobster.entity.CompanyPush;
import com.zty.jobster.entity.FriendRequest;
import com.zty.jobster.entity.FriendRequestId;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FriendRequestDaoImpl implements FriendRequestDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FriendRequest> getAllRequest() {
        String hql = "FROM FriendRequest";
        return (List<FriendRequest>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public FriendRequest getRequestByPK(FriendRequestId friendRequestId) {
        return entityManager.find(FriendRequest.class,friendRequestId);
    }

    @Override
    public List<FriendRequest> getRequestBySender(Student sender) {
        return sender.getSenderRequests();
    }

    @Override
    public List<FriendRequest> getRequestByReceiver(Student receiver) {
        return receiver.getReceiverRequests();
    }

    @Override
    public void addRequest(FriendRequest friendRequest) {
        entityManager.persist(friendRequest);
    }

    @Override
    public void deleteRequest(FriendRequestId friendRequestId) {
        entityManager.remove(getRequestByPK(friendRequestId));
    }

    @Override
    public void updateRequest(FriendRequest friendRequest) {
        FriendRequest newRequest = getRequestByPK(friendRequest.getPk());
        newRequest.setStatus(friendRequest.getStatus());
        entityManager.flush();
    }
}
