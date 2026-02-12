package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceManager {

    // Master DB
    private static final String MASTER_URL =
            "jdbc:postgresql://localhost:5432/masterdb";
    private static final String MASTER_USER = "postgres";
    private static final String MASTER_PASS = "0000";

    // Slave DB
    private static final String SLAVE_URL =
            "jdbc:postgresql://localhost:5432/slavedb";
    private static final String SLAVE_USER = "postgres";
    private static final String SLAVE_PASS = "0000";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(DBType type) throws SQLException {

        if (type == DBType.MASTER) {
            return DriverManager.getConnection(
                    MASTER_URL, MASTER_USER, MASTER_PASS);
        } else {
            return DriverManager.getConnection(
                    SLAVE_URL, SLAVE_USER, SLAVE_PASS);
        }
    }
}
