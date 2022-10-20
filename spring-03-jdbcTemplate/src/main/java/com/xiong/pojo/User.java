package com.xiong.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String name;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String password;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String address;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String phone;
}

