package org.example.service;

import org.example.bean.Users;
import org.example.common.Result;

public interface LoginService {

    /**
     * 查询是否含有该用户
     * @param user 用户信息
     * @return 数量信息
     */
    Result selectUserCount(Users user);

    Result registry(Users user);
}