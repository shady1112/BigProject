package org.example.service;


import org.example.bean.Users;
import org.example.common.result.Result;

public interface ResolverApi {

    Result selectUserCount(Users user);

    Result registry(Users user, String code);

    Result checkAccount(Users user) throws Exception;

    Result checkEmail(Users user);

    Result resetPwd(Users user);

}
