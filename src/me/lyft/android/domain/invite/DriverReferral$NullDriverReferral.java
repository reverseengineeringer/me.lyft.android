package me.lyft.android.domain.invite;

import me.lyft.android.domain.payment.NullMoney;

class DriverReferral$NullDriverReferral
  extends DriverReferral
{
  private static DriverReferral INSTANCE = new NullDriverReferral();
  
  private DriverReferral$NullDriverReferral()
  {
    super(NullMoney.getInstance(), NullMoney.getInstance(), 0, 0, "");
  }
  
  public static DriverReferral getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.DriverReferral.NullDriverReferral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */