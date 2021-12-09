package main.java.pr1;

import java.io.*;
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
    public void loadFromFile() {
        System.out.println("Loading books...");
		try {

			BufferedReader br = new BufferedReader(new FileReader("books.txt"));

			String line = br.readLine();

			while (line != null) {

                int id = Integer.parseInt(line.substring(0, 5).trim());
                String name = line.substring(5, 50).trim();
                double price = Double.parseDouble(line.substring(50, 62).trim());

                Book book = new Book(id, name, price);
                add(book);

                line = br.readLine();
            }

			br.close();

		} catch (IOException e) {
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
            System.out.printf( "%-5s %-45s %-10s", "ID", "Name", "Price");
            System.out.println("\n");
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
                return;
            }
        }
        System.out.println("Invalid ID!");
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {

        if (this.books.size() < 2) {
            return;
        }

        ArrayList<Book> sortedBooks = new ArrayList<>();

        this.books.forEach( book -> {

            double actualBookPrice = book.price;

            if (sortedBooks.size() == 0) {
                sortedBooks.add(book);
                return;
            }

            if (actualBookPrice >= sortedBooks.get(0).price) {
                sortedBooks.add(0, book);
                return;
            }

            if (actualBookPrice < sortedBooks.get(sortedBooks.size()-1).price) {
                sortedBooks.add(book);
                return;
            }

            for (int i = 0; i < sortedBooks.size() - 1 ; i++) {

                double priceBookBefore = sortedBooks.get(i).price;
                double priceBookAfter = sortedBooks.get(i+1).price;

                if (priceBookBefore > actualBookPrice && actualBookPrice >= priceBookAfter ) {
                    sortedBooks.add(i+1, book);
                    return;
                }
            }

        });

        this.books = sortedBooks;
    }

    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        ArrayList<Book> matches = new ArrayList<>();

        this.books.forEach(book -> { 
            if (book.name.toLowerCase().contains(keyword.toLowerCase())) matches.add(book);
        });

        return matches;
    }

    /**
     * write this.books to file books.txt in required format
     */
    public void saveToFile() {
        try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"));

            StringBuilder bookStringBuilder = new StringBuilder();
            this.books.forEach( book -> {
                bookStringBuilder.append(book.toString());
                bookStringBuilder.append("\n");
            });

            bw.write(bookStringBuilder.toString());

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\nAn error occured. Check your filename and your permissions.");
		}

    }
}
