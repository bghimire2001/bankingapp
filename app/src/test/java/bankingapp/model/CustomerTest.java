package bankingapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import bankingapp.model.*;



public class CustomerTest {
    @Test void createCustomer() {
        Customer customer = new Customer.Builder("Bipin", "Bipin", "bipin@bipin.com").build();
        assertEquals("Bipin", customer.getFirstName());
        assertEquals("Bipin", customer.getLastName());
        assertEquals("bipin@bipin.com", customer.getEmail());
    }
    @Test void createAccountHoldingCustomer(){
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(overdraftlimit, initialdeposit, "dollars");
        Customer customer = new Customer.Builder("Bipin", "Bipin", "bipin@bipin.com").addAccount(c).build();
        assertEquals("Bipin", customer.getFirstName());
        assertEquals("Bipin", customer.getLastName());
        assertEquals("bipin@bipin.com", customer.getEmail());
        assertEquals(customer.getAccounts().get(0), c);
    }
    @Test void createMultipleAccountHoldingCustomer(){
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(overdraftlimit, initialdeposit, "dollars");

        Money initialsavingsdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(initialsavingsdeposit, "dollars", new BigDecimal(2.0));
        Customer customer = new Customer.Builder("Bipin", "Bipin", "bipin@bipin.com").addAccount(c).addAccount(s).build();
        assertEquals("Bipin", customer.getFirstName());
        assertEquals("Bipin", customer.getLastName());
        assertEquals("bipin@bipin.com", customer.getEmail());
        assertEquals(customer.getAccounts().get(0), c);
        assertEquals(customer.getAccounts().get(1), s);
    }

    
    
}
