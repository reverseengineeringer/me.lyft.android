package me.lyft.android.infrastructure.facebook;

import me.lyft.android.common.Strings;

public class FacebookLoginResult
{
  public final String accessToken;
  public final Throwable error;
  
  public FacebookLoginResult(String paramString, Throwable paramThrowable)
  {
    accessToken = paramString;
    error = paramThrowable;
  }
  
  public boolean isSuccess()
  {
    return !Strings.isNullOrEmpty(accessToken);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */