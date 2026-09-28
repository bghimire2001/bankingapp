package bankingapp.interest;

import java.math.BigDecimal;
import bankingapp.model.*;

public interface InterestBearing {
    BigDecimal getAnnualRate();
    Money calculateMonthlyInterest();

}
