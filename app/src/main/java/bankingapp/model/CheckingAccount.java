package bankingapp.model;

import java.math.BigDecimal;

public class CheckingAccount extends Account{
    private Money overdraftlimit;
    private Money overdraftAmount;

    public CheckingAccount(Money overdraftLimit, Money initialBalance, String currency){
        overdraftlimit = overdraftLimit;
        balance = initialBalance;
        accountCurrency = currency;
        overdraftAmount = new Money(new BigDecimal(0), currency);
    }
    public Boolean withdraw(Money withdrawAmount){
        Money withdrawLimit = balance.add(overdraftlimit.subtract(overdraftAmount));
        if(withdrawAmount.compareTo(withdrawLimit) > 0){
            return false;
        }
        if(withdrawAmount.compareTo(balance) > 0){
            overdraftAmount = overdraftAmount.add(withdrawAmount.subtract(balance));
            balance = new Money(new BigDecimal(0), accountCurrency);
        } else{
            balance = balance.subtract(withdrawAmount); 
        }
        return true;
    }
    public void deposit(Money depositAmount){
        if(depositAmount.compareTo(overdraftAmount) <= 0){
            overdraftAmount = overdraftAmount.subtract(depositAmount);
        } else{
            balance = balance.add(depositAmount.subtract(overdraftAmount));
            overdraftAmount = new Money(new BigDecimal(0), accountCurrency);
        }
    }
    public void deposit(Money depositAmount, String memo){
        if(depositAmount.compareTo(overdraftAmount) <= 0){
            overdraftAmount = overdraftAmount.subtract(depositAmount);
        } else{
            balance = balance.add(depositAmount.subtract(overdraftAmount));
            overdraftAmount = new Money(new BigDecimal(0), accountCurrency);
        }
        System.out.println(memo);
    }
}
