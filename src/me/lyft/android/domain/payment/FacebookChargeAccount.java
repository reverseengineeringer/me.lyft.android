package me.lyft.android.domain.payment;

import me.lyft.android.common.Objects;

public class FacebookChargeAccount
  extends ChargeAccount
{
  private final String lastFour;
  private final String type;
  
  public FacebookChargeAccount(String paramString1, String paramString2)
  {
    lastFour = ((String)Objects.firstNonNull(paramString1, ""));
    type = ((String)Objects.firstNonNull(paramString2, ""));
  }
  
  public String getLastFour()
  {
    return lastFour;
  }
  
  public String getType()
  {
    return type;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.FacebookChargeAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */