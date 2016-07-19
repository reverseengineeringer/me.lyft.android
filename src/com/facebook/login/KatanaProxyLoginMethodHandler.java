package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.util.Collection;

class KatanaProxyLoginMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator()
  {
    public KatanaProxyLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
    {
      return new KatanaProxyLoginMethodHandler(paramAnonymousParcel);
    }
    
    public KatanaProxyLoginMethodHandler[] newArray(int paramAnonymousInt)
    {
      return new KatanaProxyLoginMethodHandler[paramAnonymousInt];
    }
  };
  
  KatanaProxyLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  KatanaProxyLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  private String getError(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_type");
    }
    return str1;
  }
  
  private String getErrorMessage(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error_message");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_description");
    }
    return str1;
  }
  
  private LoginClient.Result handleResultCancel(LoginClient.Request paramRequest, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    String str1 = getError(paramIntent);
    String str2 = paramIntent.getString("error_code");
    if ("CONNECTION_FAILURE".equals(str2)) {
      return LoginClient.Result.createErrorResult(paramRequest, str1, getErrorMessage(paramIntent), str2);
    }
    return LoginClient.Result.createCancelResult(paramRequest, str1);
  }
  
  private LoginClient.Result handleResultOk(LoginClient.Request paramRequest, Intent paramIntent)
  {
    Object localObject = null;
    paramIntent = paramIntent.getExtras();
    String str1 = getError(paramIntent);
    String str2 = paramIntent.getString("error_code");
    String str3 = getErrorMessage(paramIntent);
    String str4 = paramIntent.getString("e2e");
    if (!Utility.isNullOrEmpty(str4)) {
      logWebLoginCompleted(str4);
    }
    if ((str1 == null) && (str2 == null) && (str3 == null)) {}
    do
    {
      try
      {
        paramIntent = LoginClient.Result.createTokenResult(paramRequest, createAccessTokenFromWebBundle(paramRequest.getPermissions(), paramIntent, AccessTokenSource.FACEBOOK_APPLICATION_WEB, paramRequest.getApplicationId()));
        return paramIntent;
      }
      catch (FacebookException paramIntent)
      {
        return LoginClient.Result.createErrorResult(paramRequest, null, paramIntent.getMessage());
      }
      paramIntent = (Intent)localObject;
    } while (ServerProtocol.errorsProxyAuthDisabled.contains(str1));
    if (ServerProtocol.errorsUserCanceled.contains(str1)) {
      return LoginClient.Result.createCancelResult(paramRequest, null);
    }
    return LoginClient.Result.createErrorResult(paramRequest, str1, str3, str2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "katana_proxy_auth";
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    LoginClient.Request localRequest = loginClient.getPendingRequest();
    if (paramIntent == null)
    {
      paramIntent = LoginClient.Result.createCancelResult(localRequest, "Operation canceled");
      if (paramIntent == null) {
        break label78;
      }
      loginClient.completeAndValidate(paramIntent);
    }
    for (;;)
    {
      return true;
      if (paramInt2 == 0)
      {
        paramIntent = handleResultCancel(localRequest, paramIntent);
        break;
      }
      if (paramInt2 != -1)
      {
        paramIntent = LoginClient.Result.createErrorResult(localRequest, "Unexpected resultCode from authorization.", null);
        break;
      }
      paramIntent = handleResultOk(localRequest, paramIntent);
      break;
      label78:
      loginClient.tryNextHandler();
    }
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    String str = LoginClient.getE2E();
    paramRequest = NativeProtocol.createProxyAuthIntent(loginClient.getActivity(), paramRequest.getApplicationId(), paramRequest.getPermissions(), str, paramRequest.isRerequest(), paramRequest.hasPublishPermission(), paramRequest.getDefaultAudience(), getClientState(paramRequest.getAuthId()));
    addLoggingExtra("e2e", str);
    return tryIntent(paramRequest, LoginClient.getLoginRequestCode());
  }
  
  protected boolean tryIntent(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      return false;
    }
    try
    {
      loginClient.getFragment().startActivityForResult(paramIntent, paramInt);
      return true;
    }
    catch (ActivityNotFoundException paramIntent) {}
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.KatanaProxyLoginMethodHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */