package model;
import java.time.LocalDate;

import bases.Book;
public class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, String author, LocalDate publishDate, double price, String fileType) {
        super(ISBN, title, author, publishDate, price);
        this.fileType = fileType;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    @Override
    public boolean isShippable() { return false; }

    @Override
    public boolean isPurchasable() { return true; }

    @Override
    public boolean isDeliverable() { return false; }
}
