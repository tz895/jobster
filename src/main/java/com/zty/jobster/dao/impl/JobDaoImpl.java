package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.JobDao;
import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.Job;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class JobDaoImpl implements JobDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Job> getAllJobs() {
        String hql = "FROM Job as j ORDER BY j.jobId";
        return (List<Job>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Job> getJobsByCompany(Company company) {
        return company.getJobList();
    }

    @Override
    public Job getJobById(int jid) {
        return entityManager.find(Job.class,jid);
    }

    @Override
    public void addJob(Job job) {
        entityManager.persist(job);
    }

    @Override
    public void updateJob(Job job) {
        Job j = getJobById(job.getJobId());
        j.setDescription(job.getDescription());
        j.setDiploma(job.getDiploma());
        j.setLocation(job.getLocation());
        j.setMajor(job.getMajor());
        j.setSalary(job.getSalary());
        j.setPost_time(job.getPost_time());
        j.setDue_time(job.getDue_time());
        j.setStatus(job.getStatus());
        j.setName(job.getName());
        j.setTitle(job.getTitle());
        entityManager.flush();
    }

    @Override
    public void deleteJob(int jid) {
        entityManager.remove(getJobById(jid));
    }
}
