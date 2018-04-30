package com.zty.jobster.service;

import com.zty.jobster.entity.Jobapply;
import com.zty.jobster.entity.JobapplyId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface JobApplyService {
    List<Jobapply> getAllApply();
    Jobapply getApplyByPK(int sid, int jid);
    List<Jobapply> getApplyByStudent(int sid);
    List<Jobapply> getApplyByJob(int jid);
    void addJobApply(Jobapply jobapply);
    void addJobapplyByPK(int sid,int jid);
    void updateJobApply(Jobapply jobapply);
    void deleteJobApply(int sid,int jid);
}
