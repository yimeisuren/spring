package com.xiong;

import com.xiong.config.JDBCTemplateConfig;
import com.xiong.mapper.UserMapper;
import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class XTestJDBCTemplate {

    @Test
    public void testJdbcTemplate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.execute("insert into user values (1,'root','root','Shanghai','123456')");
    }

    @Test
    public void testAnnotationConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.queryUser(1);
        System.out.println("user = " + user);
    }

    @Test
    void testAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);
        UserMapper userMapper = context.getBean("'userMapperImpl", UserMapper.class);
        User user = new User(19, "周星驰", "root", "中国香港", "123456789");
        userMapper.add(user);
    }

    @Test
    void update() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);
//        这里获取Bean一定要写成userDaoImpl, 符合类名第一个字母小写
        UserMapper userMapper = context.getBean("'userMapper", UserMapper.class);
        userMapper.update(new User(1, "root", "root", "root", "root"));
    }

    @Test
    void delete() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);

        UserMapper userMapper = context.getBean("'userMapper", UserMapper.class);
        userMapper.delete(1);
    }

    @Test
    void findCounts() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        int counts = userService.findCounts();
        System.out.println(counts);
    }

    @Test
    void queryForObject() {
        int id = 2;
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.queryUser(id));
    }

    @Test
    void query() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        List<User> users = userService.queryUsers(1, 2, 3, 4, 5);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void batchUpdate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        List<Object[]> data = new ArrayList<>();
        Object[] o1 = {20, "xiong1", "root", "root", "root"};
        Object[] o2 = {21, "xiong2", "root", "root", "root"};
        Object[] o3 = {22, "xiong3", "root", "root", "root"};
        data.add(o1);
        data.add(o2);
        data.add(o3);
        userService.batchAddUsers(data);
    }
}
