package com.xiong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 通过配置类 + 注解来进行配置
 */
@ComponentScan(basePackages = {"com.xiong.mapper"})
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAOP {

}
