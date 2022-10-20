package com.xiong;

import com.xiong.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XTestAop {
    /**
     * 获取原本的功能实现类对象, 而实际完成的执行的工作却是代理的增强方法, 从而实现在客户端代码完全不需要修改
     * <p>
     * UserMapperImpl是现有功能的实现类, 有UserMapper接口
     * <p>
     * UserMapperImplProxy是UserMapperImpl的代理类, 用来增强UserMapperImpl中的现有功能
     */
    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        userMapper.login();
    }
}
