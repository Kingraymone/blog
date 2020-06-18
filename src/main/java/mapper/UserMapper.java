package mapper;

import model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();
}
