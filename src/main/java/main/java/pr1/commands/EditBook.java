package main.java.pr1.commands;

import java.util.Scanner;

import main.java.pr1.Book;
import main.java.pr1.BookManager;

public class EditBook implements Command {

    BookManager bookManager;
    Scanner scanner;
    private String description = "edit book";

    public EditBook(BookManager bookManager, Scanner scanner) {
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

        Book book = bookManager.getBookById(id);
        bookManager.delete(book);
        boolean isAdded = bookManager.add(new Book(id, name, price));

        if (isAdded) {
            System.out.println("Updated successfully.");
        } else System.out.println("Updated failed");
        
    }
    
}
