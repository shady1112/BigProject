package org.example.controller;


import org.example.bean.Users;
import org.example.common.Result;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RequestMapping("login")
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    /**
     * 这是用户登录方法
     *
     * @param user 用户信息
     */
    @RequestMapping("userLogin")
    public Result userLogin(Users user) {
        return loginService.selectUserCount(user);
    }

    /**
     * 这是用户登录方法
     *
     * @param user 用户信息
     */
    @RequestMapping("userRegistry")
    public Result userRegistry(Users user) {
        return loginService.selectUserCount(user);
    }

}
