package bases;

public class Customer {
    private String name;
    private String email;
    private String address;
    private double balance;
    public Customer(String name, String email, String address, double balance) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    public double getBalance() {
        return balance;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
