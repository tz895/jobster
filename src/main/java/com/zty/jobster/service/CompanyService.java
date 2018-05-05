package com.zty.jobster.service;

import com.zty.jobster.entity.Company;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(int cid);
    Company getStudentByUsername(String username);
    boolean addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int sid);
    UserDetails loadUserByUsername(String s);
}
