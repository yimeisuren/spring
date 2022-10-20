package com.xiong.mapper.impl;

import com.xiong.mapper.UserMapper;
import org.springframework.stereotype.Repository;


/**
 * value值相当于bean.id, 默认是类名首字母小写
 */
@Repository(value = "userMapper01")
public class UserMapperImpl01 implements UserMapper {

    @Override
    public void show() {
        System.out.println("UserMapperImpl01的show()方法");
    }
}

/*
使用xml的配置如下:
<bean  id="userMapper"
       class="com.xiong.mapper.impl.UserMapperImpl01"
       autowire="byName"/>
*/
