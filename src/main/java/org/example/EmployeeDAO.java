package org.example;

import java.sql.*;

public class EmployeeDAO {

    // WRITE
    public void insertEmployee(int id, String name)
            throws SQLException {

        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";

        // 1️⃣ Write to MASTER
        try (Connection masterConn =
                     DataSourceManager.getConnection(DBType.MASTER);
             PreparedStatement ps =
                     masterConn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();

            System.out.println("Inserted into MASTER");
        }

        // 2️⃣ Replicate to SLAVE
        try (Connection slaveConn =
                     DataSourceManager.getConnection(DBType.SLAVE);
             PreparedStatement ps =
                     slaveConn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();

            System.out.println("Replicated to SLAVE");
        }
    }


    // READ → Slave
    public void getEmployee(int id) throws SQLException {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn =
                     DataSourceManager.getConnection(DBType.SLAVE);
             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name"));
            }
        }
    }


    // UPDATE
    public void updateEmployee(int id, String newName)
            throws SQLException {

        String sql = "UPDATE students SET name = ? WHERE id = ?";

        // MASTER
        try (Connection masterConn =
                     DataSourceManager.getConnection(DBType.MASTER);
             PreparedStatement ps =
                     masterConn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Updated MASTER");
        }

        // SLAVE
        try (Connection slaveConn =
                     DataSourceManager.getConnection(DBType.SLAVE);
             PreparedStatement ps =
                     slaveConn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Replicated UPDATE to SLAVE");
        }
    }


    // DELETE → Master
    public void deleteEmployee(int id)
            throws SQLException {

        String sql = "DELETE FROM students WHERE id = ?";

        // MASTER
        try (Connection masterConn =
                     DataSourceManager.getConnection(DBType.MASTER);
             PreparedStatement ps =
                     masterConn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Deleted from MASTER");
        }

        // SLAVE
        try (Connection slaveConn =
                     DataSourceManager.getConnection(DBType.SLAVE);
             PreparedStatement ps =
                     slaveConn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Replicated DELETE to SLAVE");
        }
    }

}

