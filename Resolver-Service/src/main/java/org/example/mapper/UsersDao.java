package org.example.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.bean.Users;
import org.example.bean.UsersExample;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UsersDao {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Integer selectUserCount(@Param("user")Users user);

    String queryLastLogin(String id);

    void updateLastLogin(@Param("date") Date date,@Param("userAccount") String userAccount);

    void registryUser(@Param("user") Users user);

    Integer queryUserCount(@Param("user")Users user);

    Integer queryEmailCount(@Param("user")Users user);

    void resetPwd(@Param("user")Users user);
}