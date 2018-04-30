package com.zty.jobster.service;

import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    List<Job> getJobsByCompany(int cid);
    Job getJobById(int jid);
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(int jid);
}
