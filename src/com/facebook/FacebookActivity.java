package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.login.LoginManager;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity
  extends FragmentActivity
{
  private static final int API_EC_DIALOG_CANCEL = 4201;
  private static String FRAGMENT_TAG = "SingleFragment";
  public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
  private static final String TAG = FacebookActivity.class.getName();
  private Fragment singleFragment;
  
  private static final String getRedirectUrl()
  {
    return "fb" + FacebookSdk.getApplicationId() + "://authorize";
  }
  
  private void handlePassThroughError()
  {
    sendResult(null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent())));
  }
  
  private void handlePassThroughUrl(String paramString)
  {
    Bundle localBundle;
    String str1;
    String str2;
    int i;
    if ((paramString != null) && (paramString.startsWith(getRedirectUrl())))
    {
      paramString = Uri.parse(paramString);
      localBundle = Utility.parseUrlQueryString(paramString.getQuery());
      localBundle.putAll(Utility.parseUrlQueryString(paramString.getFragment()));
      if ((!(singleFragment instanceof LoginFragment)) || (!((LoginFragment)singleFragment).validateChallengeParam(localBundle))) {
        sendResult(null, new FacebookException("Invalid state parameter"));
      }
      paramString = localBundle.getString("error");
      str1 = paramString;
      if (paramString == null) {
        str1 = localBundle.getString("error_type");
      }
      str2 = localBundle.getString("error_msg");
      paramString = str2;
      if (str2 == null) {
        paramString = localBundle.getString("error_message");
      }
      str2 = paramString;
      if (paramString == null) {
        str2 = localBundle.getString("error_description");
      }
      paramString = localBundle.getString("error_code");
      i = -1;
      if (Utility.isNullOrEmpty(paramString)) {}
    }
    try
    {
      i = Integer.parseInt(paramString);
      if ((Utility.isNullOrEmpty(str1)) && (Utility.isNullOrEmpty(str2)) && (i == -1))
      {
        sendResult(localBundle, null);
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = -1;
      }
      if ((str1 != null) && ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException"))))
      {
        sendResult(null, new FacebookOperationCanceledException());
        return;
      }
      if (i == 4201)
      {
        sendResult(null, new FacebookOperationCanceledException());
        return;
      }
      sendResult(null, new FacebookServiceException(new FacebookRequestError(i, str1, str2), str2));
    }
  }
  
  public Fragment getCurrentFragment()
  {
    return singleFragment;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (singleFragment != null) {
      singleFragment.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FacebookSdk.isInitialized())
    {
      Log.d(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
      FacebookSdk.sdkInitialize(getApplicationContext());
    }
    setContentView(R.layout.com_facebook_activity_layout);
    Intent localIntent = getIntent();
    if (PASS_THROUGH_CANCEL_ACTION.equals(localIntent.getAction()))
    {
      handlePassThroughError();
      return;
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag(FRAGMENT_TAG);
    paramBundle = localFragment;
    if (localFragment == null)
    {
      if (!"FacebookDialogFragment".equals(localIntent.getAction())) {
        break label118;
      }
      paramBundle = new FacebookDialogFragment();
      paramBundle.setRetainInstance(true);
      paramBundle.show(localFragmentManager, FRAGMENT_TAG);
    }
    for (;;)
    {
      singleFragment = paramBundle;
      return;
      label118:
      if ("DeviceShareDialogFragment".equals(localIntent.getAction()))
      {
        paramBundle = new DeviceShareDialogFragment();
        paramBundle.setRetainInstance(true);
        paramBundle.setShareContent((ShareContent)localIntent.getParcelableExtra("content"));
        paramBundle.show(localFragmentManager, FRAGMENT_TAG);
      }
      else
      {
        paramBundle = new LoginFragment();
        paramBundle.setRetainInstance(true);
        localFragmentManager.beginTransaction().add(R.id.com_facebook_fragment_container, paramBundle, FRAGMENT_TAG).commit();
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    handlePassThroughUrl(paramIntent.getStringExtra("url"));
  }
  
  public void sendResult(Bundle paramBundle, FacebookException paramFacebookException)
  {
    Intent localIntent = getIntent();
    int i;
    if (paramFacebookException == null)
    {
      i = -1;
      LoginManager.setSuccessResult(localIntent, paramBundle);
    }
    for (paramBundle = localIntent;; paramBundle = NativeProtocol.createProtocolResultIntent(localIntent, paramBundle, paramFacebookException))
    {
      setResult(i, paramBundle);
      finish();
      return;
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */