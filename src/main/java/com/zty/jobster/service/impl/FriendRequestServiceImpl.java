package com.zty.jobster.service.impl;

import com.zty.jobster.dao.FriendRequestDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.Enum.FriendRequestStatus;
import com.zty.jobster.entity.FriendRequest;
import com.zty.jobster.entity.FriendRequestId;
import com.zty.jobster.service.FriendRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendRequestServiceImpl implements FriendRequestService{

    FriendRequestDao friendRequestDao;

    StudentDao studentDao;

    public FriendRequestServiceImpl(FriendRequestDao friendRequestDao, StudentDao studentDao) {
        this.friendRequestDao = friendRequestDao;
        this.studentDao = studentDao;
    }

    @Override
    public List<FriendRequest> getAllRequest() {
        return friendRequestDao.getAllRequest();
    }

    @Override
    public FriendRequest getRequestByPK(int sid, int rid) {
        return friendRequestDao.getRequestByPK(new FriendRequestId(studentDao.getStudentById(sid),studentDao.getStudentById(rid)));
    }

    @Override
    public List<FriendRequest> getRequestBySender(int sid) {
        return friendRequestDao.getRequestBySender(studentDao.getStudentById(sid));
    }

    @Override
    public List<FriendRequest> getRequestByReceiver(int rid) {
        return friendRequestDao.getRequestByReceiver(studentDao.getStudentById(rid));
    }

    @Override
    public void addRequest(int sid, int rid) {
        FriendRequest friendRequest = new FriendRequest(new FriendRequestId(studentDao.getStudentById(sid),studentDao.getStudentById(rid)),
                LocalDateTime.now(), FriendRequestStatus.Processing);
        friendRequestDao.addRequest(friendRequest);
    }

    @Override
    public void deleteRequest(int sid, int rid) {
        friendRequestDao.deleteRequest(new FriendRequestId(studentDao.getStudentById(sid),studentDao.getStudentById(rid)));
    }

    @Override
    public void updateRequest(int sid, int rid, int status) {
        FriendRequest friendRequest = this.getRequestByPK(sid,rid);
        if(status == 1) {
            friendRequest.setStatus(FriendRequestStatus.Accepted);
        }
        else if(status == 0){
            friendRequest.setStatus(FriendRequestStatus.Processing);
        }
        else {
            friendRequest.setStatus(FriendRequestStatus.Refused);
        }
        friendRequestDao.updateRequest(friendRequest);
    }
}
