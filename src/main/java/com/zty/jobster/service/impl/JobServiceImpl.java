package com.zty.jobster.service.impl;

import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.dao.JobDao;
import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.Job;
import com.zty.jobster.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobDao jobDao;
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Job> getAllJobs() {
        return jobDao.getAllJobs();
    }

    @Override
    public List<Job> getJobsByCompany(int cid) {
        Company company = companyDao.getCompanyById(cid);
        return jobDao.getJobsByCompany(company);
    }

    @Override
    public Job getJobById(int jid) {
        return jobDao.getJobById(jid);
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
    }

    @Override
    public void updateJob(Job job) {
        jobDao.updateJob(job);
    }

    @Override
    public void deleteJob(int jid) {
        jobDao.deleteJob(jid);
    }
}
