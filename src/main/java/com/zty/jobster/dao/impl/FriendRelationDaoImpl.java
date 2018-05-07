package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.FriendRelationDao;
import com.zty.jobster.entity.FriendRelation;
import com.zty.jobster.entity.FriendRelationId;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class FriendRelationDaoImpl implements FriendRelationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FriendRelation> getFriendsByStudent(Student student) {
        return student.getFriendRelationList();
    }

    @Override
    public void addFriend(FriendRelation friendRelation) {
        entityManager.persist(friendRelation);
    }

    @Override
    public void deleteFriend(FriendRelationId friendRelationId) {
        entityManager.remove(getFriendByPK(friendRelationId));
    }

    @Override
    public FriendRelation getFriendByPK(FriendRelationId friendRelationId) {
        return entityManager.find(FriendRelation.class,friendRelationId);
    }
}
