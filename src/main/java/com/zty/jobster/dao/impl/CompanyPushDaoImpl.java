package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.CompanyPushDao;
import com.zty.jobster.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanyPushDaoImpl implements CompanyPushDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CompanyPush> getAllPush() {
        String hql = "FROM CompanyPush";
        return (List<CompanyPush>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public CompanyPush getPushByPK(CompanyPushId companyPushId) {
        return entityManager.find(CompanyPush.class,companyPushId);
    }

    @Override
    public List<CompanyPush> getPushByStudent(Student student) {
        return student.getCompanyPushList();
    }

    @Override
    public List<CompanyPush> getPushByCompany(Job job) {
        return job.getCompanyPushList();
    }

    @Override
    public void addPush(CompanyPush companyPush) {
        entityManager.persist(companyPush);
    }

    @Override
    public void deletePush(CompanyPushId companyPushId) {
        entityManager.remove(getPushByPK(companyPushId));
    }

    @Override
    public void updatePush(CompanyPush companyPush) {
        CompanyPush newPush = getPushByPK(companyPush.getPk());
        newPush.setStatus(companyPush.getStatus());
        entityManager.flush();
    }
}
