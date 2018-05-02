package com.zty.jobster.service.impl;

import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.entity.Company;
import com.zty.jobster.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Company getCompanyById(int cid) {
        return companyDao.getCompanyById(cid);
    }

    @Override
    public boolean addCompany(Company company) {
        if(companyDao.usernameExists(company.getUsername(),company.getName())) {
            return false;
        }
        else {
            companyDao.addCompany(company);
            return true;
        }
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    @Override
    public void deleteCompany(int sid) {
        companyDao.deleteCompany(sid);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Company company = companyDao.getCompanyByusername(username);
        if(company == null){
            return null;
        }
        return new org.springframework.security.core.userdetails.User(company.getUsername(), company.getPassword(), emptyList());
    }
}
