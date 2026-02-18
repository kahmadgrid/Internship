package org.example;

import java.sql.ResultSet;

public class UserDAO {


    public void insertUser(int id, String name)
            throws Exception {

        String sql =
                "INSERT INTO users VALUES ("
                        + id + ", '" + name + "')";

        QueryRouter.executeQuery(sql);

    }


    public void updateUser(int id, String name)
            throws Exception {

        String sql =
                "UPDATE users SET name='"
                        + name
                        + "' WHERE id="
                        + id;

        QueryRouter.executeQuery(sql);

    }


    public void deleteUser(int id)
            throws Exception {

        String sql =
                "DELETE FROM users WHERE id="
                        + id;

        QueryRouter.executeQuery(sql);

    }


    public void getAllUsers()
            throws Exception {

        String sql =
                "SELECT * FROM users";

        ResultSet rs =
                QueryRouter.executeQuery(sql);

        while(rs.next()) {

            System.out.println(
                    rs.getInt("id")
                            + " "
                            + rs.getString("name"));

        }

    }

}
