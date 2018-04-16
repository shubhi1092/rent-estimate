package com.startup.service;

import com.startup.data.DatabaseConfig;
import com.startup.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final static DatabaseConfig dbConfig = new DatabaseConfig();

    @Override
    public long saveUser(User user) {
        // Persist user object in db, return back id
        try {
            BasicDataSource config = dbConfig.dataSource();
            Connection connection = config.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("INSERT INTO users(ip_address, first_name, last_name, email_address, phone_number) VALUES(%s, %s, %s, %s, %s) RETURNING id;", "0.0.0.0", user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber());
            ResultSet rs = statement.executeQuery(sql);
            connection.close();
            return rs.getLong("Id");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public void updateUser(User user) {
        // Update user object in db, requires id to be present
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
