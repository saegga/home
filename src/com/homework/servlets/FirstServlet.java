package com.homework.servlets;

import com.homework.Base;
import com.homework.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sergei on 15.05.2015.
 */
@WebServlet(urlPatterns = "/main")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Base base = new Base();
        request.setCharacterEncoding("utf-8");
        try {
            base.addPost(new Book(request.getParameter("text")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Base base = new Base();
        try {
            request.setAttribute("books",base.getBook());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
