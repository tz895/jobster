package com.zty.jobster.dao;

import com.zty.jobster.entity.*;

import java.util.List;

public interface CompanyPushDao {
    List<CompanyPush> getAllPush();
    CompanyPush getPushByPK(CompanyPushId companyPushId);
    List<CompanyPush> getPushByStudent(Student student);
    List<CompanyPush> getPushByCompany(Job job);
    void addPush(CompanyPush companyPush);
    void deletePush(CompanyPushId companyPushId);
    void updatePush(CompanyPush companyPush);
}
