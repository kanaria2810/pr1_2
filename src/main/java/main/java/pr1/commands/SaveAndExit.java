package main.java.pr1.commands;

import java.util.Scanner;

import main.java.pr1.BookManager;

public class SaveAndExit implements Command {
    
    BookManager bookManager;
    String description = "save & exit";
    Scanner scanner;

    public SaveAndExit(BookManager bookManager, Scanner scanner) {
        this.bookManager = bookManager;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void excecute() {
        bookManager.saveToFile();
        System.out.println("Bye!");
        scanner.close();
    }
    
}
