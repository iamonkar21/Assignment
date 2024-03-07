package com.itshaala.configuration;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.itshaala.configuration.DBConstants.*;

public class ConnectionUtil {


    @Getter
    private static Connection connection;

    static {
        try {
            Class.forName(DB_DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
