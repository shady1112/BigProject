package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.bean.Users;
import org.example.common.Result;
import org.example.common.ResultEnum;
import org.example.common.ResultUtil;
import org.example.common.TokenUtil;
import org.example.mapper.UsersDao;
import org.example.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private UsersDao usersDao;

    @Override
    public Result selectUserCount(Users user) {
        try {
            Integer userCount = usersDao.selectUserCount(user);
            String lastLogin = usersDao.queryLastLogin(user.getAccount());
            if (userCount == 1) {
                Map<String, String> resultMap = new HashMap(4);
                resultMap.put("token", TokenUtil.GenneratorToken(user));
                resultMap.put("msg", "欢迎您！");
                resultMap.put("lastlogin",lastLogin);
                usersDao.updateLastLogin(new Date(),user.getAccount());
                return ResultUtil.success(resultMap);
            }else {
                return ResultUtil.error(ResultEnum.LOGINERROR);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }finally {
            log.info("登陆失败！");
        }
    }

    @Override
    public Result registry(Users user) {
        Integer userCount = usersDao.queryUserCount(user);
        if (userCount>0){
            return ResultUtil.error("该账号已经被注册了！");
        }
        try{
            user.setReg_time(new Date());
            usersDao.registryUser(user);
            Map<String, String> resultMap = new HashMap(4);
            resultMap.put("msg", "注册成功！即将跳转登陆界面...");
            return ResultUtil.success(resultMap);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }finally {
            log.info("注册失败！");
        }
    }
}
