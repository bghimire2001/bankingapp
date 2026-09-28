package bankingapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccTest {
    @Test void createSavingsAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(
            initialdeposit, "dollars", new BigDecimal(2.0));
        
        assertEquals(s.toString(), "100 dollars");
    }
    @Test void depositSavingsAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(
            initialdeposit, "dollars", new BigDecimal(2.0));
        
        Money savingsdeposit = new Money(new BigDecimal(100), "dollars");
        s.deposit(savingsdeposit);
        assertEquals(s.toString(), "200 dollars");
    }
    @Test void validWithdrawSavingsAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(
            initialdeposit, "dollars", new BigDecimal(2.0));
        
        Money savingsdeposit = new Money(new BigDecimal(100), "dollars");
        s.deposit(savingsdeposit);
        assertEquals(s.toString(), "200 dollars");
        
        Money savingswithdrawal = new Money(new BigDecimal(100), "dollars");
        assertTrue(s.withdraw(savingswithdrawal));
    }
    @Test void invalidWithdrawSavingsAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(
            initialdeposit, "dollars", new BigDecimal(2.0));
        
        Money savingsdeposit = new Money(new BigDecimal(100), "dollars");
        s.deposit(savingsdeposit);
        assertEquals(s.toString(), "200 dollars");
        
        Money savingswithdrawal = new Money(new BigDecimal(1000), "dollars");
        assertFalse(s.withdraw(savingswithdrawal));
    }
    @Test void calculateMontlyInterestSavingsAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        SavingsAccount s = new SavingsAccount(
            initialdeposit, "dollars", new BigDecimal(2.0));
        
        BigDecimal monthlyinterestcalc = new BigDecimal(2.0).divide(new BigDecimal(1200.0), 10, RoundingMode.HALF_UP);
        Money expectedinterest = new Money(new BigDecimal(100.0).multiply(monthlyinterestcalc), "dollars");
        
        assertEquals(expectedinterest, s.calculateMonthlyInterest());
        Money savingsdeposit = new Money(new BigDecimal(100), "dollars");
        s.deposit(savingsdeposit);
        expectedinterest = new Money(new BigDecimal(200.0).multiply(monthlyinterestcalc), "dollars");
        assertEquals(expectedinterest, s.calculateMonthlyInterest());
        assertEquals(s.toString(), "200 dollars");
        
    }
}
