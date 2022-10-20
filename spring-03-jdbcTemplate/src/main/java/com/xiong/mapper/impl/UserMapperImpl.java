package com.xiong.mapper.impl;

import com.xiong.mapper.UserMapper;
import com.xiong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userMapper")
public class UserMapperImpl implements UserMapper {

    /**
     * 从IOC容器中取出JdbcTemplate对象, 对该属性赋值
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into user values(?,?,?,?,?)";
        Object[] args = {user.getId(), user.getName(), user.getPassword(), user.getAddress(), user.getPhone()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    /**
     * 使用jdbcTemplate完成修改功能
     *
     * @param user 需要修改的对象的值, 根据id来进行修改
     */
    @Override
    public void update(User user) {
        String sql = "update user set password=?,address=? where id=?";
        Object[] args = {user.getPassword(), user.getAddress(), user.getId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(Integer id) {

        String sql = "delete from user where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int findCounts() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public User queryUser(Integer id) {
        String sql = "select * from user where id = ?";
        Object[] args = {id};
//        如果id不存在, 会报空指针异常
//        BeanPropertyRowMapper会封装返回对象
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), args);
    }


    @Override
    public List<User> queryUsers(Object... args) {
        int length = args.length;
//        拼接sql
        StringBuilder sql = new StringBuilder("select * from user u where id in ");
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sql.append("(?");
            } else {
                sql.append(", ?");
            }
            if (i == length - 1) {
                sql.append(")");
            }
        }
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(User.class), args);
    }


    @Override
    public void batchAddUsers(List<Object[]> batchArgs) {
        String sql = "insert into user values (?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }


}
