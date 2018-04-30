package com.zty.jobster.controller;

import com.zty.jobster.entity.Company;
import com.zty.jobster.service.CompanyService;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{cid}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("cid") Integer id) {
        Company company = companyService.getCompanyById(id);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companyList = companyService.getAllCompanies();
        return new ResponseEntity<List<Company>>(companyList,HttpStatus.OK);
    }

    @PostMapping("/company")
    public ResponseEntity<Void> addCompany(@RequestBody Company company, UriComponentsBuilder builder) {
        boolean flag = companyService.addCompany(company);
        if(!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/company/{sid}").buildAndExpand(company.getCompanyId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/company")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return new ResponseEntity<Company>(company,HttpStatus.OK);
    }

    @DeleteMapping("/company/{sid}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("sid") Integer id) {
        companyService.deleteCompany(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
