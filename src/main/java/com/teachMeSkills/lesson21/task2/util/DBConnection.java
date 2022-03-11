package com.teachMeSkills.lesson21.task2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    private static final String URL = DBProperty.getDBProperties("url");
    private static final String USER = DBProperty.getDBProperties("user");
    private static final String PASSWORD = DBProperty.getDBProperties("password");

    public static Connection getConnection(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
