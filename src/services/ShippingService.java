package services;
import bases.Book;


public class ShippingService {
    private Book book;
    private static final double BASE_SHIPPING_COST = 10.0; // Base cost for shipping


    public ShippingService(Book book) {
        this.book = book;
    }

    public double calculateShippingCost() {
        if (book == null || !book.isShippable()) {
            return 0.0; // No shipping cost for non-shippable books
        }
        return BASE_SHIPPING_COST;
    }
}
