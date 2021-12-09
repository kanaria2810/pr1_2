package main.java.pr1.commands;

import java.util.Scanner;

import main.java.pr1.Book;
import main.java.pr1.BookManager;

public class AddNewBook implements Command {

    BookManager bookManager;
    Scanner scanner;
    private String description = "add a new book";

    public AddNewBook(BookManager bookManager, Scanner scanner) {
        this.bookManager = bookManager;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void excecute() {

        System.out.print("Enter book id: ");
        int id = scanner.nextInt(); 
        scanner.nextLine();

        System.out.print("Enter book name: ");
        String name = scanner.next();
        scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();

        boolean isAdded = bookManager.add(new Book(id, name, price));

        if (isAdded) {
            System.out.println("Added successfully.");
        } else System.out.println("Added failed");

        
    }
    
}
