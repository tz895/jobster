package com.zty.jobster.controller;

import com.zty.jobster.entity.CompanySub;
import com.zty.jobster.service.CompanySubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
