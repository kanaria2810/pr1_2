package main.java.pr1.commands;

import java.util.Scanner;

import main.java.pr1.Book;
import main.java.pr1.BookManager;

public class DeleteBook implements Command {
    
    BookManager bookManager;
    Scanner scanner;
    private String description = "delete a book";

    public DeleteBook(BookManager bookManager, Scanner scanner) {
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

        Book book = bookManager.getBookById(id);
        bookManager.delete(book);   
        System.out.println("Deleted successfully!");
        
    }
    
}
