package com.teachMeSkills.lesson21.task2.servlet;

import com.teachMeSkills.lesson21.task2.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/SelectByID")
public class SelectByID extends HttpServlet {

    private static final String SELECT_BY_ID = "SELECT * FROM users WHERE iduser = ?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int IDUser = Integer.parseInt(req.getParameter("IDUser"));

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {

            preparedStatement.setInt(1, IDUser);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    int idUser = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    int age = resultSet.getInt(4);

                    resp.getWriter().println("ID: " + idUser);
                    resp.getWriter().println("First name: " + name);
                    resp.getWriter().println("Last name: " + lastName);
                    resp.getWriter().println("Age: " + age);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
