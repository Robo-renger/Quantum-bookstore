package model;
import java.time.LocalDate;

import bases.Book;
public class DemoBook extends Book {
    public DemoBook(String ISBN ,String title, String author, LocalDate publishDate) {
        super(ISBN, title, author, publishDate, 0.0);
    }

    @Override
    public boolean isShippable() { return false; }

    @Override
    public boolean isPurchasable() { return false; }

    @Override
    public boolean isDeliverable() { return false; }
}

