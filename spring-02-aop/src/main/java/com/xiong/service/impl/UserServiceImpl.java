package com.xiong.service.impl;

import com.xiong.mapper.UserMapper;
import com.xiong.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //1. 添加UserDao对象作为属性, 并使用set()方式注入
    //2. 在配置文件beans.xml中进行配置
    private UserMapper userDao;

    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }

    @Override
    public void update(String name) {

    }
}
