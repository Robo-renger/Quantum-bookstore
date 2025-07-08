package services;

import bases.Book;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import model.PaperBook;

public class Inventory {
    private static Inventory instance;
    private List<Book> books;
    private final int OUTDATED_YEARS = 5;

    private Inventory() {
        this.books = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void decreaseStock(Book book, int quantity) {
        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            int currentStock = paperBook.getStock();
            if (currentStock >= quantity) {
                paperBook.setStock(currentStock - quantity);
            } else {
                System.out.println("Not enough stock to decrease.");
            }
        } else {
            System.out.println("This book is not a PaperBook.");
        }
    }
    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeOutdatedBooks() {
        books.removeIf(book -> book.getPublishDate().isBefore(LocalDate.now().minusYears(OUTDATED_YEARS)));
    }

    public Book[] getBooks() {
        return books.toArray(new Book[0]);
    }

    public int getBookCount() {
        return books.size();
    }
}
