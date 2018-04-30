package com.zty.jobster.dao;

import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.entity.CompanySubId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface CompanySubDao {
    List<CompanySub> getAllSub();
    CompanySub getSubByPK(CompanySubId companySubId);
    List<CompanySub> getSubByStudent(Student student);
    List<CompanySub> getSubByCompany(Company company);
    void addSub(CompanySub companySub);
    void deleteSub(CompanySubId companySubId);
}
