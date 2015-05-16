package com.homework;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by sergei on 30.04.2015.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        char ch = ' ';
        Scanner scanner = new Scanner(System.in);
        System.out.println("команда 1 - вывод всех постов q- выход");
        System.out.println("команда 2 - добавить запись ");
        System.out.println("команда 3 - удаление всех записей ");
        do {
           Base base = new Base();
            ch = scanner.next().charAt(0);
            switch (ch) {
                case '1':
                    System.out.println(base.getBook());
                    break;
                case '2':
                    scanner = new Scanner(System.in);
                    System.out.println("Введите имя:");
                    String name = "";
                    name = scanner.nextLine();
                    System.out.println("Введите логин");
                    String login = scanner.nextLine();
                    System.out.println("Введите пост");
                    String post = scanner.nextLine();
                    Book book = new Book(name, login, post);
                    base.addPost(book);
                    break;
                case '3':
                    System.out.println("Все записи удалены");
                    base.deleteAll();
                    break;


            }

        } while (ch != 'q');
    }
}
