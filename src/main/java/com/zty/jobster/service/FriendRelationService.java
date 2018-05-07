package com.zty.jobster.service;

import com.zty.jobster.entity.FriendRelation;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface FriendRelationService {

    FriendRelation getSubByPK(int sid, int fid);
    List<FriendRelation> getFriendsByStudent(int sid);
    void addFriend(int sid, int fid);
    void deleteFriend(int sid, int fid);
}
