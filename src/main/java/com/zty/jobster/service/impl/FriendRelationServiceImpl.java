package com.zty.jobster.service.impl;

import com.zty.jobster.dao.FriendRelationDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.FriendRelation;
import com.zty.jobster.entity.FriendRelationId;
import com.zty.jobster.entity.Student;
import com.zty.jobster.service.FriendRelationService;
import com.zty.jobster.service.FriendRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRelationServiceImpl implements FriendRelationService{

    private FriendRelationDao friendRelationDao;

    private StudentDao studentDao;

    public FriendRelationServiceImpl(FriendRelationDao friendRelationDao, StudentDao studentDao) {
        this.friendRelationDao = friendRelationDao;
        this.studentDao = studentDao;
    }

    @Override
    public FriendRelation getSubByPK(int sid, int fid) {
        return friendRelationDao.getFriendByPK(new FriendRelationId(studentDao.getStudentById(sid),studentDao.getStudentById(fid)));
    }

    @Override
    public List<FriendRelation> getFriendsByStudent(int sid) {
        return friendRelationDao.getFriendsByStudent(studentDao.getStudentById(sid));
    }

    @Override
    public void addFriend(int sid, int fid) {
        FriendRelation friendRelation = new FriendRelation(new FriendRelationId(studentDao.getStudentById(sid),studentDao.getStudentById(fid)));
        friendRelationDao.addFriend(friendRelation);
    }

    @Override
    public void deleteFriend(int sid, int fid) {
        FriendRelationId friendRelationId = new FriendRelationId(studentDao.getStudentById(sid),studentDao.getStudentById(fid));
        friendRelationDao.deleteFriend(friendRelationId);
    }
}
