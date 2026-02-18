package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String MASTER_URL =
            "jdbc:postgresql://localhost:5437/testdb";

    private static final String SLAVE_URL =
            "jdbc:postgresql://localhost:5436/testdb";

    private static final String USER = "postgres";
    private static final String PASSWORD = "password";


    public static Connection getMasterConnection()
            throws SQLException {

        return DriverManager.getConnection(
                MASTER_URL, USER, PASSWORD);

    }


    public static Connection getSlaveConnection()
            throws SQLException {

        return DriverManager.getConnection(
                SLAVE_URL, USER, PASSWORD);

    }

}
