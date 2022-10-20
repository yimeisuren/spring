package com.xiong.mapper;


public interface PersonDao {
    public void add(String username, int money);

    public void reduce(String username, int money);
}
