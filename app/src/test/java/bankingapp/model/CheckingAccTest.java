package bankingapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class CheckingAccTest {
    @Test void createCheckingAccount() {
        Money initialdeposit = new Money(new BigDecimal(100), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        assertEquals(initialdeposit, c.balance);
    }
    @Test void checkingAccountWithdraw() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(50), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        assertEquals(new Money(new BigDecimal(150), "dollars"), c.balance);
    }
    @Test void checkingAccountMultipleWithdraw() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(50), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        assertTrue(c.withdraw(withdrawalamnt));
        assertTrue(c.withdraw(withdrawalamnt));
        assertTrue(c.withdraw(withdrawalamnt));
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
    }
    @Test void checkingAccountFailedWithdraw() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(500), "dollars");
        assertFalse(c.withdraw(withdrawalamnt));
        assertEquals(new Money(new BigDecimal(200), "dollars"), c.balance);
    }
    @Test void checkingAccountOverdraftWithdraw() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(250), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
    }
    @Test void checkingAccountTwoOverdraftWithdraw() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(250), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        Money overdraftwithdrawalamnt = new Money(new BigDecimal(25), "dollars");
        assertTrue(c.withdraw(overdraftwithdrawalamnt));
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
    }
    @Test void checkingAccountTwoOverdraftWithdrawFail() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(250), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        Money overdraftwithdrawalamnt = new Money(new BigDecimal(100), "dollars");
        assertFalse(c.withdraw(overdraftwithdrawalamnt));
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
    }
    @Test void checkingAccountDeposit() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money depositamnt = new Money(new BigDecimal(50), "dollars");
        c.deposit(depositamnt);
        assertEquals(new Money(new BigDecimal(250), "dollars"), c.balance);
    }
    @Test void checkingAccountOverdraftDeposit() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(300), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        Money depositamnt = new Money(new BigDecimal(50), "dollars");
        c.deposit(depositamnt);
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
    }
    @Test void checkingAccountOverdraftCoveredDeposit() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(300), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        Money depositamnt = new Money(new BigDecimal(101), "dollars");
        c.deposit(depositamnt);
        assertEquals(new Money(new BigDecimal(1), "dollars"), c.balance);
    }
    @Test void checkingAccountOverdraftCoveredMultipleDeposit() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money withdrawalamnt = new Money(new BigDecimal(300), "dollars");
        assertTrue(c.withdraw(withdrawalamnt));
        Money depositamnt = new Money(new BigDecimal(30), "dollars");
        c.deposit(depositamnt);
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
        Money depositamnt2 = new Money(new BigDecimal(50), "dollars");
        c.deposit(depositamnt2);
        assertEquals(new Money(new BigDecimal(0), "dollars"), c.balance);
        Money depositamnt3 = new Money(new BigDecimal(21), "dollars");
        c.deposit(depositamnt3);
        assertEquals(new Money(new BigDecimal(1), "dollars"), c.balance);
    }
    @Test void checkingAccountDepositMemo() {
        Money initialdeposit = new Money(new BigDecimal(200), "dollars");
        Money overdraftlimit = new Money(new BigDecimal(100), "dollars");
        CheckingAccount c = new CheckingAccount(
            overdraftlimit, initialdeposit, "dollars");
        
        Money depositamnt = new Money(new BigDecimal(50), "dollars");
        c.deposit(depositamnt, "HELLO THERE I JUST PUT MONEY");
        assertEquals(new Money(new BigDecimal(250), "dollars"), c.balance);
    }
}
