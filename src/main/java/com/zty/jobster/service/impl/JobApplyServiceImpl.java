package com.zty.jobster.service.impl;


import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.dao.JobApplyDao;
import com.zty.jobster.dao.JobDao;
import com.zty.jobster.dao.StudentDao;

import com.zty.jobster.entity.*;
import com.zty.jobster.entity.Enum.JobApplyStatus;
import com.zty.jobster.service.JobApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.zty.jobster.entity.Enum.JobApplyStatus.Processing;

@Service
public class JobApplyServiceImpl implements JobApplyService{
    @Autowired
    private JobApplyDao jobApplyDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private JobDao jobDao;

    @Autowired
    CompanyDao companyDao;

    @Override
    public List<Jobapply> getAllApply() {
        return jobApplyDao.getAllApply();
    }

    @Override
    public Jobapply getApplyByPK(int sid, int jid) {
        return jobApplyDao.getApplyByPK(new JobapplyId(studentDao.getStudentById(sid),jobDao.getJobById(jid)));
    }

    @Override
    public List<Jobapply> getApplyByStudent(int sid) {
        return jobApplyDao.getApplyByStudent(studentDao.getStudentById(sid));
    }

    @Override
    public List<Jobapply> getApplyByCompany(int cid) {
        Company company = companyDao.getCompanyById(cid);
        List<Job> jobs = jobDao.getJobsByCompany(company);
        List<Jobapply> temp = new ArrayList<>();
        for(Job job: jobs) {
            temp.addAll(jobApplyDao.getApplyByJob(job));
        }
        return temp;
    }

    @Override
    public List<Jobapply> getApplyByJob(int jid) {
        return jobApplyDao.getApplyByJob(jobDao.getJobById(jid));
    }

    @Override
    public void addJobApply(Jobapply jobapply) {
        jobApplyDao.addJobApply(jobapply);
    }

    @Override
    public void updateJobApply(int sid,int jid,int status) {
        Jobapply jobapply = this.getApplyByPK(sid,jid);
        if(status == 1) {
            jobapply.setStatus(JobApplyStatus.Checked);
        }
        else if(status == 0) {
            jobapply.setStatus(JobApplyStatus.Processing);
        }
        else {
            jobapply.setStatus(JobApplyStatus.Declined);
        }
        jobApplyDao.updateJobApply(jobapply);
    }

    @Override
    public void deleteJobApply(int sid,int jid) {
        jobApplyDao.deleteJobApply(new JobapplyId(studentDao.getStudentById(sid),jobDao.getJobById(jid)));
    }

    @Override
    public void addJobapplyByPK(int sid, int jid) {
        Jobapply jobapply = new Jobapply(new JobapplyId(studentDao.getStudentById(sid),jobDao.getJobById(jid)),JobApplyStatus.Processing);
        jobApplyDao.addJobApply(jobapply);
    }
}
