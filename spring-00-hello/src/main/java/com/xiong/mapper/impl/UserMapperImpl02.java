package com.xiong.mapper.impl;

import com.xiong.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "userMapper02")
public class UserMapperImpl02 implements UserMapper {
    @Override
    public void show() {
        String className = this.getClass().getSimpleName();
        System.out.println(className + "的show()方法");
    }
}
