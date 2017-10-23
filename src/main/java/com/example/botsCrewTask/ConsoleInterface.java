package com.example.botsCrewTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInterface {
    @Autowired
    private BookService bookService;

    public void start() {
        help();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command ");
            String command = scanner.next();
            switch (command) {
                case "books":{
                    bookService.getAllBooks().stream().sorted().forEach(System.out::println);
                    break;
                }
                case "help": {
                    help();
                    break;
                }
                case "add": {
                    addBook(scanner);
                    break;
                }
                case "update":{
                    updateBook(scanner);
                    break;
                }
                case "delete":{
                    deleteBook(scanner);
                    break;
                }
                case "get":{
                    getBook(scanner);
                    break;
                }
                case "exit":{
                    System.out.println("Bye!");
                    return;
                }
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    private void getBook(Scanner scanner) {
        System.out.println("Enter name of book");
        String name = scanner.next();
        Book book = bookService.getBook(name);
        System.out.println("Name of book:\t" + book.getName());
        System.out.println("Author of book:\t" + book.getAuthor());
    }

    private void deleteBook(Scanner scanner) {
        System.out.println("Enter name of book");
        String name = scanner.next();
        bookService.deleteBook(name);
    }

    private void updateBook(Scanner scanner) {
        System.out.println("Enter name of book");
        String name = scanner.next();
        System.out.println("Enter author");
        String author = scanner.next();
        bookService.updateBook(new Book(name, author));
    }

    private void addBook(Scanner scanner) {
        System.out.println("Enter name of book");
        String name = scanner.next();
        System.out.println("Enter author");
        String author = scanner.next();
        bookService.addBook(new Book(name, author));
    }

    private void help() {
        System.out.println("list of commands - help");
        System.out.println("add book - add");
        System.out.println("get book - get");
        System.out.println("delete book - delete");
        System.out.println("update book - update");
        System.out.println("get books - books");
        System.out.println("complete the program - exit");
    }

}

