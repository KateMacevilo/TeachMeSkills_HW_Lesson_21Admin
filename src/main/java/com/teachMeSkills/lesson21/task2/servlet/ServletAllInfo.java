package com.teachMeSkills.lesson21.task2.servlet;

import com.teachMeSkills.lesson21.task2.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/adminAllInfo")
public class ServletAllInfo extends HttpServlet {

    private static final String SELECT_ALL = "SELECT * FROM USERS";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {

            resp.getWriter().println("USERS DATA");

            while (resultSet.next()) {

                int idUser = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);

                resp.getWriter().println("ID: " + idUser);
                resp.getWriter().println("First name: " + name);
                resp.getWriter().println("Last name: " + lastName);
                resp.getWriter().println("Age: " + age);
                resp.getWriter().println("---------------------");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
