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
            statement.setString(1, user.getIpAddress());
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
            String sql = "UPDATE users SET first_name = ?, last_name = ?, email_address = ?, phone_number = ?, address = ?, zipcode = ?, estimated_rent_currency = ?, estimated_rent_lower = ?, estimated_rent_upper = ?, expected_rent_currency = ?, expected_rent_lower = ?, expected_rent_upper = ? WHERE id=?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmailAddress());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getAddress());
            statement.setInt(6, user.getZipcode());
            RentRange estimatedRent = user.getEstimatedRent();
            if (estimatedRent != null) {
                Currency estimatedRentCurrency = estimatedRent.getCurrency();
                if (estimatedRentCurrency != null) {
                    statement.setString(7, estimatedRentCurrency.toString());
                } else {
                    statement.setString(7, null);
                }
                statement.setInt(8, estimatedRent.getLowerBound());
                statement.setInt(9, estimatedRent.getUpperBound());
            } else {
                statement.setString(7, null);
                statement.setObject(8, null);
                statement.setObject(9, null);
            }
            RentRange expectedRent = user.getExpectedRent();
            if (expectedRent != null) {
                Currency expectedRentCurrency = expectedRent.getCurrency();
                if (expectedRentCurrency != null) {
                    statement.setString(10, expectedRentCurrency.toString());
                } else {
                    statement.setString(10, null);
                }
                statement.setInt(11, expectedRent.getLowerBound());
                statement.setInt(12, expectedRent.getUpperBound());
            } else {
                statement.setString(10, null);
                statement.setObject(11, null);
                statement.setObject(12, null);
            }
            statement.setLong(13, user.getUserId());
            System.out.println(statement.toString());
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
                int zipcode = rs.getInt("zipcode");
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
                user.setZipcode(zipcode);

                if(esRentCurrency != null) {
                    user.setEstimatedRent(new RentRange(Currency.getInstance(esRentCurrency), estimatedRentLowerBound, estimatedRentUpperBound));
                }

                if(exRentCurrency != null) {
                    user.setExpectedRent(new RentRange(Currency.getInstance(exRentCurrency), expectedRentLowerBound, expectedRentUpperBound));
                }
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
}
