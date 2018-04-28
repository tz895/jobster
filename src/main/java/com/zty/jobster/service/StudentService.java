package com.zty.jobster.service;

import com.zty.jobster.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int sid);
    boolean addStudent(Student student);
    void updateStudent(Student stduent);
    void deleteStudent(int sid);
}
