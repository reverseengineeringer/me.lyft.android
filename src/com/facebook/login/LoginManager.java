package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager
{
  private static final String MANAGE_PERMISSION_PREFIX = "manage";
  private static final Set<String> OTHER_PUBLISH_PERMISSIONS = ;
  private static final String PUBLISH_PERMISSION_PREFIX = "publish";
  private static volatile LoginManager instance;
  private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
  private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
  
  LoginManager()
  {
    Validate.sdkInitialized();
  }
  
  static LoginResult computeLoginResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
  {
    Set localSet = paramRequest.getPermissions();
    HashSet localHashSet = new HashSet(paramAccessToken.getPermissions());
    if (paramRequest.isRerequest()) {
      localHashSet.retainAll(localSet);
    }
    paramRequest = new HashSet(localSet);
    paramRequest.removeAll(localHashSet);
    return new LoginResult(paramAccessToken, localHashSet, paramRequest);
  }
  
  private LoginClient.Request createLoginRequestFromResponse(GraphResponse paramGraphResponse)
  {
    Validate.notNull(paramGraphResponse, "response");
    paramGraphResponse = paramGraphResponse.getRequest().getAccessToken();
    if (paramGraphResponse != null) {}
    for (paramGraphResponse = paramGraphResponse.getPermissions();; paramGraphResponse = null) {
      return createLoginRequest(paramGraphResponse);
    }
  }
  
  private void finishLogin(AccessToken paramAccessToken, LoginClient.Request paramRequest, FacebookException paramFacebookException, boolean paramBoolean, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    if (paramAccessToken != null)
    {
      AccessToken.setCurrentAccessToken(paramAccessToken);
      Profile.fetchProfileForCurrentAccessToken();
    }
    if (paramFacebookCallback != null)
    {
      if (paramAccessToken == null) {
        break label55;
      }
      paramRequest = computeLoginResult(paramRequest, paramAccessToken);
      if ((!paramBoolean) && ((paramRequest == null) || (paramRequest.getRecentlyGrantedPermissions().size() != 0))) {
        break label60;
      }
      paramFacebookCallback.onCancel();
    }
    label55:
    label60:
    do
    {
      return;
      paramRequest = null;
      break;
      if (paramFacebookException != null)
      {
        paramFacebookCallback.onError(paramFacebookException);
        return;
      }
    } while (paramAccessToken == null);
    paramFacebookCallback.onSuccess(paramRequest);
  }
  
  private Intent getFacebookActivityIntent(LoginClient.Request paramRequest)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(paramRequest.getLoginBehavior().toString());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("request", paramRequest);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static LoginManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new LoginManager();
      }
      return instance;
    }
    finally {}
  }
  
  private static Set<String> getOtherPublishPermissions()
  {
    Collections.unmodifiableSet(new HashSet() {});
  }
  
  static boolean isPublishPermission(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith("publish")) || (paramString.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(paramString)));
  }
  
  private void logCompleteLogin(Context paramContext, LoginClient.Result.Code paramCode, Map<String, String> paramMap, Exception paramException, boolean paramBoolean, LoginClient.Request paramRequest)
  {
    LoginLogger localLoginLogger = LoginLoggerHolder.getLogger(paramContext);
    if (localLoginLogger == null) {
      return;
    }
    if (paramRequest == null)
    {
      localLoginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramContext = "1";; paramContext = "0")
    {
      localHashMap.put("try_login_activity", paramContext);
      localLoginLogger.logCompleteLogin(paramRequest.getAuthId(), localHashMap, paramCode, paramMap, paramException);
      return;
    }
  }
  
  private void logInWithPublishPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
  }
  
  private void logInWithReadPermissions(FragmentWrapper paramFragmentWrapper, Collection<String> paramCollection)
  {
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), paramCollection);
  }
  
  private void logStartLogin(Context paramContext, LoginClient.Request paramRequest)
  {
    paramContext = LoginLoggerHolder.getLogger(paramContext);
    if ((paramContext != null) && (paramRequest != null)) {
      paramContext.logStartLogin(paramRequest);
    }
  }
  
  private void resolveError(FragmentWrapper paramFragmentWrapper, GraphResponse paramGraphResponse)
  {
    startLogin(new FragmentStartActivityDelegate(paramFragmentWrapper), createLoginRequestFromResponse(paramGraphResponse));
  }
  
  private boolean resolveIntent(Intent paramIntent)
  {
    return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(paramIntent, 0) != null;
  }
  
  public static void setSuccessResult(Intent paramIntent, Bundle paramBundle)
  {
    LoginClient.Request localRequest = (LoginClient.Request)paramIntent.getExtras().getParcelable("request");
    paramIntent.putExtra("com.facebook.LoginFragment:Result", LoginClient.Result.createTokenResult(localRequest, LoginMethodHandler.createAccessTokenFromWebBundle(localRequest.getPermissions(), paramBundle, AccessTokenSource.CHROME_CUSTOM_TAB, localRequest.getApplicationId())));
  }
  
  private void startLogin(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
    throws FacebookException
  {
    logStartLogin(paramStartActivityDelegate.getActivityContext(), paramRequest);
    CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return LoginManager.this.onActivityResult(paramAnonymousInt, paramAnonymousIntent);
      }
    });
    if (!tryFacebookActivity(paramStartActivityDelegate, paramRequest))
    {
      FacebookException localFacebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
      logCompleteLogin(paramStartActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, localFacebookException, false, paramRequest);
      throw localFacebookException;
    }
  }
  
  private boolean tryFacebookActivity(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    paramRequest = getFacebookActivityIntent(paramRequest);
    if (!resolveIntent(paramRequest)) {
      return false;
    }
    try
    {
      paramStartActivityDelegate.startActivityForResult(paramRequest, LoginClient.getLoginRequestCode());
      return true;
    }
    catch (ActivityNotFoundException paramStartActivityDelegate) {}
    return false;
  }
  
  private void validatePublishPermissions(Collection<String> paramCollection)
  {
    if (paramCollection == null) {}
    String str;
    do
    {
      return;
      while (!paramCollection.hasNext()) {
        paramCollection = paramCollection.iterator();
      }
      str = (String)paramCollection.next();
    } while (isPublishPermission(str));
    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] { str }));
  }
  
  private void validateReadPermissions(Collection<String> paramCollection)
  {
    if (paramCollection == null) {}
    String str;
    do
    {
      return;
      while (!paramCollection.hasNext()) {
        paramCollection = paramCollection.iterator();
      }
      str = (String)paramCollection.next();
    } while (!isPublishPermission(str));
    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] { str }));
  }
  
  protected LoginClient.Request createLoginRequest(Collection<String> paramCollection)
  {
    LoginBehavior localLoginBehavior = loginBehavior;
    if (paramCollection != null)
    {
      paramCollection = new HashSet(paramCollection);
      paramCollection = new LoginClient.Request(localLoginBehavior, Collections.unmodifiableSet(paramCollection), defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
      if (AccessToken.getCurrentAccessToken() == null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      paramCollection.setRerequest(bool);
      return paramCollection;
      paramCollection = new HashSet();
      break;
    }
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return defaultAudience;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return loginBehavior;
  }
  
  public void logInWithPublishPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
  }
  
  public void logInWithPublishPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
  }
  
  public void logInWithPublishPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    logInWithPublishPermissions(new FragmentWrapper(paramFragment), paramCollection);
  }
  
  public void logInWithReadPermissions(Activity paramActivity, Collection<String> paramCollection)
  {
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
  }
  
  public void logInWithReadPermissions(android.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
  }
  
  public void logInWithReadPermissions(android.support.v4.app.Fragment paramFragment, Collection<String> paramCollection)
  {
    logInWithReadPermissions(new FragmentWrapper(paramFragment), paramCollection);
  }
  
  public void logOut()
  {
    AccessToken.setCurrentAccessToken(null);
    Profile.setCurrentProfile(null);
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return onActivityResult(paramInt, paramIntent, null);
  }
  
  boolean onActivityResult(int paramInt, Intent paramIntent, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    Object localObject8 = null;
    Object localObject5 = null;
    Object localObject9 = null;
    Object localObject6 = null;
    Object localObject1 = LoginClient.Result.Code.ERROR;
    LoginClient.Result.Code localCode = null;
    Object localObject7 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    LoginClient.Result localResult;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    if (paramIntent != null)
    {
      localResult = (LoginClient.Result)paramIntent.getParcelableExtra("com.facebook.LoginFragment:Result");
      localObject4 = localCode;
      paramIntent = (Intent)localObject8;
      localObject3 = localObject7;
      localObject2 = localObject9;
      if (localResult != null)
      {
        localObject3 = request;
        localCode = code;
        if (paramInt != -1) {
          break label212;
        }
        if (code != LoginClient.Result.Code.SUCCESS) {
          break label188;
        }
        localObject1 = token;
        bool1 = bool2;
        paramIntent = (Intent)localObject5;
        localObject4 = loggingExtras;
        localObject2 = localObject1;
        localObject1 = localCode;
      }
    }
    for (;;)
    {
      localObject5 = paramIntent;
      if (paramIntent == null)
      {
        localObject5 = paramIntent;
        if (localObject2 == null)
        {
          localObject5 = paramIntent;
          if (!bool1) {
            localObject5 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
          }
        }
      }
      logCompleteLogin(null, (LoginClient.Result.Code)localObject1, (Map)localObject4, (Exception)localObject5, true, (LoginClient.Request)localObject3);
      finishLogin((AccessToken)localObject2, (LoginClient.Request)localObject3, (FacebookException)localObject5, bool1, paramFacebookCallback);
      return true;
      label188:
      paramIntent = new FacebookAuthorizationException(errorMessage);
      localObject1 = localObject6;
      bool1 = bool2;
      break;
      label212:
      paramIntent = (Intent)localObject5;
      localObject1 = localObject6;
      bool1 = bool2;
      if (paramInt != 0) {
        break;
      }
      bool1 = true;
      paramIntent = (Intent)localObject5;
      localObject1 = localObject6;
      break;
      localObject4 = localCode;
      paramIntent = (Intent)localObject8;
      localObject3 = localObject7;
      localObject2 = localObject9;
      if (paramInt == 0)
      {
        bool1 = true;
        localObject1 = LoginClient.Result.Code.CANCEL;
        localObject4 = localCode;
        paramIntent = (Intent)localObject8;
        localObject3 = localObject7;
        localObject2 = localObject9;
      }
    }
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, final FacebookCallback<LoginResult> paramFacebookCallback)
  {
    if (!(paramCallbackManager instanceof CallbackManagerImpl)) {
      throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return onActivityResult(paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
      }
    });
  }
  
  public void resolveError(Activity paramActivity, GraphResponse paramGraphResponse)
  {
    startLogin(new ActivityStartActivityDelegate(paramActivity), createLoginRequestFromResponse(paramGraphResponse));
  }
  
  public void resolveError(android.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
  }
  
  public void resolveError(android.support.v4.app.Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    resolveError(new FragmentWrapper(paramFragment), paramGraphResponse);
  }
  
  public LoginManager setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    defaultAudience = paramDefaultAudience;
    return this;
  }
  
  public LoginManager setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    loginBehavior = paramLoginBehavior;
    return this;
  }
  
  private static class ActivityStartActivityDelegate
    implements StartActivityDelegate
  {
    private final Activity activity;
    
    ActivityStartActivityDelegate(Activity paramActivity)
    {
      Validate.notNull(paramActivity, "activity");
      activity = paramActivity;
    }
    
    public Activity getActivityContext()
    {
      return activity;
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      activity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  private static class FragmentStartActivityDelegate
    implements StartActivityDelegate
  {
    private final FragmentWrapper fragment;
    
    FragmentStartActivityDelegate(FragmentWrapper paramFragmentWrapper)
    {
      Validate.notNull(paramFragmentWrapper, "fragment");
      fragment = paramFragmentWrapper;
    }
    
    public Activity getActivityContext()
    {
      return fragment.getActivity();
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      fragment.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  private static class LoginLoggerHolder
  {
    private static volatile LoginLogger logger;
    
    private static LoginLogger getLogger(Context paramContext)
    {
      if (paramContext != null) {
        if (paramContext != null) {
          break label25;
        }
      }
      for (paramContext = null;; paramContext = logger)
      {
        return paramContext;
        label25:
        try
        {
          paramContext = FacebookSdk.getApplicationContext();
          break;
        }
        finally {}
        if (logger == null) {
          logger = new LoginLogger(paramContext, FacebookSdk.getApplicationId());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */