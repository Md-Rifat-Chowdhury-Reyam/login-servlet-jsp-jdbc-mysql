package org.authentication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter outPW = response.getWriter();

       try {
           // Load Type-4 Driver -- native protocol driver/ Thin Driver
           // MySQL Type-4 driver class
           Class.forName("com.mysql.cj.jdbc.Driver");

           //establish connection
           Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://127.0.0.1:3306/login", "root", "5400");


           //request from login page
           String name = request.getParameter("uname");
           String pass = request.getParameter("upass");


           //for check purpose
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "select userName from users where userName = ? and userPass = ?");
           preparedStatement.setString(1, name);
           preparedStatement.setString(2, pass);

           ResultSet resultSet = preparedStatement.executeQuery();


           if (resultSet.next())
           {
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
               requestDispatcher.forward(request,response);
           }

           else {

               outPW.println("<html><body><p> Login failed</p></body></html");
           }
       }

       catch (ClassNotFoundException e) {e.printStackTrace();}
       catch (SQLException e){ e.printStackTrace(); }
    }
}
