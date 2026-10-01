package bankingapp.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bankingapp.interest.*;

public class SavingsAccount extends Account implements InterestBearing{
    public BigDecimal apr;
    public SavingsAccount(Money initialBalance, String currency, BigDecimal interestrate){
        balance = initialBalance;
        accountCurrency = currency;
        apr = interestrate;
    }
    public Boolean withdraw(Money withdrawAmount){
        if(withdrawAmount.compareTo(balance) > 0){
            return false;
        }
        balance = balance.subtract(withdrawAmount); 
        return true;
    }
    public void deposit(Money depositAmount){
        balance = balance.add(depositAmount);
    }
    public BigDecimal getAnnualRate(){
        return apr;
    }
    public Money calculateMonthlyInterest(){
        BigDecimal monthlyapr = apr.divide(new BigDecimal(1200.0), 10, RoundingMode.HALF_UP);
        return balance.multiply(monthlyapr);
    }
    @Override 
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("===Savings Account===\n");
        s.append("----------------------\n");
        s.append("Savings Balance: " + balance + "\n");
        s.append("APR: " + apr + "%\n");
        return s.toString();

    }
}
