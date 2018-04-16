package com.startup.service;

import com.startup.data.DatabaseConfig;
import com.startup.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.*;
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
            String sql = "INSERT INTO users(ip_address, first_name, last_name, email_address, phone_number, address) VALUES(?, ?, ?, ?, ?, ?, ?) RETURNING id;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "1.1.1.1");
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmailAddress());
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEstimatedRent().toString());
            ResultSet rs = statement.executeQuery();
            long id = -1;
            if (rs.next()) {
                id = rs.getLong("id");
            }
            connection.close();
            return id;
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
