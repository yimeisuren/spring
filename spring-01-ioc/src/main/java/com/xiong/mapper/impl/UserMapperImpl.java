package com.xiong.mapper.impl;

import com.xiong.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public void show() {
        System.out.println("This is UserMapper");
    }
}
