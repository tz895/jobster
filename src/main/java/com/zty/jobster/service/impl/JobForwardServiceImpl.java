package com.zty.jobster.service.impl;

import com.zty.jobster.dao.JobDao;
import com.zty.jobster.dao.JobForwardDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.Enum.JobForwardStatus;
import com.zty.jobster.entity.JobForward;
import com.zty.jobster.entity.JobForwardId;
import com.zty.jobster.service.JobForwardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobForwardServiceImpl implements JobForwardService{

    private JobForwardDao jobForwardDao;

    private StudentDao studentDao;

    private JobDao jobDao;

    public JobForwardServiceImpl(JobForwardDao jobForwardDao, StudentDao studentDao, JobDao jobDao) {
        this.jobForwardDao = jobForwardDao;
        this.studentDao = studentDao;
        this.jobDao = jobDao;
    }

    @Override
    public List<JobForward> getAllForward() {
        return jobForwardDao.getAllForward();
    }



    @Override
    public JobForward getForwardByKeys(int sid, int rid, int jid) {
        return jobForwardDao.getForwardByPK(new JobForwardId(studentDao.getStudentById(sid),studentDao.getStudentById(rid),
                jobDao.getJobById(jid)));
    }

    @Override
    public List<JobForward> getForwardBySender(int sid) {
        return jobForwardDao.getForwardBySender(studentDao.getStudentById(sid));
    }

    @Override
    public List<JobForward> getForwardByReceiver(int rid) {
        return jobForwardDao.getForwardByReceiver(studentDao.getStudentById(rid));
    }

    @Override
    public void addForward(int sid, int rid, int jid) {
        JobForward jobForward = new JobForward(new JobForwardId(studentDao.getStudentById(sid),studentDao.getStudentById(rid),jobDao.getJobById(jid)),
                LocalDateTime.now(), JobForwardStatus.Processing);
        jobForwardDao.addForward(jobForward);
    }

    @Override
    public void deleteForward(int sid, int rid, int jid) {
        jobForwardDao.deleteForward(new JobForwardId(studentDao.getStudentById(sid),studentDao.getStudentById(rid),jobDao.getJobById(jid)));
    }

    @Override
    public void updateForward(int sid, int rid, int jid, int status) {
        JobForward jobForward = this.getForwardByKeys(sid,rid,jid);
        if(status == 0) {
            jobForward.setStatus(JobForwardStatus.Processing);
        }
        else {
            jobForward.setStatus(JobForwardStatus.Checked);
        }

        jobForwardDao.updateForward(jobForward);

    }
}
