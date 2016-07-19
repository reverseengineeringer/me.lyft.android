package bo.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class fe
{
  private static final BigDecimal a = new BigDecimal("100");
  
  public static BigDecimal a(int paramInt)
  {
    return new BigDecimal(paramInt).divide(a);
  }
  
  public static BigDecimal a(BigDecimal paramBigDecimal)
  {
    return paramBigDecimal.setScale(2, RoundingMode.HALF_UP);
  }
}

/* Location:
 * Qualified Name:     bo.app.fe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */