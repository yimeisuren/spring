import com.xiong.pojo.Person;
import com.xiong.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        通过id进行获取
        Person person = context.getBean("human", Person.class);
        System.out.println(person);
//        通过类型进行获取
        Person bean = context.getBean(Person.class);
        System.out.println(bean);

    }
}
