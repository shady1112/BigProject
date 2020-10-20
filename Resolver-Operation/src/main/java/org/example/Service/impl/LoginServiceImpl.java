package org.example.Service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.Service.LoginService;
import org.example.bean.Users;
import org.example.common.result.Result;
import org.example.service.ResolverApi;

public class LoginServiceImpl implements LoginService {

    @DubboReference
    ResolverApi resolverApi;



    @Override
    public Result selectUserCount(Users user) {
        return resolverApi.selectUserCount(user);
    }

    @Override
    public Result registry(Users user, String code) {
        return resolverApi.registry(user,code);
    }

    @Override
    public Result checkAccount(Users user) throws Exception {
        return resolverApi.checkAccount(user);
    }

    @Override
    public Result checkEmail(Users user) {
        return resolverApi.checkEmail(user);
    }

    @Override
    public Result resetPwd(Users user) {
        return resolverApi.resetPwd(user);
    }
}
