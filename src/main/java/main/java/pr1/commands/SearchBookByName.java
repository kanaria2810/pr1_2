package main.java.pr1.commands;

import java.util.Scanner;

import main.java.pr1.BookManager;

public class SearchBookByName implements Command {
    BookManager bookManager;
    Scanner scanner;
    private String description = "search books by name";

    public SearchBookByName(BookManager bookManager, Scanner scanner) {
        this.bookManager = bookManager;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void excecute() {

        System.out.print("Enter keyword: ");
        String keyword = scanner.next();
        scanner.nextLine();

        bookManager.printBooks(bookManager.searchByName(keyword));
        scanner.close();        
    }
    
}
