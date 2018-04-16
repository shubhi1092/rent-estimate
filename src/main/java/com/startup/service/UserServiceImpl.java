package com.startup.service;

import com.startup.common.CurrencyValue;
import com.startup.data.DatabaseConfig;
import com.startup.model.RentRange;
import com.startup.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.Currency;
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
            String sql = "INSERT INTO users(ip_address, first_name, last_name, email_address, phone_number) VALUES(?, ?, ?, ?, ?) RETURNING id;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "1.1.1.1");
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmailAddress());
            statement.setString(5, user.getPhoneNumber());
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
    public boolean updateUser(User user) {
        // Update user object in db, requires id to be present
        try {
            BasicDataSource config = dbConfig.dataSource();
            Connection connection = config.getConnection();
            String sql = "UPDATE users VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmailAddress());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getEstimatedRent().getCurrency().toString());
            statement.setInt(7, user.getEstimatedRent().getLowerBound());
            statement.setInt(8, user.getEstimatedRent().getUpperBound());
            statement.setString(6, user.getExpectedRent().getCurrency().toString());
            statement.setInt(9, user.getExpectedRent().getLowerBound());
            statement.setInt(10, user.getEstimatedRent().getUpperBound());
            statement.setLong(11, user.getUserId());
            boolean result = statement.execute();
            connection.close();
            return result;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(long id) {
        // Persist user object in db, return back id
        try {
            BasicDataSource config = dbConfig.dataSource();
            Connection connection = config.getConnection();
            String sql = "SELECT * FROM USERS WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            User user = null;
            if (rs.next()) {
                id = rs.getLong("id");
                String ipAddress = rs.getString("ip_address");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String emailAddress = rs.getString("email_address");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");
                String esRentCurrency= rs.getString("estimated_rent_currency");
                int estimatedRentLowerBound = rs.getInt("estimated_rent_lower");
                int estimatedRentUpperBound = rs.getInt("estimated_rent_upper");
                String exRentCurrency= rs.getString("expected_rent_currency");
                int expectedRentLowerBound = rs.getInt("expected_rent_lower");
                int expectedRentUpperBound = rs.getInt("expected_rent_upper");
                user = new User();
                user.setUserId(id);
                user.setIpAddress(ipAddress);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmailAddress(emailAddress);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setExpectedRent(new RentRange(Currency.getInstance(esRentCurrency), estimatedRentLowerBound, estimatedRentUpperBound));
                user.setExpectedRent(new RentRange(Currency.getInstance(exRentCurrency), expectedRentLowerBound, expectedRentUpperBound));
                return user;
            }
            connection.close();
            return user;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
