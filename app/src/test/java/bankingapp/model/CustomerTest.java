package bankingapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import bankingapp.model.*;



public class CustomerTest {
    @Test void createCustomer() {
        Customer customer = new Customer.Builder("Bipin", "Bipin", "bipin@bipin.com").build();
        

    }
    
}
