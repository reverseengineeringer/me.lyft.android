package me.lyft.android.infrastructure.facebook;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.jakewharton.rxrelay.PublishRelay;

class FacebookLoginService$1
  implements FacebookCallback<LoginResult>
{
  FacebookLoginService$1(FacebookLoginService paramFacebookLoginService) {}
  
  public void onCancel()
  {
    FacebookLoginService.access$000(this$0).call(new FacebookLoginResult(null, null));
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    FacebookLoginService.access$000(this$0).call(new FacebookLoginResult(null, paramFacebookException));
  }
  
  public void onSuccess(LoginResult paramLoginResult)
  {
    FacebookLoginService.access$000(this$0).call(new FacebookLoginResult(paramLoginResult.getAccessToken().getToken(), null));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */