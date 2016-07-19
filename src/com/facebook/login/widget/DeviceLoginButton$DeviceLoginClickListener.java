package com.facebook.login.widget;

import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;

class DeviceLoginButton$DeviceLoginClickListener
  extends LoginButton.LoginClickListener
{
  private DeviceLoginButton$DeviceLoginClickListener(DeviceLoginButton paramDeviceLoginButton)
  {
    super(paramDeviceLoginButton);
  }
  
  protected LoginManager getLoginManager()
  {
    DeviceLoginManager localDeviceLoginManager = DeviceLoginManager.getInstance();
    localDeviceLoginManager.setDefaultAudience(this$0.getDefaultAudience());
    localDeviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
    localDeviceLoginManager.setDeviceRedirectUri(this$0.getDeviceRedirectUri());
    return localDeviceLoginManager;
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.DeviceLoginButton.DeviceLoginClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */