package org.example.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
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
     * 这是用户注册方法
     *
     * @param user 用户信息
     */
    @RequestMapping("userRegistry")
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

    /**
     *邮箱验证码发送
     * @param userMail
     * @return
     * @throws Exception
     */
    @RequestMapping("sendMail")
    public Result sendMail (String userMail ) throws Exception {
         String randomCode = RandomStringUtils.random(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");

         Result result = SendMail.sendMail(userMail, randomCode);
        if (result.isSuccess()==true){
            redisTemplate.opsForValue().set("randomCode", randomCode,60, TimeUnit.MINUTES);
            return result;
        }
        return result;
    }

    /**
     * 忘记密码重置密码
     * @param user
     * @param code
     * @return
     */
    @RequestMapping("/resetPwd")
    public Result resetPwd(Users user,String code){
        if(user==null){
            return ResultUtil.error("用户信息为空！");
        }

        if (code==null){
            return ResultUtil.error("验证码为空！");
        }
        String randomCode = (String) redisTemplate.opsForValue().get("randomCode");
        if (!code.equals(randomCode)){
            return ResultUtil.error("验证码错误，请重新输入！");
        }
        Result result = new Result();
        try {
            loginService.checkAccount(user);
            loginService.checkEmail(user);
             result =  loginService.resetPwd(user);
        }catch (Exception e){
            log.error("resetPwd,{}",e);
            return ResultUtil.error(e.getMessage());
        }
        return result;
    }


}
