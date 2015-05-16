package com.homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei on 30.04.2015.
 */
public class Base {

    private final String GET_ALL_POSTS = "SELECT*FROM postswork";
    private final String DELETE = "DELETE FROM postswork WHERE id=?";
    private final String ADD_NEW_POST = "INSERT INTO postswork(username,login,post) VALUES(?,?,?)";
    private final String DELETE_ALL = "TRUNCATE TABLE postwork";

    String host = "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&characterEncoding=utf8";
    String name = "root";
    String password = "123456";

    public Base() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Book> getBook() throws SQLException {
        List<Book> listBook = new ArrayList<Book>();
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(host, name, password);
             Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(GET_ALL_POSTS);
            while (resultSet.next()) {
                listBook.add(new Book(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("login"),
                        resultSet.getString("post")));
            }
            resultSet.close();

        }
        return listBook;
    }


    public void addPost(Book book) throws SQLException {
        try (Connection connection = DriverManager.getConnection(host, name, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_POST)) {
            preparedStatement.setString(1, "Сергей");
            preparedStatement.setString(2, "saega");
            preparedStatement.setString(3, book.getPost());

            preparedStatement.execute();
        }


    }

    public void deleteAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(host, name, password);
             Statement statement = connection.createStatement();) {
            statement.execute(DELETE_ALL);
        }

    }

    public void delete(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(host, name, password);
             PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1,id);
            statement.executeUpdate();

            }
        }
    }

