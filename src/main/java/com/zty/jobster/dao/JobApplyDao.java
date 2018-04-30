package com.zty.jobster.dao;


import com.zty.jobster.entity.Job;
import com.zty.jobster.entity.Jobapply;
import com.zty.jobster.entity.JobapplyId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface JobApplyDao {
    List<Jobapply> getAllApply();
    Jobapply getApplyByPK(JobapplyId jobapplyId);
    List<Jobapply> getApplyByStudent(Student student);
    List<Jobapply> getApplyByJob(Job job);
    void addJobApply(Jobapply jobapply);
    void updateJobApply(Jobapply jobapply);
    void deleteJobApply(JobapplyId jobapplyId);
}
