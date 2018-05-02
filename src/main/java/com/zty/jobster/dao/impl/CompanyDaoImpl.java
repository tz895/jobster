package com.zty.jobster.dao.impl;

import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.entity.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        String hql = "FROM Company as c ORDER BY c.companyId";
        return (List<Company>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Company getCompanyById(int cid) {
        return entityManager.find(Company.class,cid);
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void updateCompany(Company company) {
        Company com = getCompanyById(company.getCompanyId());
        com.setName(company.getName());
        com.setIndustry(company.getIndustry());
        com.setLocation(company.getLocation());
        com.setPassword(company.getPassword());
        entityManager.flush();
    }

    @Override
    public void deleteCompany(int cid) {
        entityManager.remove(getCompanyById(cid));
    }

    @Override
    public boolean usernameExists(String username, String name) {
        String hql = "FROM Company as c WHERE c.username = ? and c.name = ?";
        int count = entityManager.createQuery(hql).setParameter(0,username).setParameter(1,name).getResultList().size();

        return count > 0 ? true : false;
    }

    @Override
    public Company getCompanyByusername(String username) {
        String hql = "FROM Company as c WHERE c.username = ?";
        List<Company> companyList= (List<Company>)entityManager.createQuery(hql).setParameter(0,username).getResultList();

        return companyList.size() == 0 ? null : companyList.get(0);
    }
}
