package com.xiong.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String username;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer money;

}
