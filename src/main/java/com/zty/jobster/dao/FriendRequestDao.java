package com.zty.jobster.dao;

import com.zty.jobster.entity.FriendRequest;
import com.zty.jobster.entity.FriendRequestId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface FriendRequestDao {
    List<FriendRequest> getAllRequest();
    FriendRequest getRequestByPK(FriendRequestId friendRequestId);
    List<FriendRequest> getRequestBySender(Student sender);
    List<FriendRequest> getRequestByReceiver(Student receiver);
    void addRequest(FriendRequest friendRequest);
    void deleteRequest(FriendRequestId friendRequestId);
    void updateRequest(FriendRequest friendRequest);
}
