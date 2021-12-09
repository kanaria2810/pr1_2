package main.java.pr1.commands;

import main.java.pr1.BookManager;

public class SortBookByPriceDesc implements Command {
    
    BookManager bookManager;
    String description = "sort books descending by price";

    public SortBookByPriceDesc(BookManager bookManager) {
        this.bookManager = bookManager;
    }
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void excecute() {
        
        bookManager.sortDescByPrice();
        System.out.println("After sorting: ");
        bookManager.printBooks(bookManager.getBooks());        
    }
    
}
