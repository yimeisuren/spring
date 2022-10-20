package com.xiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements InitializingBean, DisposableBean {
    @Value("${user.username}")
    String username;
    @Value("${user.userAge}")
    Integer userAge;

    /**
     * 初始化完成后执行的方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }


}
