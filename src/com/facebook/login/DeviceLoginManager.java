package com.facebook.login;

import android.net.Uri;
import java.util.Collection;

public class DeviceLoginManager
  extends LoginManager
{
  private static volatile DeviceLoginManager instance;
  private Uri deviceRedirectUri;
  
  public static DeviceLoginManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new DeviceLoginManager();
      }
      return instance;
    }
    finally {}
  }
  
  protected LoginClient.Request createLoginRequest(Collection<String> paramCollection)
  {
    paramCollection = super.createLoginRequest(paramCollection);
    Uri localUri = getDeviceRedirectUri();
    if (localUri != null) {
      paramCollection.setDeviceRedirectUriString(localUri.toString());
    }
    return paramCollection;
  }
  
  public Uri getDeviceRedirectUri()
  {
    return deviceRedirectUri;
  }
  
  public void setDeviceRedirectUri(Uri paramUri)
  {
    deviceRedirectUri = paramUri;
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceLoginManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */