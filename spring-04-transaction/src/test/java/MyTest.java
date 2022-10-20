import com.xiong.config.TxConfig;
import com.xiong.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    void changeV1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.changeV1("lucy", "tom", 200);
    }

    @Test
    void changeV2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.changeV2("lucy", "tom", 300);
    }

    @Test
    void changeV3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.changeV2("lucy", "tom", 200);
    }
}
