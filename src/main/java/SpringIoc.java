import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.king.serviceimpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoc {
    public static void main(String[] args) {
        System.out.println("\uE000\uE001\uE002");
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
