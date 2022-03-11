package com.teachMeSkills.lesson21.task2.servlet;

import com.teachMeSkills.lesson21.task2.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addUser")
public class AddNewUser extends HttpServlet {

    private static final String INSERT_USER = "INSERT INTO users (name, lastName, age) values (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            int result_set = preparedStatement.executeUpdate();

            if (result_set > 0) {
                resp.getWriter().println(result_set + " row added");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
