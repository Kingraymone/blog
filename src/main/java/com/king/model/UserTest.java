package com.king.model;

import lombok.Data;

@Data
public class UserTest {
    private String name;
    private String password;
    User user;
    Role role;
}
