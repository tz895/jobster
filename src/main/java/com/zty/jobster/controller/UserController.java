package com.zty.jobster.controller;

import com.zty.jobster.dao.UserDao;
import com.zty.jobster.entity.User;
import com.zty.jobster.exception.UsernameIsExitedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        User bizUser = userDao.findByUsername(user.getUsername());
        if(null != bizUser){
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        return userDao.save(user);
    }

}
