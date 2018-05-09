package com.zty.jobster.controller;

import com.zty.jobster.entity.PostMessage;
import com.zty.jobster.service.PostMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class PostMessageController {

    private PostMessageService postMessageService;

    public PostMessageController(PostMessageService postMessageService) {
        this.postMessageService = postMessageService;
    }

    @GetMapping("/postmessage/sender/{sid}")
    public List<PostMessage> getMessageBySender(@PathVariable("sid") Integer sid) {
        return postMessageService.getMessageBySender(sid);
    }

    @GetMapping("/postmessage/receiver/{rid}")
    public List<PostMessage> getMessageByReceiver(@PathVariable("rid") Integer rid) {
        return postMessageService.getMessageByReceiver(rid);
    }

    @PostMapping("/postmessage/sender/{sid}/receiver/{rid}")
    public void addMessage(@PathVariable("sid") Integer sid, @PathVariable("rid") Integer rid,@RequestBody String message) {
        postMessageService.addMessage(sid, rid, message);
    }
}
