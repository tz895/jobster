package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.CompanySubDao;
import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.entity.CompanySubId;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanySubDaoImpl implements CompanySubDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CompanySub> getAllSub() {
        String hql = "FROM CompanySub";
        return (List<CompanySub>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public CompanySub getSubByPK(CompanySubId companySubId) {
        return entityManager.find(CompanySub.class,companySubId);
    }

    @Override
    public List<CompanySub> getSubByStudent(Student student) {
        return student.getCompanySubList();
    }

    @Override
    public List<CompanySub> getSubByCompany(Company company) {
        return company.getCompanySubList();
    }

    @Override
    public void addSub(CompanySub companySub) {
        entityManager.persist(companySub);
    }

    @Override
    public void deleteSub(CompanySubId companySubId) {
        entityManager.remove(getSubByPK(companySubId));
    }
}
