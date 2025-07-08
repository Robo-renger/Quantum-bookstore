
package services;

import bases.Book;
import bases.Customer;
import model.PaperBook;
public class BookstoreService {

    public boolean purchaseBook(Customer customer, Book book) {
        if (!book.isPurchasable()) {
            if (book instanceof PaperBook){
                PaperBook paperBook = (PaperBook) book;
                if (paperBook.getStock() <= 0) {
                    throw new IllegalArgumentException("PaperBook is out of stock: " + book.getTitle());
                }
            }
            throw new IllegalArgumentException("Book is not purchasable: " + book.getTitle());
        }
        if (customer.getBalance() < book.getPrice()) {
            throw new IllegalArgumentException("Insufficient balance to purchase the book: " + book.getTitle());
        }
        customer.setBalance(customer.getBalance() - book.getPrice());
        System.out.println("Remaining balance: " + customer.getBalance());
        Inventory.getInstance().decreaseStock(book, 1);
        if (book.isShippable()) {
            shipBook(customer, book);
        } else {
            deliverEBook(customer, book);
        }
        System.out.println("Book purchased successfully: " + book.getTitle());

        return true;
    }

    private void shipBook(Customer customer, Book book) {
        ShippingService shippingService = new ShippingService(book);
        double shippingCost = shippingService.calculateShippingCost();
        System.out.println("Shipping book to " + customer.getAddress() + " with cost: " + shippingCost);
    }

    private void deliverEBook(Customer customer, Book book) {
        MailService mailService = new MailService();
        mailService.sendBook(customer, book);
        System.out.println("Sending eBook to " + customer.getEmail());
    }


}

