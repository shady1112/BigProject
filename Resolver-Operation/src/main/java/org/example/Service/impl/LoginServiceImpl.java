package org.example.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.bean.Users;
import org.example.common.result.Result;
import org.example.service.ResolverApi;
import org.springframework.stereotype.Service;


/**
 * @author Shady
 */
@Service
public class LoginServiceImpl implements ResolverApi {

    @DubboReference(version = "1.0.0",timeout = 1000000)
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
