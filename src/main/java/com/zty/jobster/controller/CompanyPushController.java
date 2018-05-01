package com.zty.jobster.controller;

import com.zty.jobster.entity.CompanyPush;
import com.zty.jobster.service.CompanyPushService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")
public class CompanyPushController {

    private CompanyPushService companyPushService;

    public CompanyPushController(CompanyPushService companyPushService) {
        this.companyPushService = companyPushService;
    }

    @GetMapping("/companypushes")
    public ResponseEntity<List<CompanyPush>> getAllApply() {
        List<CompanyPush> companyPushList = companyPushService.getAllPush();
        return new ResponseEntity<>(companyPushList, HttpStatus.OK);
    }

    @GetMapping("/companypush/student/{sid}/job/{jid}")
    public ResponseEntity<CompanyPush> getPushByPK(@PathVariable("sid") Integer sid, @PathVariable("jid") Integer jid) {
        CompanyPush companyPush = companyPushService.getPushByPK(sid,jid);
        return new ResponseEntity<>(companyPush, HttpStatus.OK);
    }

    @GetMapping("/companypushes/student/{sid}")
    public ResponseEntity<List<CompanyPush>> getPushByStudent(@PathVariable("sid") Integer sid) {
        List<CompanyPush> companyPushList = companyPushService.getPushByStudent(sid);
        return new ResponseEntity<>(companyPushList, HttpStatus.OK);
    }

    @GetMapping("/companypushes/job/{jid}")
    public ResponseEntity<List<CompanyPush>> getPushByCompany(@PathVariable("jid") Integer jid) {
        List<CompanyPush> companyPushList = companyPushService.getPushByJob(jid);
        return new ResponseEntity<>(companyPushList, HttpStatus.OK);
    }

    @PostMapping("/companypush/student/{sid}/job/{jid}")
    public ResponseEntity<Void> addpushByPK(@PathVariable("sid") Integer sid, @PathVariable("jid") Integer jid,UriComponentsBuilder builder) {
        if(companyPushService.getPushByPK(sid,jid) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        companyPushService.addPushByPK(sid,jid);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/companypush/student/{sid}/job/{jid}")
                .buildAndExpand(sid,jid).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @DeleteMapping("/companypush/student/{sid}/job/{jid}")
    public ResponseEntity<Void> deletePush(@PathVariable("sid") Integer sid,@PathVariable("jid") Integer jid) {
        companyPushService.deletePush(sid,jid);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/companypush/student/{sid}/jid/{jid}/status/{status}")
    public ResponseEntity<Void> updateJob(@PathVariable("sid") Integer sid,
                                                 @PathVariable("jid") Integer jid, @PathVariable("status") int status) {
        companyPushService.updatePush(sid,jid,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
