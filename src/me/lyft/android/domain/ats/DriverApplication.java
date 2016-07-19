package me.lyft.android.domain.ats;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class DriverApplication
  implements INullable
{
  public static final String REFERRAL_CODE_FIELD = "referralCode";
  private final String phone;
  private final String referralCode;
  private final String region;
  private final String self;
  private final Integer webOnboardingCompleteness;
  
  public DriverApplication(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger)
  {
    self = paramString1;
    phone = paramString2;
    region = paramString3;
    referralCode = paramString4;
    webOnboardingCompleteness = paramInteger;
  }
  
  public static DriverApplication empty()
  {
    return NullDriverApplication.getInstance();
  }
  
  public String getPhone()
  {
    return phone;
  }
  
  public String getReferralCode()
  {
    return referralCode;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public String getSelf()
  {
    return self;
  }
  
  public Integer getWebOnboardingCompleteness()
  {
    return (Integer)Objects.firstNonNull(webOnboardingCompleteness, Integer.valueOf(0));
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isWebOnboardingComplete()
  {
    return getWebOnboardingCompleteness().intValue() == 100;
  }
  
  public static class NullDriverApplication
    extends DriverApplication
  {
    private static final DriverApplication INSTANCE = new NullDriverApplication();
    
    private NullDriverApplication()
    {
      super(null, null, null, null);
    }
    
    public static DriverApplication getInstance()
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
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */