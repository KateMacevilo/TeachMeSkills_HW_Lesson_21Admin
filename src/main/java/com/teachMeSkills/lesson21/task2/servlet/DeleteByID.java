package com.teachMeSkills.lesson21.task2.servlet;

import com.teachMeSkills.lesson21.task2.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteByID")
public class DeleteByID extends HttpServlet {

    private static final String DELETE_BY_ID = "DELETE FROM users WHERE iduser = ?";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int IDUser = Integer.parseInt(req.getParameter("IDUser"));

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setInt(1, IDUser);
            int result_set = preparedStatement.executeUpdate();

            if (result_set > 0) {
                resp.getWriter().println(result_set + " row deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
