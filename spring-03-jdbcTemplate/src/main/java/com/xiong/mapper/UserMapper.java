package com.xiong.mapper;


import com.xiong.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 添加一个用户
     *
     * @param user
     */
    void add(User user);

    void update(User user);

    void delete(Integer id);

    int findCounts();

    User queryUser(Integer id);

    List<User> queryUsers(Object... args);

    void batchAddUsers(List<Object[]> batchArgs);
}
