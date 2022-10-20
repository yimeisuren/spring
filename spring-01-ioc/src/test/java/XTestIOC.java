import com.xiong.config.XSpringConfig;
import com.xiong.lifecycle.XLifeCycle;
import com.xiong.pojo.User;
import com.xiong.service.AutoUserService;
import com.xiong.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XTestIOC {


    /**
     * 依赖注入: 手动配置
     */
    @Test
    void testWired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.show();
    }

    /**
     * 依赖注入: 自动配置
     */
    @Test
    public void testAutoWired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml");
        AutoUserService userService = context.getBean("autoUserService", AutoUserService.class);
        userService.show();
    }

    /**
     * 工厂Bean, 实现了FactoryBean接口的类, 返回值不由xml中的class属性决定, 而是由类中重载的方法决定
     */
    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml");
        User user = context.getBean("userFactory", User.class);
        System.out.println("user = " + user);
    }

    /**
     * Bean对象生命周期
     */
    @Test
    public void testLifeCycle() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml");
        XLifeCycle xLifeCycle = context.getBean("xLifeCycle", XLifeCycle.class);
        System.out.println("xLifeCycle = " + xLifeCycle);
        context.close();
    }

    /**
     * Bean对象生命周期: 含后置处理器
     */
    @Test
    public void testBeanPostProcessor() {
        //在加载配置文件的时候会创建所有的Bean对象, 因此会输出很多遍的before和after...
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-ioc.xml");
        XLifeCycle xLifeCycle = context.getBean("xLifeCycle", XLifeCycle.class);
        System.out.println("xLifeCycle = " + xLifeCycle);
        context.close();
    }
    
    @Test
    public void testAnnotationConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(XSpringConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println("user = " + user);
    }


}
