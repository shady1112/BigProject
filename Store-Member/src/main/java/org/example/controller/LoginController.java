package org.example.controller;


import org.apache.commons.lang.StringUtils;
import org.example.bean.Users;
import org.example.common.Result;
import org.example.common.ResultUtil;
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
    @RequestMapping("userRegistry")
    public Result userRegistry(Users user) {
        if(user==null){
            return ResultUtil.error("用户信息为空！");
        }
        if (StringUtils.isBlank(user.getAccount())){
            return ResultUtil.error("用户账号为空！");
        }
        if (StringUtils.isBlank(user.getPassword())){
            return ResultUtil.error("用户密码为空！");
        }
        return loginService.registry(user);
    }

}
