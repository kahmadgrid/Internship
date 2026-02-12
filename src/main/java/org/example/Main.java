package org.example;


import java.sql.*;

public class Main {
    static void main() throws Exception{


     EmployeeDAO dao = new EmployeeDAO();
     dao.getEmployee(10);

    }
}
