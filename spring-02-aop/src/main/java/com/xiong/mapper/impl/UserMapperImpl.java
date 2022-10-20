package com.xiong.mapper.impl;

import com.xiong.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * 背景:
 * <p>
 * UserMapper接口中现有两个功能模块, 一个为login, 另一个为update,
 * <p>
 * UserMapperImpl是现有的类, 已经实现了这两部分功能, 现在需要进行业务拓展
 * <p>
 * 需要使用AOP对其进行功能上的增强, 即实现对UserMapperImpl的动态代理
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Override
    public void login() {
        String currentClassName = this.getClass().getSimpleName();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String currentMethodName = stackTraceElements[1].getMethodName();
        System.out.println(currentClassName + "中的" + currentMethodName + "方法已经执行");
    }

    @Override
    public void update(String name) {
        String currentClassName = this.getClass().getSimpleName();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String currentMethodName = stackTraceElements[1].getMethodName();
        System.out.println(currentClassName + "中的" + currentMethodName + "方法已经执行");
    }
}
