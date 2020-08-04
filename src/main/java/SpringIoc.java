import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.king.model.User;
import top.king.utils.StringHandler;

import java.time.Instant;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SpringIoc {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:bean.xml");
        MessageSource source = context.getBean("messageSource", MessageSource.class);
        for(int i=0;i<5;i++) {
            String message1 = source.getMessage("login.name", new String[0], Locale.CHINA);
            String message = source.getMessage("login.name", new String[0], Locale.US);
            System.out.println("中文：" + message1);
            System.out.println("英文：" + message);
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /*public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:application.xml");
        UserServiceImpl bean = context1.getBean("userServiceImpl", UserServiceImpl.class);
        bean.selectUsers();
    }*/


    /*public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserTest userTest = context.getBean("user1", UserTest.class);
        System.out.println(userTest);
    }*/
}
