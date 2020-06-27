package configuration;

import com.king.model.Role;
import com.king.model.User;
import com.king.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import(Bean.class)
@Configuration
@ComponentScan("com.king.service")
@PropertySource("classpath:resource.properties")
public class Config {
    @Value("${username}")
    String name;
    @Value("${password}")
    String password;

    @org.springframework.context.annotation.Bean({"userTest","user1","user2"})
    public UserTest create(@Autowired User user, @Autowired Role role) {
        UserTest userTest = new UserTest();
        userTest.setRole(role);
        userTest.setUser(user);
        userTest.setName(name);
        userTest.setPassword(password);
        return userTest;
    }
}
