package com.zty.jobster.dao;

import com.zty.jobster.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudentById(int sid);
    void addStudent(Student student);
    void updateStudent(Student stduent);
    void deleteStudent(int sid);
    boolean usernameExists(String username);
}
