package bases;

import java.time.LocalDate;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String author;
    protected double price;
    protected LocalDate publishDate;

    public Book(String ISBN, String title, String author, LocalDate publishDate ,double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    public abstract boolean isShippable();
    public abstract boolean isPurchasable();
    public abstract boolean isDeliverable();
}