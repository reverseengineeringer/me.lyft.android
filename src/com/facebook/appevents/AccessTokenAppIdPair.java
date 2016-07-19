package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.Serializable;

class AccessTokenAppIdPair
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final String accessTokenString;
  private final String applicationId;
  
  public AccessTokenAppIdPair(AccessToken paramAccessToken)
  {
    this(paramAccessToken.getToken(), FacebookSdk.getApplicationId());
  }
  
  public AccessTokenAppIdPair(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (Utility.isNullOrEmpty(paramString1)) {
      str = null;
    }
    accessTokenString = str;
    applicationId = paramString2;
  }
  
  private Object writeReplace()
  {
    return new SerializationProxyV1(accessTokenString, applicationId, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AccessTokenAppIdPair)) {}
    do
    {
      return false;
      paramObject = (AccessTokenAppIdPair)paramObject;
    } while ((!Utility.areObjectsEqual(accessTokenString, accessTokenString)) || (!Utility.areObjectsEqual(applicationId, applicationId)));
    return true;
  }
  
  public String getAccessTokenString()
  {
    return accessTokenString;
  }
  
  public String getApplicationId()
  {
    return applicationId;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (accessTokenString == null)
    {
      i = 0;
      if (applicationId != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = accessTokenString.hashCode();
      break;
      label33:
      j = applicationId.hashCode();
    }
  }
  
  static class SerializationProxyV1
    implements Serializable
  {
    private static final long serialVersionUID = -2488473066578201069L;
    private final String accessTokenString;
    private final String appId;
    
    private SerializationProxyV1(String paramString1, String paramString2)
    {
      accessTokenString = paramString1;
      appId = paramString2;
    }
    
    private Object readResolve()
    {
      return new AccessTokenAppIdPair(accessTokenString, appId);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AccessTokenAppIdPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */