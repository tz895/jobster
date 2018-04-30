package com.zty.jobster.service;

import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.entity.CompanySubId;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface CompanySubService {
    List<CompanySub> getAllSub();
    CompanySub getSubByPK(int sid, int cid);
    List<CompanySub> getSubByStudent(int sid);
    List<CompanySub> getSubByCompany(int cid);
    void addSubByPK(int sid,int cid);
    void deleteSub(int sid, int cid);
}
