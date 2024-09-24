package AlbumAPI.Models;
import java.util.Date;

public class Payment {
    private int id;
    private double amount;
    private Date paymentDate;
    public Payment() {
        // Default constructor
    }
    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = new Date();
    }

    public Payment(String paymentMethod, double amount) {
        this.amount = amount;
        this.paymentDate = new Date();
    }
    public Payment(int id, double amount, Date paymentDate) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
