package com.xiong.service;

import com.xiong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//需要开启注解扫描
@Service
public class AutoUserService {
    /**
     * 使用@Autowired注解后, 不需要为UserMapper对象添加set方法来进行注入
     * <p>
     * \@Autowired: 从IOC容器中取出UserMapper类型的对象为其赋值
     * <p>
     * \@Qualifier: 从IOC容器中取出id为userMapper的对象为其赋值
     */

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void show() {
        System.out.println("This is AutoUserService");
        System.out.println("*******************************************");
        userMapper.show();
    }
}
