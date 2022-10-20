package com.xiong;

import com.xiong.mapper.UserMapper;
import com.xiong.pojo.Person;
import com.xiong.pojo.Pet;
import com.xiong.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    @Test
    public void getXmlConfigTest() {
        //1. 配置文件可以是任意名称
        //2. ClassPathXmlApplicationContext表示classpath下的路径
        //3. FileSystemXmlApplicationContext表示文件系统下的路径
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_01_base.xml");
        User user01 = context.getBean("user01", User.class);
        User customer = context.getBean("customer", User.class);
        User buyer = context.getBean("buyer", User.class);

        assert (user01 == customer && user01 == buyer);

        System.out.println("user01 = " + user01);
        System.out.println("customer = " + customer);
        System.out.println("buyer = " + buyer);
    }

    /**
     * 测试有参构造功能
     */
    @Test
    public void argConstructorTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_01_base.xml");
        Pet pet = context.getBean("pet", Pet.class);
        System.out.println(pet);
    }

    @Test
    public void pNameSpaceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_02_p_namespace.xml");
        User user02 = context.getBean("user02", User.class);
        User user03 = context.getBean("user03", User.class);
        System.out.println("user02 = " + user02);
        System.out.println("user03 = " + user03);
    }


    @Test
    public void refBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_03_ref.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println("person = " + person);

    }

    @Test
    public void annotationTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_04_annotation.xml");

        Person human = context.getBean("human", Person.class);
        System.out.println("human = " + human);

        UserMapper userMapper01 = context.getBean("userMapper01", UserMapper.class);
        userMapper01.show();
        UserMapper userMapper02 = context.getBean("userMapper02", UserMapper.class);
        userMapper02.show();

//        由于设置了自定义的组件扫描过滤器, 因此下面getBean()会报错
/*        Animal animal = context.getBean("animal", Animal.class);
        System.out.println("animal = " + animal);*/
    }
}
