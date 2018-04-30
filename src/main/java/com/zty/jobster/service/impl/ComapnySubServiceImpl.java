package com.zty.jobster.service.impl;

import com.zty.jobster.dao.CompanyDao;
import com.zty.jobster.dao.CompanySubDao;
import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.entity.CompanySubId;
import com.zty.jobster.service.CompanySubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComapnySubServiceImpl implements CompanySubService {

    private CompanySubDao companySubDao;

    private CompanyDao companyDao;

    private StudentDao studentDao;

    public ComapnySubServiceImpl(CompanySubDao companySubDao, CompanyDao companyDao, StudentDao studentDao) {
        this.companySubDao = companySubDao;
        this.companyDao = companyDao;
        this.studentDao = studentDao;
    }

    @Override
    public List<CompanySub> getAllSub() {
        return companySubDao.getAllSub();
    }

    @Override
    public CompanySub getSubByPK(int sid, int cid) {
        return companySubDao.getSubByPK(new CompanySubId(studentDao.getStudentById(sid),companyDao.getCompanyById(cid)));
    }

    @Override
    public List<CompanySub> getSubByStudent(int sid) {
        return companySubDao.getSubByStudent(studentDao.getStudentById(sid));
    }

    @Override
    public List<CompanySub> getSubByCompany(int cid) {
        return companySubDao.getSubByCompany(companyDao.getCompanyById(cid));
    }

    @Override
    public void addSubByPK(int sid, int cid) {
        CompanySub companySub = new CompanySub(new CompanySubId(studentDao.getStudentById(sid),companyDao.getCompanyById(cid)));
        companySubDao.addSub(companySub);
    }

    @Override
    public void deleteSub(int sid, int cid) {
        companySubDao.deleteSub(new CompanySubId(studentDao.getStudentById(sid),companyDao.getCompanyById(cid)));
    }
}
