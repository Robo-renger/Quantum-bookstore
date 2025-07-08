import model.*;
import services.*;

import java.time.LocalDate;

import bases.*;
public class App {
    public static void main(String[] args) throws Exception {
        // Create inventory and bookstore service
        Inventory inventory = Inventory.getInstance();
        BookstoreService service = new BookstoreService();

        // Create books
        PaperBook paperBook = new PaperBook("ISBN1","Quantum Physics", "Alice", LocalDate.of(2019, 1, 1),29.99, 5);
        EBook eBook = new EBook("ISBN2","Quantum Computing", "Bob", LocalDate.of(2001, 12, 16),200,"pdf");
        DemoBook demoBook = new DemoBook("ISBN3","Quantum Demo", "Carol", LocalDate.of(1989, 11, 10));

        // Add books to inventory
        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(demoBook);

        // Start a background thread to remove outdated books
        System.out.println("\nStarting background thread to remove outdated books...");
        Thread cleanerThread = new Thread(() -> {
            System.out.println("\n[Cleaner] Removing outdated books...");
            inventory.removeOutdatedBooks();
        });
        cleanerThread.start();

        // Create customer
        Customer customer = new Customer("John Doe", "123 Main St", "john.doe@example.com", 100.0);

        // Try purchasing PaperBook
        System.out.println("Purchasing PaperBook:");
        try{
            service.purchaseBook(customer, paperBook);
            System.out.println("Customer balance: " + customer.getBalance());
            System.out.println("PaperBook stock: " + paperBook.getStock());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try purchasing EBook
        System.out.println("\nPurchasing EBook:");
        try {
            service.purchaseBook(customer, eBook);
            System.out.println("Customer balance: " + customer.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try purchasing DemoBook
        System.out.println("\nPurchasing DemoBook:");
        try {
            service.purchaseBook(customer, demoBook);
            System.out.println("Customer balance: " + customer.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try purchasing PaperBook with no stock
        try {
            paperBook.setStock(0);
            System.out.println("\nPurchasing PaperBook with no stock:");
            service.purchaseBook(customer, paperBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}