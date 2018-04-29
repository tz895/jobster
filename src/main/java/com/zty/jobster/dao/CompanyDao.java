package com.zty.jobster.dao;

import com.zty.jobster.entity.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> getAllCompanies();
    Company getCompanyById(int cid);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int sid);
    boolean usernameExists(String username, String name);
}
