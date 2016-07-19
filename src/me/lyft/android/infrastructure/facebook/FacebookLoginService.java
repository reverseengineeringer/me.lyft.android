package me.lyft.android.infrastructure.facebook;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.jakewharton.rxrelay.PublishRelay;
import java.util.Arrays;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class FacebookLoginService
  implements IFacebookLoginService
{
  private static final String FACEBOOK_EMAIL_PERMISSION = "email";
  private static final String FACEBOOK_USER_FRIENDS_PERMISSION = "user_friends";
  private final IActivityLifecycleService activityLifecycleService;
  private CallbackManager callbackManager;
  private final PublishRelay<FacebookLoginResult> loginResult = PublishRelay.create();
  private final CompositeSubscription subscriptions = new CompositeSubscription();
  
  public FacebookLoginService(IActivityLifecycleService paramIActivityLifecycleService)
  {
    activityLifecycleService = paramIActivityLifecycleService;
  }
  
  private boolean isFacebookSessionOpened()
  {
    return AccessToken.getCurrentAccessToken() != null;
  }
  
  private void onActivityResult(ActivityResult paramActivityResult)
  {
    if (callbackManager.onActivityResult(paramActivityResult.getRequestCode(), paramActivityResult.getResultCode(), paramActivityResult.getIntent())) {
      activityLifecycleService.clearResult();
    }
  }
  
  public Observable<FacebookLoginResult> observeLogin()
  {
    return loginResult.asObservable();
  }
  
  public void openFacebookSession()
  {
    if (isFacebookSessionOpened())
    {
      loginResult.call(new FacebookLoginResult(AccessToken.getCurrentAccessToken().getToken(), null));
      return;
    }
    LoginManager.getInstance().logInWithReadPermissions(activityLifecycleService.getCurrentActivity(), Arrays.asList(new String[] { "email", "user_friends" }));
  }
  
  public void start()
  {
    callbackManager = CallbackManager.Factory.create();
    LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback()
    {
      public void onCancel()
      {
        loginResult.call(new FacebookLoginResult(null, null));
      }
      
      public void onError(FacebookException paramAnonymousFacebookException)
      {
        loginResult.call(new FacebookLoginResult(null, paramAnonymousFacebookException));
      }
      
      public void onSuccess(LoginResult paramAnonymousLoginResult)
      {
        loginResult.call(new FacebookLoginResult(paramAnonymousLoginResult.getAccessToken().getToken(), null));
      }
    });
    subscriptions.add(activityLifecycleService.observeResult().subscribe(new Action1()
    {
      public void call(ActivityResult paramAnonymousActivityResult)
      {
        FacebookLoginService.this.onActivityResult(paramAnonymousActivityResult);
      }
    }));
  }
  
  public void stop()
  {
    subscriptions.clear();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.FacebookLoginService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */