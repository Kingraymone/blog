import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.king.model.User;

public class SpringIoc {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
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
