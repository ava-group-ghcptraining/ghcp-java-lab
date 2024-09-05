package api.albums.controllers;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.albums.models.Payment;

//create a controller http get api to get all the payments using connection and statement classes and using as reference the class Payment.java  and add all dependencies
@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @GetMapping
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM payments");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String paymentType = resultSet.getString("payment_type");
                double amount = resultSet.getDouble("amount");
                
                Payment payment = new Payment(id, paymentType, amount);
                payments.add(payment);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return payments;
    }
}
