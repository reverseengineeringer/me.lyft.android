package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;

public class DeviceLoginButton
  extends LoginButton
{
  private Uri deviceRedirectUri;
  
  public DeviceLoginButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public DeviceLoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DeviceLoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Uri getDeviceRedirectUri()
  {
    return deviceRedirectUri;
  }
  
  protected LoginButton.LoginClickListener getNewLoginClickListener()
  {
    return new DeviceLoginClickListener(null);
  }
  
  public void setDeviceRedirectUri(Uri paramUri)
  {
    deviceRedirectUri = paramUri;
  }
  
  private class DeviceLoginClickListener
    extends LoginButton.LoginClickListener
  {
    private DeviceLoginClickListener()
    {
      super();
    }
    
    protected LoginManager getLoginManager()
    {
      DeviceLoginManager localDeviceLoginManager = DeviceLoginManager.getInstance();
      localDeviceLoginManager.setDefaultAudience(getDefaultAudience());
      localDeviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
      localDeviceLoginManager.setDeviceRedirectUri(getDeviceRedirectUri());
      return localDeviceLoginManager;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.DeviceLoginButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */