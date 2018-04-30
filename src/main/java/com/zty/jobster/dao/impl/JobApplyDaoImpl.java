package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.JobApplyDao;
import com.zty.jobster.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class JobApplyDaoImpl implements JobApplyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Jobapply> getAllApply() {
        String hql = "FROM Jobapply";
        return (List<Jobapply>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Jobapply getApplyByPK(JobapplyId jobapplyId) {
//        String hql = "FROM jobapply as j WHERE j.sid = ? and j.cid = ?";
//        List<Jobapply> list = entityManager.createQuery(hql).setParameter(0,jobapplyId.getStudent().getStudentId()).setParameter(1,jobapplyId.getCompany().getCompanyId()).getResultList();
//        return list.get(0);
        return entityManager.find(Jobapply.class,jobapplyId);
    }

    @Override
    public List<Jobapply> getApplyByStudent(Student student) {
        return student.getJobapplyList();
    }

    @Override
    public List<Jobapply> getApplyByJob(Job job) {
        return job.getJobapplyList();
    }

    @Override
    public void addJobApply(Jobapply jobapply) {
        entityManager.persist(jobapply);
    }

    @Override
    public void updateJobApply(Jobapply jobapply) {
        Jobapply japply = getApplyByPK(jobapply.getPk());
        japply.setStatus(jobapply.getStatus());
        entityManager.flush();
    }

    @Override
    public void deleteJobApply(JobapplyId jobapplyId) {
        entityManager.remove(getApplyByPK(jobapplyId));
    }
}
