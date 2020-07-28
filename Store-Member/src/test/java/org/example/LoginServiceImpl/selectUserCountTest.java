package org.example.LoginServiceImpl;


import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.example.Test.BaseTest;
import org.example.bean.Users;
import org.example.common.Result;
import org.example.mapper.UsersDao;
import org.example.service.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
public class selectUserCountTest extends BaseTest {

    @Resource
    private LoginService loginService;

    @Test
    public void SHOULD_GET_SUCCESS_RESULTselectUserCount() {
        ddd ();
        ccc ();
        Users users = new Users();
        Result result = loginService.selectUserCount(users);
        Assert.assertEquals("SUCCESS", result.getCode());
    }

    public void ddd (){
        new MockUp<UsersDao>(UsersDao.class){
            @Mock
            public String queryLastLogin(Integer id){
                return "2222222";
            }
        };
    }

    public void ccc (){
        new MockUp<UsersDao>(UsersDao.class){
            @Mock
            public Integer selectUserCount(Users users){
                return 3;
            }
        };
    }

}
