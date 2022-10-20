package com.xiong.lifecycle;

import lombok.Data;

@Data
public class XLifeCycle {
    private String name;
    static int i;

    public XLifeCycle() {
        String simpleName = this.getClass().getSimpleName();
        System.out.println(simpleName + "实例注入中......");
        System.out.println((++i) + ": 无参构造器");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println((++i) + ": set()赋值");
    }

    /**
     * 初始化方法
     */
    public void init() {
        System.out.println((++i) + ": init()初始化");
    }

    /**
     * 销毁方法
     */
    private void destroy() {
        System.out.println((++i) + ": destroy()销毁");
    }
}
