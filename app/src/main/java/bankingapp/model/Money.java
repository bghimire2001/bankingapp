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
        if(!(other.crncy.equals(crncy))){
            throw new IllegalArgumentException("Invalid Add - Currencies must be the same");
        }
        return new Money(amnt.add(other.amnt), crncy);
    }
    public Money subtract(Money other){
        if(!(other.crncy.equals(crncy))){
            throw new IllegalArgumentException("Invalid Add - Currencies must be the same");
        }
        return new Money(amnt.subtract(other.amnt), crncy);
    }
    public Money multiply(BigDecimal multiplicand){
        if(multiplicand.compareTo(new BigDecimal(0)) < 0){
            throw new IllegalArgumentException("Invalid Multiply - Both operands must be positive");
        }
        return new Money(amnt.multiply(multiplicand), crncy);
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        } 
        if (!(o instanceof Money other)){
            return false;
        } 
        if(!(other.crncy.equals(crncy))){
            throw new IllegalArgumentException("Invalid Equals - Currencies must be the same");
        }
        return ((amnt.compareTo(other.amnt) == 0) && crncy.equals(other.crncy));
    }
    @Override
    public String toString(){
        return amnt.toString() + " " + crncy;
    }
    @Override
    public int compareTo(Money other){
        if(!(other.crncy.equals(crncy))){
            throw new IllegalArgumentException("Invalid Compare - Currencies must be the same");
        }
        return amnt.compareTo(other.amnt);
    }
    @Override
    public int hashCode(){
        return Objects.hash(amnt.stripTrailingZeros(), crncy);
    }
}
