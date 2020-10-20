package org.example.service;

import org.example.bean.Users;
import org.example.common.result.Result;

public interface LoginService {

    /**
     * 查询是否含有该用户
     * @param user 用户信息
     * @return 数量信息
     */



    Result selectUserCount(Users user);

    Result registry(Users user, String code);

    Result checkAccount(Users user) throws Exception;

    Result checkEmail(Users user);

    Result resetPwd(Users user);
}
