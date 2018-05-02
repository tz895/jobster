package com.zty.jobster.dao.impl;


import com.zty.jobster.dao.StudentDao;
import com.zty.jobster.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        String hql = "FROM Student as s ORDER BY s.studentId";
        return (List<Student>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Student getStudentById(int sid) {
        return entityManager.find(Student.class,sid);
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Student stduent) {
        Student stu = getStudentById(stduent.getStudentId());
        stu.setStudentEmail(stduent.getStudentEmail());
        stu.setUniversity(stduent.getUniversity());
        stu.setMajor(stduent.getMajor());
        stu.setAccess(stduent.getAccess());
        stu.setGpa(stduent.getGpa());
        stu.setPassword(stduent.getPassword());
        stu.setResume(stduent.getResume());
        stu.setName(stduent.getName());
        entityManager.flush();
    }

    @Override
    public void deleteStudent(int sid) {
        entityManager.remove(getStudentById(sid));
    }

    @Override
    public boolean usernameExists(String username) {
        String hql = "FROM Student as s WHERE s.username = ?";
        int count = entityManager.createQuery(hql).setParameter(0,username).getResultList().size();

        return count > 0 ? true : false;
    }

    @Override
    public Student getSutdentByusername(String username) {
        String hql = "FROM Student as s WHERE s.username = ?";
        List<Student> studentList= (List<Student>)entityManager.createQuery(hql).setParameter(0,username).getResultList();

        return studentList.size() == 0 ? null : studentList.get(0);
    }
}
