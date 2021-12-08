package main.java.pr1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class BookManager {
    /**
     *
     */
    // attribute books
    private ArrayList<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /**
     * update this.books by reading books from file books.txt
     */
    public void loadFromFile() throws IOException {
        System.out.println("Loading books...");
		try {

			BufferedReader br = new BufferedReader(new FileReader("books.txt"));

			String line = br.readLine();

			while (line != null) {

                int id = Integer.parseInt(line.substring(0, 5).trim());
                String name = line.substring(5, 50).trim();
                Double price = Double.parseDouble(line.substring(50, 60).trim());

                Book book = new Book(id, name, price);
                add(book);

                line = br.readLine();
            }

            printBooks(this.books);

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("\nAn error occured. Check your filename and your permissions.");
		}

    }

    /**
     * print books (one/line) in required format
     */
    public void printBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("(empty)");
        } else {
            books.forEach(book -> {
                System.out.println(book.toString());
            });
        }
    }

    /**
     * if book.id is not duplicated, add book to this.books
     * return whether added or not
     */
    public boolean add(Book book) {
        for (Book b : books) {
            if (b.id == book.id) {
                return false;
            }
        }
        return this.books.add(book);
    }

    /**
     * return book specified by id, null if not found
     */
    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    /**
     * delete book from this.books
     */
    public void delete(Book book) {
        for (Book b : this.books) {
            if (b.equals(book)) {
                this.books.remove(b);
            }
        }
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {
        // TODO: your code here
    }

    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        ArrayList<Book> matches = new ArrayList<>();

        // TODO: your code here

        return matches;
    }

    /**
     * write this.books to file books.txt in required format
     */
    public void saveToFile() {
        // TODO: your code here
    }
}
