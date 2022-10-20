package com.xiong.mapper.proxy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserMapperProxy {
    private static int countTool;

    /**
     * 自定义函数变量来接收切入点表达式, 其中切入点为add()函数
     * <p>
     * 使用java风格表示下面的含义, 相当于
     * <p>
     * Function pointcut = new @Pointcut("execution(* com.xiong.mapper.impl.UserMapperImpl.add())");
     */
    @Pointcut(value = "execution(* com.xiong.mapper.impl.UserMapperImpl.login())")
    private final void pointcut() {
    }

    /**
     * 前置通知方法, 通过方法名提取该方法的切入点
     */
    @Before(value = "pointcut()")
    public void before() {
        System.out.println((++countTool) + "before()前置增强执行中...");
    }

    /**
     * After注解: 不论是否有异常,都会执行
     */
    @After(value = "execution(* com.xiong.mapper.impl.UserMapperImpl.login(..))")
    public void after() {
        System.out.println((++countTool) + "最终通知执行中...");
    }

    /**
     * AfterReturning注解: 当有异常时不执行
     */
    @AfterReturning(value = "execution(* com.xiong.mapper.impl.UserMapperImpl.login(..))")
    public void afterReturning() {
        System.out.println((++countTool) + "后置通知执行中...");
    }

    @AfterThrowing(value = "execution(* com.xiong.mapper.impl.UserMapperImpl.login(..))")
    public void afterThrowing() {
        System.out.println((++countTool) + "异常通知执行中...");
    }

    @Around(value = "execution(* com.xiong.mapper.impl.UserMapperImpl.login(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println((++countTool) + "环绕之前执行该代码...");
//        被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println((++countTool) + "环绕之后执行该代码...");
    }
}
