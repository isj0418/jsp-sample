package com.example.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/taskjsp";
            String user = "root";
            String password = "1234";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("------ db connect success ------ ");
        } catch (Exception ex) {
            System.out.println("db error: " + ex);
        }
        return connection;
    }
}
