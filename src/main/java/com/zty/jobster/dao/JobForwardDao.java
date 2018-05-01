package com.zty.jobster.dao;

import com.zty.jobster.entity.JobForward;
import com.zty.jobster.entity.JobForwardId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface JobForwardDao {
    List<JobForward> getAllForward();
    JobForward getForwardByPK(JobForwardId jobForwardId);
    List<JobForward> getForwardBySender(Student sender);
    List<JobForward> getForwardByReceiver(Student receiver);
    void addForward(JobForward jobForward);
    void deleteForward(JobForwardId jobForwardId);
    void updateForward(JobForward jobForward);
}
