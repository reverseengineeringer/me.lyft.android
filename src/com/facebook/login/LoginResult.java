package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

public class LoginResult
{
  private final AccessToken accessToken;
  private final Set<String> recentlyDeniedPermissions;
  private final Set<String> recentlyGrantedPermissions;
  
  public LoginResult(AccessToken paramAccessToken, Set<String> paramSet1, Set<String> paramSet2)
  {
    accessToken = paramAccessToken;
    recentlyGrantedPermissions = paramSet1;
    recentlyDeniedPermissions = paramSet2;
  }
  
  public AccessToken getAccessToken()
  {
    return accessToken;
  }
  
  public Set<String> getRecentlyDeniedPermissions()
  {
    return recentlyDeniedPermissions;
  }
  
  public Set<String> getRecentlyGrantedPermissions()
  {
    return recentlyGrantedPermissions;
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */