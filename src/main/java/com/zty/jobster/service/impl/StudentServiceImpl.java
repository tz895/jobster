package com.zty.jobster.service.impl;


import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.Student;
import com.zty.jobster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int sid) {
        Student student = studentDao.getStudentById(sid);
        return student;
    }

    @Override
    public synchronized boolean addStudent(Student student) {
        if(studentDao.usernameExists(student.getUsername())) {
            return false;
        }
        else {
            studentDao.addStudent(student);
            return true;
        }
    }

    @Override
    public void updateStudent(Student stduent) {
        studentDao.updateStudent(stduent);
    }

    @Override
    public void deleteStudent(int sid) {
        studentDao.deleteStudent(sid);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentDao.getSutdentByusername(username);
        if(student == null){
            return null;
        }
        return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(), emptyList());
    }
}
