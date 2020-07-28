package org.example.controller;


import com.alibaba.fastjson.JSONObject;
import org.example.bean.Users;
import org.example.common.Result;
import org.example.common.ResultUtil;
import org.example.common.State;
import org.example.common.TokenUtil;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shady
 */
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


}
