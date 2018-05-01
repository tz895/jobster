package com.zty.jobster.controller;

import com.zty.jobster.entity.JobForward;
import com.zty.jobster.service.JobForwardService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")
public class JobForwardController {

    private JobForwardService jobForwardService;

    public JobForwardController(JobForwardService jobForwardService) {
        this.jobForwardService = jobForwardService;
    }

    @GetMapping("/friendforwards")
    public ResponseEntity<List<JobForward>> getAllForward() {
        List<JobForward> jobForwardList = jobForwardService.getAllForward();
        return new ResponseEntity<>(jobForwardList, HttpStatus.OK);
    }

    @GetMapping("/friendforward/sender/{sid}/receiver/{rid}/job/{jid}")
    public ResponseEntity<JobForward> getForwardByKeys(@PathVariable("sid") Integer sid,
                                                        @PathVariable("rid") Integer rid,
                                                        @PathVariable("jid") Integer jid) {
        JobForward jobForward = jobForwardService.getForwardByKeys(sid,rid,jid);
        return new ResponseEntity<>(jobForward, HttpStatus.OK);
    }

    @GetMapping("/friendforwards/sender/{sid}")
    public ResponseEntity<List<JobForward>> getForwardBySender(@PathVariable("sid") Integer sid) {
        List<JobForward> jobForwardList = jobForwardService.getForwardBySender(sid);
        return new ResponseEntity<>(jobForwardList, HttpStatus.OK);
    }

    @GetMapping("/friendforwards/receiver/{rid}")
    public ResponseEntity<List<JobForward>> getForwardByReceiver(@PathVariable("rid") Integer rid) {
        List<JobForward> jobForwardList = jobForwardService.getForwardByReceiver(rid);
        return new ResponseEntity<>(jobForwardList, HttpStatus.OK);
    }

    @PostMapping("/friendforward/sender/{sid}/receiver/{rid}/job/{jid}")
    public ResponseEntity<Void> addForward(@PathVariable("sid") Integer sid,
                                           @PathVariable("rid") Integer rid,
                                           @PathVariable("jid") Integer jid,
                                           UriComponentsBuilder builder) {
        if(jobForwardService.getForwardByKeys(sid,rid,jid) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        jobForwardService.addForward(sid,rid,jid);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/friendforward/sender/{sid}/receiver/{rid}/job/{jid}")
                .buildAndExpand(sid,rid,jid).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @DeleteMapping("/friendforward/sender/{sid}/receiver/{rid}/job/{jid}")
    public ResponseEntity<Void> deleteForward(@PathVariable("sid") Integer sid,
                                              @PathVariable("rid") Integer rid,
                                              @PathVariable("jid") Integer jid) {
        jobForwardService.deleteForward(sid,rid,jid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/friendforward/sender/{sid}/receiver/{rid}/job/{jid}/status/{status}")
    public ResponseEntity<Void> updateForward(@PathVariable("sid") Integer sid,
                                              @PathVariable("rid") Integer rid,
                                              @PathVariable("jid") Integer jid,
                                              @PathVariable("status") int status) {
        jobForwardService.updateForward(sid,rid,jid,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
