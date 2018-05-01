package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.JobForwardDao;
import com.zty.jobster.entity.JobForward;
import com.zty.jobster.entity.JobForwardId;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JobForwardImpl implements JobForwardDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JobForward> getAllForward() {
        String hql = "FROM JobForward";
        return (List<JobForward>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public JobForward getForwardByPK(JobForwardId jobForwardId) {
        return entityManager.find(JobForward.class,jobForwardId);
    }

    @Override
    public List<JobForward> getForwardBySender(Student sender) {
        return sender.getSenderjobForwards();
    }

    @Override
    public List<JobForward> getForwardByReceiver(Student receiver) {
        return receiver.getReceiverjobForwards();
    }

    @Override
    public void addForward(JobForward jobForward) {
        entityManager.persist(jobForward);
    }

    @Override
    public void deleteForward(JobForwardId jobForwardId) {
        entityManager.remove(getForwardByPK(jobForwardId));
    }

    @Override
    public void updateForward(JobForward jobForward) {
        JobForward newjobForward = getForwardByPK(jobForward.getPk());
    }
}
