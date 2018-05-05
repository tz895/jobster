package com.zty.jobster.controller;

import com.zty.jobster.entity.Student;
import com.zty.jobster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{sid}")
    public ResponseEntity<Student> getStudentById(@PathVariable("sid") Integer id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
    }

    @GetMapping("/student/username/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable("username") String username) {
        Student student = studentService.getStudentByUsername(username);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
        student.setPassword(DigestUtils.md5DigestAsHex((student.getPassword()).getBytes()));
        boolean flag = studentService.addStudent(student);
        if(!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/student/{sid}").buildAndExpand(student.getStudentId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }

    @DeleteMapping("/student/{sid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("sid") Integer sid) {
        studentService.deleteStudent(sid);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
