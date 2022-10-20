package com.xiong.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(String username, int money) {
        String sql = "update person set money=money+? where username=?";
        Object[] args = {money, username};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void reduce(String username, int money) {
        String sql = "update person set money=money-? where username=?";
        Object[] args = {money, username};
        jdbcTemplate.update(sql, args);
    }
}
