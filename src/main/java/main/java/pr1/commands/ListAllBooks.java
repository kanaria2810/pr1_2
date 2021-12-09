package main.java.pr1.commands;

import main.java.pr1.BookManager;

public class ListAllBooks implements Command {

    BookManager bookManager;
    private String description = "list all books";

    public ListAllBooks(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void excecute() {
        bookManager.printBooks(bookManager.getBooks());
    }
    
}
