package me.lyft.android.infrastructure.paypal;

import me.lyft.android.common.IHasReason;

public class PayPalServiceException
  extends Throwable
  implements IHasReason
{
  private String reason;
  
  public PayPalServiceException(Throwable paramThrowable, String paramString)
  {
    super(paramThrowable);
    reason = paramString;
  }
  
  public String getReason()
  {
    return "paypal_" + reason;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */