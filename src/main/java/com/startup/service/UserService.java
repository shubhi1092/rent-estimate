package com.startup.service;

import com.startup.model.User;
import java.util.List;

public interface UserService {
    long saveUser(User user);
    void updateUser(User user);
    User getUser(long id);
    List<User> getAllUsers();
}
