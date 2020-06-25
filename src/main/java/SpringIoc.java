import service.ConstructorTest;
import service.TEst;
import model.UserTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoc {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserTest role = (UserTest)context.getBean("user1");
        role.setPassword("213");
        UserTest role2 = (UserTest)context.getBean("userTest");
        System.out.println(role);
        System.out.println(role2);

        ConstructorTest test = context.getBean("constructorTest", ConstructorTest.class);
        System.out.println(test);
    }
}
