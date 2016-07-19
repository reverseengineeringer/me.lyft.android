package me.lyft.android.application.driver.expresspay;

import me.lyft.android.common.IHasReason;

public class ExpressPayException
  extends Exception
  implements IHasReason
{
  public static final String ACCOUNT_INCOMPLETE = "account_incomplete";
  public static final String HAS_RENTAL_RESERVATION = "has_rental_reservation";
  public static final String INELIGIBLE = "ineligible";
  public static final String INSUFFICIENT_EARNINGS = "insufficient_earnings";
  private String reason;
  
  public ExpressPayException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    super(paramString1, paramThrowable);
    reason = paramString2;
  }
  
  public String getReason()
  {
    return reason;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */