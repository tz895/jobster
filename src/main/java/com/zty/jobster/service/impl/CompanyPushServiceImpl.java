package com.zty.jobster.service.impl;


import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.dao.CompanyPushDao;
import com.zty.jobster.dao.JobDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.CompanyPush;
import com.zty.jobster.entity.CompanyPushId;
import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.entity.Enum.CompanyPushStatus;
import com.zty.jobster.service.CompanyPushService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyPushServiceImpl implements CompanyPushService{

    private CompanyPushDao companyPushDao;

    private StudentDao studentDao;

    private JobDao jobDao;

    public CompanyPushServiceImpl(CompanyPushDao companyPushDao, StudentDao studentDao, JobDao jobDao) {
        this.companyPushDao = companyPushDao;
        this.studentDao = studentDao;
        this.jobDao = jobDao;
    }

    @Override
    public List<CompanyPush> getAllPush() {
        return companyPushDao.getAllPush();
    }

    @Override
    public CompanyPush getPushByPK(int sid, int jid) {
        return companyPushDao.getPushByPK(new CompanyPushId(studentDao.getStudentById(sid),jobDao.getJobById(jid)));
    }

    @Override
    public List<CompanyPush> getPushByStudent(int sid) {
        return companyPushDao.getPushByStudent(studentDao.getStudentById(sid));
    }

    @Override
    public List<CompanyPush> getPushByJob(int jid) {
        return companyPushDao.getPushByCompany(jobDao.getJobById(jid));
    }

    @Override
    public void addPushByPK(int sid, int jid) {
        CompanyPush companyPush = new CompanyPush(new CompanyPushId(studentDao.getStudentById(sid),jobDao.getJobById(jid)),
                LocalDateTime.now(), CompanyPushStatus.Processing);
        companyPushDao.addPush(companyPush);
    }

    @Override
    public void deletePush(int sid, int jid) {
        companyPushDao.deletePush(new CompanyPushId(studentDao.getStudentById(sid),jobDao.getJobById(jid)));
    }

    @Override
    public void updatePush(int sid,int jid,int Status) {
        CompanyPush companyPush = this.getPushByPK(sid,jid);
        if(Status == 1) {
            companyPush.setStatus(CompanyPushStatus.Accepted);
        }
        else if(Status == 0) {
            companyPush.setStatus(CompanyPushStatus.Processing);
        }
        else {
            companyPush.setStatus(CompanyPushStatus.Refused);
        }
        companyPushDao.updatePush(companyPush);
    }
}
