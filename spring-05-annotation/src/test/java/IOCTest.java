import com.xiong.config.MainConfig;
import com.xiong.pojo.Book;
import com.xiong.pojo.Person;
import com.xiong.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest {

    @SuppressWarnings("resource")
    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Map<String, Person> beans = applicationContext.getBeansOfType(Person.class);
        System.out.println(beans);
    }

    @Test
    public void test03() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean("personFactoryBean", Person.class);
        System.out.println(bean);
    }

    @Test
    public void test04() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器创建完成");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
        applicationContext.close();
        System.out.println("容器已关闭");
    }

    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test06() {
//        使用无参构造, 之前都是使用的有参构造来创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(MainConfig.class);
        context.refresh();

    }
}
