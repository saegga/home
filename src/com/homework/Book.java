
package com.homework;

/**
 * Created by sergei on 29.04.2015.
 */
public class Book {
    int id;
    String userName;
    String login;
    String post;

    public Book(int id, String userName, String login, String post) {
        this.id = id;
        this.userName = userName;
        this.login = login;
        this.post = post;
    }

    public Book(String userName, String login, String post) {
        this.userName = userName;
        this.login = login;
        this.post = post;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "" +
                "userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", post='" + post + '\'' +
                '\n';
    }

    public Book(String post) {
        this.post = post;
    }
}

