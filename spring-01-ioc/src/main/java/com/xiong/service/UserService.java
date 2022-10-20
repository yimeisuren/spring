package com.xiong.service;

import com.xiong.mapper.UserMapper;

public class UserService {
    private UserMapper userMapper;

    // @AutoWired自动注入 = set方法 + xml配置
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void show(){
        System.out.println("This is UserService");
        System.out.println("******************************************");
        userMapper.show();
    }

}
