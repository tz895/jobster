package com.zty.jobster.controller;

import com.zty.jobster.entity.Jobapply;
import com.zty.jobster.service.JobApplyService;
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
public class JobApplyController {
    @Autowired
    private JobApplyService jobApplyService;

    @GetMapping("/jobapply/student/{sid}/job/{jid}")
    public ResponseEntity<Jobapply> getJobApplyByPK(@PathVariable("sid") Integer sid,@PathVariable("jid") Integer jid) {
        Jobapply jobapply = jobApplyService.getApplyByPK(sid,jid);
        return new ResponseEntity<>(jobapply, HttpStatus.OK);
    }

    @GetMapping("/jobapplies")
    public ResponseEntity<List<Jobapply>> getAllApply() {
        List<Jobapply> jobapplyList = jobApplyService.getAllApply();
        return new ResponseEntity<>(jobapplyList,HttpStatus.OK);
    }

    @GetMapping("/jobapply/student/{sid}")
    public ResponseEntity<List<Jobapply>> getApplyByStudent(@PathVariable("sid") Integer sid) {
        List<Jobapply> jobapplyList = jobApplyService.getApplyByStudent(sid);
        return new ResponseEntity<>(jobapplyList,HttpStatus.OK);
    }

    @GetMapping("/jobapply/job/{jid}")
    public ResponseEntity<List<Jobapply>> getApplyByJob(@PathVariable("jid") Integer jid) {
        List<Jobapply> jobapplyList = jobApplyService.getApplyByJob(jid);
        return new ResponseEntity<>(jobapplyList,HttpStatus.OK);
    }

    @PostMapping("/jobapply")
    public ResponseEntity<Void> addJob(@RequestBody Jobapply jobapply, UriComponentsBuilder builder) {
        jobApplyService.addJobApply(jobapply);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/jobapply/student/{sid}/job/{jid}")
                .buildAndExpand(jobapply.getPk().getStudent().getStudentId(),jobapply.getPk().getJob().getJobId()).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PostMapping("/jobapply/student/{sid}/job/{jid}")
    public ResponseEntity<Void> addJobapplyByPK(@PathVariable("sid") Integer sid,@PathVariable("jid") Integer jid,UriComponentsBuilder builder) {
        if(jobApplyService.getApplyByPK(sid,jid) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        jobApplyService.addJobapplyByPK(sid,jid);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/jobapply/student/{sid}/job/{jid}")
                .buildAndExpand(sid,jid).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/jobapply/student/{sid}/job/{jid}/status/{status}")
    public ResponseEntity<Void> updateJob(@PathVariable("sid") Integer sid,
                                          @PathVariable("jid") Integer jid,@PathVariable("status") Integer status) {
        jobApplyService.updateJobApply(sid,jid,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/jobapply/student/{sid}/job/{jid}")
    public ResponseEntity<Void> deleteJob(@PathVariable("sid") Integer sid,@PathVariable("jid") Integer jid) {
        jobApplyService.deleteJobApply(sid,jid);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
