package com.xiong.pojo;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 24563
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<Integer, String> card;
    private Set<String> games;
    private Properties info;
}
