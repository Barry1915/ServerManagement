package com.example.servermanagement.Mapper;


import com.example.servermanagement.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> findall();

    @Select("select * from user where username = #{username}")
    public User login(String username);

}
