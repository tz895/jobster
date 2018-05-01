package com.zty.jobster.service;

import com.zty.jobster.entity.JobForward;
import com.zty.jobster.entity.JobForwardId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface JobForwardService {
    List<JobForward> getAllForward();
    JobForward getForwardByKeys(int sid,int rid,int jid);
    List<JobForward> getForwardBySender(int sid);
    List<JobForward> getForwardByReceiver(int rid);
    void addForward(int sid,int rid,int jid);
    void deleteForward(int sid,int rid,int jid);
    void updateForward(int sid,int rid,int jid,int status);
}
