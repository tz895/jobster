package com.zty.jobster.service;

import com.zty.jobster.entity.FriendRequest;
import com.zty.jobster.entity.FriendRequestId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface FriendRequestService {
    List<FriendRequest> getAllRequest();
    FriendRequest getRequestByPK(int sid,int rid);
    List<FriendRequest> getRequestBySender(int sid);
    List<FriendRequest> getRequestByReceiver(int rid);
    void addRequest(int sid,int rid);
    void deleteRequest(int sid,int rid);
    void updateRequest(int sid,int rid,int status);
}
