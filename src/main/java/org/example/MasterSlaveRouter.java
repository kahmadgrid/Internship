//package org.example;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class MasterSlaveRouter {
//
//    public static Connection getConnectionForQuery(String sql)
//            throws SQLException {
//
//        String trimmed = sql.trim().toUpperCase();
//
//        if (trimmed.startsWith("SELECT")) {
//            System.out.println("Routing to SLAVE database");
//            return DataSourceManager.getConnection(DBType.SLAVE);
//        } else {
//            System.out.println("Routing to MASTER database");
//            return DataSourceManager.getConnection(DBType.MASTER);
//        }
//    }
//}
//
//
