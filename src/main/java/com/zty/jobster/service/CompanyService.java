package com.zty.jobster.service;

import com.zty.jobster.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(int cid);
    boolean addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int sid);
}
