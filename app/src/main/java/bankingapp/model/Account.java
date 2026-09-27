package bankingapp.model;

public abstract class Account {
    protected Money balance;
    protected String accountCurrency;

    public abstract void deposit(Money depMoney);
    public abstract Boolean withdraw(Money withdrawAmount);

    public String toString(){
        return balance.toString();
    }
}
