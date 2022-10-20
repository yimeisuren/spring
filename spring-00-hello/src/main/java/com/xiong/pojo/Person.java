package com.xiong.pojo;

import com.xiong.pojo.middle.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    //    基本数据类型
    private String name;
    private Integer age;
    //    自定义类型
    private Address address;
    //    数组
    private String[] books;
    //    List集合
    private List<String> hobbies;
    //    Map集合
    private Map<Integer, String> card;
    //    Set集合
    private Set<String> games;
    //    常用类Properties, 实际上也是Map
    private Properties info;
}
