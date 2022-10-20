package com.xiong.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xiong.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类, 相当于beans.xml配置文件
 */
@Configuration
@ComponentScan(basePackages = {"com.xiong"})
public class XSpringConfig {

    /**
     * 配置jar包中引入的类,
     * <p>
     * 默认情况下, 类名首字母小写即为bean.id, 也可以在@Bean注解中显式的指明
     */
    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setName("root");
        user.setBooks(new String[]{"<<红楼梦>>", "<<三国演义>>", "<<西游记>>", "<<水浒传>>"});
        return user;
    }
}
