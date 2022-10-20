package com.xiong;

import com.xiong.mapper.UserMapper;
import com.xiong.mapper.impl.UserMapperImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void main(String[] args) {

        Class[] interfaces = {UserMapper.class};
        UserMapper userDao = new UserMapperImpl();
//        获取代理类对象, 通过代理类对象调用被代理类中的方法
        UserMapper userDaoProxy = ((UserMapper) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new ProxyUserDaoImpl<>(userDao)));
        userDaoProxy.login();
        userDaoProxy.update("21118221");

    }
}

class ProxyUserDaoImpl<T> implements InvocationHandler {
    /**
     * 用于接收被代理类对象
     */
    T proxied;


    public ProxyUserDaoImpl(T proxied) {
        this.proxied = proxied;
    }

    /**
     * UserDaoImpl的代理类, 原来执行UserDaoImpl, 现在执行ProxyUserDao, 即可对UserDaoImpl进行增强
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行");
//        执行被代理类对象的方法, 即原有功能
//        这里还可以根据方法名, 进行进一步的逻辑判断
        Object result = method.invoke(proxied, args);
        System.out.println(result);
        System.out.println("方法之后执行");
        return result;
    }


}
