package org.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.bean.Users;
import org.example.common.result.Result;
import org.example.common.result.ResultEnum;
import org.example.service.ResolverApi;
import org.example.utils.ResultUtil;
import org.example.utils.TokenUtil;
import org.example.mapper.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@DubboService(version = "1.0.0",timeout = 1000000)
public class LoginServiceImpl implements ResolverApi {


    @Autowired
    private UsersDao usersDao;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    private  ApplicationContext applicationContext;

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
    public Result registry(Users user, String code) {
        String randomCode = (String) redisTemplate.opsForValue().get("randomCode");
        if (!code.equals(randomCode)){
            return ResultUtil.error("验证码错误！");
        }
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

    @Override
    public Result checkAccount(Users user) throws Exception {
        Integer userCount = usersDao.queryUserCount(user);
        if (userCount==0){
            System.out.println();
            throw new Exception("该用户不存在！");
        }else {
            return ResultUtil.success();
        }
    }

    @Override
    public Result checkEmail(Users user) {
        Integer userCount = usersDao.queryEmailCount(user);
        if (userCount==0){
            throw new RuntimeException("该邮箱不存在！");
        }else {
            return ResultUtil.success();
        }
    }

    @Override
    public Result resetPwd(Users user) {
        try {
            Map<String, Object> jsonStringToMap = JSONObject.parseObject("String", new TypeReference<Map<String, Object>>() {});
            usersDao.resetPwd(user);
            Map resultMap = new HashMap();
            resultMap.put("msg", "密码已成功修改！");
            return ResultUtil.success(resultMap);
        }catch (Exception e){
            log.error("密码修改失败",e);
            return ResultUtil.error("密码修改失败");

        }



    }


}
