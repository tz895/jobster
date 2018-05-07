package com.zty.jobster.dao;

import com.zty.jobster.entity.FriendRelation;
import com.zty.jobster.entity.FriendRelationId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface FriendRelationDao {
    FriendRelation getFriendByPK(FriendRelationId friendRelationId);
    List<FriendRelation> getFriendsByStudent(Student student);
    void addFriend(FriendRelation friendRelation);
    void deleteFriend(FriendRelationId friendRelationId);
}
