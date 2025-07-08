package services;
import bases.Book;
import bases.Customer;

import model.EBook;
public class MailService {
    private void sendEmail(String to, String subject, String body) {
        // Implementation for sending email
    }

    public void sendBook(Customer customer, Book book) {
        if(customer == null || book == null) {
            throw new IllegalArgumentException("Customer and book cannot be null");
        }
        if (!(book instanceof EBook)) {
            throw new IllegalArgumentException("Book must be an instance of EBook");
        }
        EBook eBook = (EBook) book;
        String to = customer.getEmail();
        String subject = "Your E-Book Purchase: " + eBook.getTitle();
        String body = "Dear " + customer.getName() + ",\n\nThank you for your purchase!\n\n" +
                      "You can download your e-book using the link below:\n" +
                      "["+eBook.getFileType()+"]\n\nBest regards,\nQuantum Bookstore";
        sendEmail(to, subject, body);
    }
}
