package org.example;

import java.sql.*;

public class QueryRouter {


    public static ResultSet executeQuery(String sql)
            throws Exception {

        Connection conn;
        String trimmedSql = sql.trim().toLowerCase();
        if(trimmedSql.startsWith("select")) {

            conn = DBConnection.getSlaveConnection();

            System.out.println("Reading from SLAVE");

        }
        else {

            conn = DBConnection.getMasterConnection();

            System.out.println("Writing to MASTER");

        }

        Statement stmt = conn.createStatement();

        if(trimmedSql.startsWith("select")) {

            return stmt.executeQuery(sql);

        }
        else {

            stmt.executeUpdate(sql);

            conn.close();

            return null;

        }

    }

}
