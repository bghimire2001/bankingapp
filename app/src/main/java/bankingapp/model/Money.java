package bankingapp.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money implements Comparable<Money> {
    private final BigDecimal amnt;
    private final String crncy;

    public Money(BigDecimal amount, String currency){
        if(amount.compareTo(new BigDecimal(0)) < 0){
            throw new IllegalArgumentException("Invalid Argument - Value must be positive");
        }
        amnt = amount;
        crncy = currency;
    }

    public Money add(Money other){
        return new Money(amnt.add(other.amnt), crncy);
    }
    public Money subtract(Money other){
        return new Money(amnt.subtract(other.amnt), crncy);
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        } 
        if (!(o instanceof Money other)){
            return false;
        } 
        return (amnt.equals(other.amnt) && crncy.equals(other.crncy));
    }
    @Override
    public String toString(){
        return amnt.toString() + " " + crncy;
    }
    @Override
    public int compareTo(Money other){
        return amnt.compareTo(other.amnt);
    }
    @Override
    public int hashCode(){
        return Objects.hash(amnt.stripTrailingZeros(), crncy);
    }
}
