package me.lyft.android.infrastructure.facebook;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class FacebookTokenService
  implements IFacebookTokenService
{
  public String getFacebookToken()
  {
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    if (localAccessToken != null) {
      return localAccessToken.getToken();
    }
    return null;
  }
  
  public void logout()
  {
    LoginManager.getInstance().logOut();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookTokenService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */