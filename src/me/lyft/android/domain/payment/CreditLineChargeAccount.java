package me.lyft.android.domain.payment;

import me.lyft.android.common.Objects;

public class CreditLineChargeAccount
  extends ChargeAccount
{
  private Boolean requestNotes;
  
  public Boolean isRequestNotes()
  {
    return (Boolean)Objects.firstNonNull(requestNotes, Boolean.FALSE);
  }
  
  public void setRequestNotes(Boolean paramBoolean)
  {
    requestNotes = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.CreditLineChargeAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */