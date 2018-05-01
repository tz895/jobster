package com.zty.jobster.controller;

import com.zty.jobster.entity.FriendRequest;
import com.zty.jobster.service.FriendRequestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("rest")
public class FriendRequestController {

    private FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @GetMapping("/friendrequests")
    public ResponseEntity<List<FriendRequest>> getAllRequest() {
        List<FriendRequest> friendRequestList = friendRequestService.getAllRequest();
        return new ResponseEntity<>(friendRequestList, HttpStatus.OK);
    }

    @GetMapping("/friendrequest/sender/{sid}/receiver/{rid}")
    public ResponseEntity<FriendRequest> getRequestByPK(@PathVariable("sid") Integer sid, @PathVariable("rid") Integer rid) {
        FriendRequest friendRequest = friendRequestService.getRequestByPK(sid,rid);
        return new ResponseEntity<>(friendRequest, HttpStatus.OK);
    }

    @GetMapping("/friendrequests/sender/{sid}")
    public ResponseEntity<List<FriendRequest>> getRequestBySender(@PathVariable("sid") Integer sid) {
        List<FriendRequest> friendRequestList = friendRequestService.getRequestBySender(sid);
        return new ResponseEntity<>(friendRequestList, HttpStatus.OK);
    }

    @GetMapping("/friendrequests/receiver/{rid}")
    public ResponseEntity<List<FriendRequest>> getRequestByReceiver(@PathVariable("rid") Integer rid) {
        List<FriendRequest> friendRequestList = friendRequestService.getRequestByReceiver(rid);
        return new ResponseEntity<>(friendRequestList, HttpStatus.OK);
    }

    @PostMapping("/friendrequest/sender/{sid}/receiver/{rid}")
    public ResponseEntity<Void> addRequest(@PathVariable("sid") Integer sid, @PathVariable("rid") Integer rid,UriComponentsBuilder builder) {
        if(friendRequestService.getRequestByPK(sid,rid) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        friendRequestService.addRequest(sid,rid);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/friendrequest/sender/{sid}/receiver/{rid}")
                .buildAndExpand(sid,rid).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @DeleteMapping("/friendrequest/sender/{sid}/receiver/{rid}")
    public ResponseEntity<Void> deleteRequest(@PathVariable("sid") Integer sid,@PathVariable("rid") Integer rid) {
        friendRequestService.deleteRequest(sid,rid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/friendrequest/sender/{sid}/receiver/{rid}/status/{status}")
    public ResponseEntity<Void> updateRequest(@PathVariable("sid") Integer sid,
                                          @PathVariable("rid") Integer rid, @PathVariable("status") int status) {
        friendRequestService.updateRequest(sid,rid,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
