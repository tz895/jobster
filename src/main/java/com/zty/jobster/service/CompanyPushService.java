package com.zty.jobster.service;



import com.zty.jobster.entity.CompanyPush;

import java.util.List;

public interface CompanyPushService {
    List<CompanyPush> getAllPush();
    CompanyPush getPushByPK(int sid, int jid);
    List<CompanyPush> getPushByStudent(int sid);
    List<CompanyPush> getPushByJob(int jid);
    void addPushByPK(int sid,int jid);
    void deletePush(int sid, int jid);
    void updatePush(int sid,int jid,int status);
}
