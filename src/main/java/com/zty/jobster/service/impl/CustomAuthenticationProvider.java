package com.zty.jobster.service.impl;

import com.zty.jobster.service.CompanyService;
import com.zty.jobster.service.StudentService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    //private UserDetailsService userDetailsService;

    private StudentService studentService;

    private CompanyService companyService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomAuthenticationProvider(StudentService studentService, CompanyService companyService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.studentService = studentService;
        this.companyService = companyService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 认证逻辑
        UserDetails userDetails = studentService.loadUserByUsername(name);

        UserDetails companyDetails = companyService.loadUserByUsername(name);

        if(null != userDetails || null != companyDetails){
            String encodePassword = DigestUtils.md5DigestAsHex((password).getBytes());

            if(null != userDetails && userDetails.getPassword().equals(encodePassword)){
                // 这里设置权限和角色
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add( new GrantedAuthorityImpl("ROLE_STUDENT") );
                //authorities.add( new GrantedAuthorityImpl("AUTH_WRITE") );

                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            }
            else if(null != companyDetails && companyDetails.getPassword().equals(encodePassword)) {
                // 这里设置权限和角色
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();

                authorities.add( new GrantedAuthorityImpl("ROLE_COMPANY") );

                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            }
            else {
                throw new BadCredentialsException("Wrong password");
            }
        }else {
            throw new UsernameNotFoundException("Username not exists");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
