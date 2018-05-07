package com.zty.jobster.controller;

import com.zty.jobster.entity.FriendRelation;
import com.zty.jobster.service.FriendRelationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class FriendRelationController {

    private FriendRelationService friendRelationService;

    public FriendRelationController(FriendRelationService friendRelationService) {
        this.friendRelationService = friendRelationService;
    }

    @GetMapping("/friendrelation/student/{sid}")
    public List<FriendRelation> getFriendsByStudent(@PathVariable("sid") Integer sid) {
        return friendRelationService.getFriendsByStudent(sid);
    }

//    @GetMapping("/friendrelation/student/{sid}")
//    public ResponseEntity<List<FriendRelation>> getFriendsByStudent(@PathVariable("sid") Integer sid) {
//        return new ResponseEntity<>(friendRelationService.getFriendsByStudent(sid), HttpStatus.OK);
//    }
    @GetMapping("/friendrelation/student/{sid}/friend/{fid}")
    public FriendRelation getSubByPK(@PathVariable("sid") Integer sid,@PathVariable("fid") Integer fid) {
        return friendRelationService.getSubByPK(sid,fid);
    }

    @PostMapping("/friendrelation/student/{sid}/friend/{fid}")
    public void addFriend(@PathVariable("sid") Integer sid,@PathVariable("fid") Integer fid) {
        friendRelationService.addFriend(sid,fid);
    }

    @DeleteMapping("/friendrelation/student/{sid}/friend/{fid}")
    public void deleteFriend(@PathVariable("sid") Integer sid,@PathVariable("fid") Integer fid) {
        friendRelationService.deleteFriend(sid,fid);
    }
}
