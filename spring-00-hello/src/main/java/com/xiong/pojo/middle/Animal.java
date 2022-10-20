package com.xiong.pojo.middle;

import lombok.Data;
import org.springframework.stereotype.Controller;

/**
 * 由于没有使用默认的组件扫描的过滤器, 因此该类不会被注入到IOC容器中
 * @author Administrator
 */
@Data
@Controller
public class Animal {
    private String name;
}
