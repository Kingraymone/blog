package configuration;

import com.king.model.Role;
import com.king.model.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bean {
    @org.springframework.context.annotation.Bean("role")
    public Role createRole() {
        Role role = new Role();
        role.setRoleId(2);
        role.setRolename("系统管理员");
        return role;
    }

    @org.springframework.context.annotation.Bean("user")
    public User createUser() {
        User user = new User();
        user.setUserId(2);
        user.setUsername("king");
        return user;
    }
}
