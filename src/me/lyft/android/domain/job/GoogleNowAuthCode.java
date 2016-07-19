package me.lyft.android.domain.job;

import me.lyft.android.common.INullable;

public class GoogleNowAuthCode
  implements INullable
{
  private final String authCode;
  private final Long expirationTimestamp;
  
  public GoogleNowAuthCode(String paramString, Long paramLong)
  {
    authCode = paramString;
    expirationTimestamp = paramLong;
  }
  
  public static GoogleNowAuthCode empty()
  {
    return NullGoogleNowAuthCode.INSTANCE;
  }
  
  public String getAuthCode()
  {
    return authCode;
  }
  
  public Long getExpirationTimestamp()
  {
    return expirationTimestamp;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullGoogleNowAuthCode
    extends GoogleNowAuthCode
  {
    private static final GoogleNowAuthCode INSTANCE = new NullGoogleNowAuthCode();
    
    public NullGoogleNowAuthCode()
    {
      super(null);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.job.GoogleNowAuthCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */