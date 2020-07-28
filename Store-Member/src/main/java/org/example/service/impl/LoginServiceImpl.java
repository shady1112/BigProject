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
                resultMap.put("msg", "登陆成功！");
                resultMap.put("lastlogin",lastLogin);
                usersDao.updateLastLogin(new Date(),user.getAccount());
                return ResultUtil.success(resultMap);
            }else {
                return ResultUtil.error(ResultEnum.LOGINERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }finally {
            log.info("登陆失败！");
        }
    }
}
