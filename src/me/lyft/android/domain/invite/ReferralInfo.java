package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;

public class ReferralInfo
  implements INullable
{
  private final DriverReferral driverReferral;
  
  public ReferralInfo(DriverReferral paramDriverReferral)
  {
    driverReferral = paramDriverReferral;
  }
  
  public static ReferralInfo empty()
  {
    return NullReferral.getInstance();
  }
  
  public DriverReferral getDriverReferral()
  {
    return driverReferral;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullReferral
    extends ReferralInfo
  {
    private static ReferralInfo INSTANCE = new NullReferral();
    
    private NullReferral()
    {
      super();
    }
    
    public static ReferralInfo getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.ReferralInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */