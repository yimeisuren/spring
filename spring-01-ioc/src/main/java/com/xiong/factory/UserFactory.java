package com.xiong.factory;

import com.xiong.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setName("beanFromFactory");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
