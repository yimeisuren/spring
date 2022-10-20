package com.xiong.config;

import com.xiong.condition.LinuxCondition;
import com.xiong.condition.WindowsCondition;
import com.xiong.filter.MyTypeFilter;
import com.xiong.pojo.Book;
import com.xiong.pojo.Person;
import com.xiong.pojo.PersonFactoryBean;
import com.xiong.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@PropertySource(value = {"classpath:/user.properties"})
@Configuration
@ComponentScan(value = "com.xiong", useDefaultFilters = false, excludeFilters = {
//        自定义规则
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class}),
//        指定过滤规则, 使用注解规则排除
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})
public class MainConfig implements BeanPostProcessor {

    @Bean(value = "human")
    public Person person() {
        return new Person("root", 24);
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person bill() {
        return new Person("bill gates", 62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person linus() {
        return new Person("linus", 48);
    }

    /**
     * ObjectFactoryBean实现了FactoryBean接口, 当使用id调用时实际装配的是工厂创建的对象
     *
     * @return
     */
    @Bean
    public PersonFactoryBean personFactoryBean() {
        return new PersonFactoryBean();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Book book() {
        return new Book();
    }

    @Bean
    public User user() {

        return new User("root", 24);
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanName);
        return bean;
    }
}
