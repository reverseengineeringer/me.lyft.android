package me.lyft.android.application.payment;

import me.lyft.android.common.IHasReason;

public class PaymentException
  extends Exception
  implements IHasReason
{
  private String reason;
  
  public PaymentException(String paramString1, Throwable paramThrowable, String paramString2)
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
 * Qualified Name:     me.lyft.android.application.payment.PaymentException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */