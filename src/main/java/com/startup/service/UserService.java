package com.startup.service;

import com.startup.model.User;
import java.util.List;

public interface UserService {
    long saveUser(User user);
    boolean updateUser(User user);
    User getUser(long id);
}
