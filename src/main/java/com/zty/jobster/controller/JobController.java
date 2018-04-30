package com.zty.jobster.controller;

import com.zty.jobster.entity.Job;
import com.zty.jobster.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/job/{jid}")
    public ResponseEntity<Job> getJobById(@PathVariable("jid") Integer id) {
        Job job = jobService.getJobById(id);
        return new ResponseEntity<Job>(job, HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> companyList = jobService.getAllJobs();
        return new ResponseEntity<List<Job>>(companyList,HttpStatus.OK);
    }

    @GetMapping("/job/company/{cid}")
    public ResponseEntity<List<Job>> getJobByCompany(@PathVariable("cid") Integer id) {
        List<Job> companyList = jobService.getJobsByCompany(id);
        return new ResponseEntity<List<Job>>(companyList, HttpStatus.OK);
    }

    @PostMapping("/job")
    public ResponseEntity<Void> addJob(@RequestBody Job job, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/company/{sid}").buildAndExpand(job.getJobId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/job")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        jobService.updateJob(job);
        return new ResponseEntity<Job>(job,HttpStatus.OK);
    }

    @DeleteMapping("/job/{jid}")
    public ResponseEntity<Void> deleteJob(@PathVariable("jid") Integer id) {
        jobService.deleteJob(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
