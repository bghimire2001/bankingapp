package bankingapp.model;

import java.math.BigDecimal;

public enum AccountType {
    USHYSA(new BigDecimal(3), new BigDecimal(0), "Dollars"), 
    USSAVINGS(new BigDecimal(0.2), new BigDecimal(0), "Dollars"), 
    USMONEYMARKET(new BigDecimal(5), new BigDecimal(0), "Dollars"), 
    USSTANDARDCHECKING(new BigDecimal(0), new BigDecimal(500), "Dollars"), 
    USSTUDENTCHECKING(new BigDecimal(5), new BigDecimal(100), "Dollars");

    private final BigDecimal interestrate;
    private final BigDecimal overdraftlimit;
    private final String accountcurrency;

    AccountType(BigDecimal apr, BigDecimal ovrdrftlimit, String acccurrency){
        this.interestrate = apr;
        this.overdraftlimit = ovrdrftlimit;
        this.accountcurrency = acccurrency;
    }

    public BigDecimal getApr() { return this.interestrate; }
    public BigDecimal getOverdraftLimit() { return this.overdraftlimit; }
    public String getAccountCurrency() { return this.accountcurrency; }


}
