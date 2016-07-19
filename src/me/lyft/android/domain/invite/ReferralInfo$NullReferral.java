package me.lyft.android.domain.invite;

class ReferralInfo$NullReferral
  extends ReferralInfo
{
  private static ReferralInfo INSTANCE = new NullReferral();
  
  private ReferralInfo$NullReferral()
  {
    super(DriverReferral.empty());
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.ReferralInfo.NullReferral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */