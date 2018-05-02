package com.zty.jobster.dao;

import com.zty.jobster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
