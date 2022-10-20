package com.xiong.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//配置类
@Configuration
//组件扫描
@ComponentScan(basePackages = "com.xiong")
//开启事务管理
@EnableTransactionManagement
public class TxConfig {
    /**
     * 数据库连接池对象
     *
     * @return 数据库连接池对象
     */
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://root@localhost:3306/jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * ioc容器会根据形参的类型去查找相应的bean对象, 然后注入到其中, 即配置类中的形参会从ioc容器中根据类型去取
     * 如果在方法里面调用, 则会创建两个连接池对象
     *
     * @param dataSource ioc容器中已有的DruidDataSource对象
     * @return JdbcTemplate对象
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
