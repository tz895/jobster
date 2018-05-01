package com.zty.jobster.controller;

import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.service.CompanySubService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")
public class CompanySubController {

    private CompanySubService companySubService;

    public CompanySubController(CompanySubService companySubService) {
        this.companySubService = companySubService;
    }

    @GetMapping("/companysubs")
    public ResponseEntity<List<CompanySub>> getAllApply() {
        List<CompanySub> companySubList = companySubService.getAllSub();
        return new ResponseEntity<>(companySubList, HttpStatus.OK);
    }

    @GetMapping("/companysub/student/{sid}/company/{cid}")
    public ResponseEntity<CompanySub> getSubByPK(@PathVariable("sid") Integer sid, @PathVariable("cid") Integer cid) {
        CompanySub companySub = companySubService.getSubByPK(sid,cid);
        return new ResponseEntity<>(companySub, HttpStatus.OK);
    }

    @GetMapping("/companysubs/student/{sid}")
    public ResponseEntity<List<CompanySub>> getSubByStudent(@PathVariable("sid") Integer sid) {
        List<CompanySub> companySubList = companySubService.getSubByStudent(sid);
        return new ResponseEntity<>(companySubList, HttpStatus.OK);
    }

    @GetMapping("/companysubs/company/{cid}")
    public ResponseEntity<List<CompanySub>> getSubByCompany(@PathVariable("cid") Integer cid) {
        List<CompanySub> companySubList = companySubService.getSubByCompany(cid);
        return new ResponseEntity<>(companySubList, HttpStatus.OK);
    }

    @PostMapping("/companysub/student/{sid}/company/{cid}")
    public ResponseEntity<Void> addSubByPK(@PathVariable("sid") Integer sid, @PathVariable("cid") Integer cid,UriComponentsBuilder builder) {
        if(companySubService.getSubByPK(sid,cid) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        companySubService.addSubByPK(sid,cid);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/companysub/student/{sid}/company/{cid}")
                .buildAndExpand(sid,cid).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @DeleteMapping("/companysub/student/{sid}/company/{cid}")
    public ResponseEntity<Void> deleteSub(@PathVariable("sid") Integer sid,@PathVariable("cid") Integer cid) {
        companySubService.deleteSub(sid,cid);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
