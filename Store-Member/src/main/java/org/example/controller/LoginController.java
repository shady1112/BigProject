package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.example.bean.Users;
import org.example.common.result.Result;
import org.example.utils.ResultUtil;
import org.example.service.LoginService;
import org.example.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

@Slf4j
@CrossOrigin
@RequestMapping("login")
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 这是用户登录方法
     *
     * @param user 用户信息
     */
    @RequestMapping("userLogin")
    public Result userLogin(Users user) {
        if(user==null){
           return ResultUtil.error("用户信息为空！");
        }
        if (StringUtils.isBlank(user.getAccount())){
            return ResultUtil.error("用户账号为空！");
        }
        if (StringUtils.isBlank(user.getPassword())){
            return ResultUtil.error("用户密码为空！");
        }
        return loginService.selectUserCount(user);
    }

    /**
     * 这是用户登录方法
     *
     * @param user 用户信息
     */
    @PostMapping("userRegistry")
    public Result userRegistry(Users user,String code) {
        if(user==null){
            return ResultUtil.error("用户信息为空！");
        }
        if (StringUtils.isBlank(user.getAccount())){
            return ResultUtil.error("用户账号为空！");
        }
        if (StringUtils.isBlank(user.getPassword())){
            return ResultUtil.error("用户密码为空！");
        }
        return loginService.registry(user,code);
    }

    @PostMapping("sendMail")
    public Result sendMail (String userMail ) throws Exception {
        String randomCode = RandomStringUtils.random(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");

            Result result = SendMail.sendMail(userMail, randomCode);
        if (result.isSuccess()==true){
            redisTemplate.opsForValue().set("randomCode", randomCode,30, TimeUnit.SECONDS);
            return result;
        }
        return result;
    }



}
