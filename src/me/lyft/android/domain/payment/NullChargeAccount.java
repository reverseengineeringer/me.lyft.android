package me.lyft.android.domain.payment;

public final class NullChargeAccount
  extends ChargeAccount
{
  private static final NullChargeAccount INSTANCE = new NullChargeAccount();
  
  public static NullChargeAccount getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.NullChargeAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */