package org.authentication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/servletlogin")
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
           String emailFromRequest = request.getParameter("email");
           String passwordFromRequest = request.getParameter("password");


           //for check purpose
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "select userName from users where userName = ? and userPass = ?");
           preparedStatement.setString(1, emailFromRequest);
           preparedStatement.setString(2, passwordFromRequest);

           // We can redirect the page to a welcome page
           // Need to pass the values in session in order
           // to carry forward that one to next pages
           // By setting the variable in session, it can be forwarded
           //session refers to a period of interaction between a client and a server.
           //Sessions allow servers to remember information about a user across multiple requests.
           // This is crucial for features like shopping carts, user authentication, and personalized experiences.
           HttpSession httpSession = request.getSession();
           httpSession.getAttribute("User email : " + emailFromRequest);


           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next())
           {

               RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
               requestDispatcher.forward(request,response);
           }

           else {

               httpSession.getAttribute("User email : " + emailFromRequest);
               outPW.println("<html><body><p> Login failed </p></body></html");
           }
       }

       catch (ClassNotFoundException e) {e.printStackTrace();}
       catch (SQLException e){ e.printStackTrace(); }
    }
}
