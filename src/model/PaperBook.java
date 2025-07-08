package model;
import bases.Book;
import java.time.LocalDate;


public class PaperBook extends Book {
    private int stock;

    public PaperBook(String ISBN, String title, String author, LocalDate publishDate, double price, int stock) {
        super(ISBN, title, author, publishDate, price);
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public boolean isShippable() { return true; }

    @Override
    public boolean isPurchasable() { return stock > 0; }

    @Override
    public boolean isDeliverable() { return true; }
}

