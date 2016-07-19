package com.facebook.login.widget;

import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import java.util.Collections;
import java.util.List;

class LoginButton$LoginButtonProperties
{
  private LoginAuthorizationType authorizationType = null;
  private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
  private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
  private List<String> permissions = Collections.emptyList();
  
  public void clearPermissions()
  {
    permissions = null;
    authorizationType = null;
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return defaultAudience;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return loginBehavior;
  }
  
  List<String> getPermissions()
  {
    return permissions;
  }
  
  public void setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    defaultAudience = paramDefaultAudience;
  }
  
  public void setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    loginBehavior = paramLoginBehavior;
  }
  
  public void setPublishPermissions(List<String> paramList)
  {
    if (LoginAuthorizationType.READ.equals(authorizationType)) {
      throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
    }
    if (Utility.isNullOrEmpty(paramList)) {
      throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
    }
    permissions = paramList;
    authorizationType = LoginAuthorizationType.PUBLISH;
  }
  
  public void setReadPermissions(List<String> paramList)
  {
    if (LoginAuthorizationType.PUBLISH.equals(authorizationType)) {
      throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
    }
    permissions = paramList;
    authorizationType = LoginAuthorizationType.READ;
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.LoginButton.LoginButtonProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */