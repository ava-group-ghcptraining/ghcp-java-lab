package api.albums.models;
import java.util.Date;

public class Payment {
    private int id;
    private String paymentMethod;
    private double amount;
    private Date paymentDate;
    public Payment() {
        // Default constructor
    }
    public Payment(int id, String paymentMethod, double amount) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = new Date();
    }

    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = new Date();
    }
    public Payment(int id, String paymentMethod, double amount, Date paymentDate) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
