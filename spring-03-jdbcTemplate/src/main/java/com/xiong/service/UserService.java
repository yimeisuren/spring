package com.xiong.service;

import com.xiong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiong.pojo.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void add(User user) {
        userMapper.add(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(Integer id) {
        userMapper.delete(id);
    }

    public int findCounts() {
        return userMapper.findCounts();
    }

    public User queryUser(Integer id) {
        return userMapper.queryUser(id);
    }


    public List<User> queryUsers(Object... args) {
        return userMapper.queryUsers(args);
    }

    public void batchAddUsers(List<Object[]> batchArgs) {
        userMapper.batchAddUsers(batchArgs);
    }
}
