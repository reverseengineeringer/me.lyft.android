package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginClient$Request
  implements Parcelable
{
  public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator()
  {
    public LoginClient.Request createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LoginClient.Request(paramAnonymousParcel, null);
    }
    
    public LoginClient.Request[] newArray(int paramAnonymousInt)
    {
      return new LoginClient.Request[paramAnonymousInt];
    }
  };
  private final String applicationId;
  private final String authId;
  private final DefaultAudience defaultAudience;
  private String deviceRedirectUriString;
  private boolean isRerequest = false;
  private final LoginBehavior loginBehavior;
  private Set<String> permissions;
  
  private LoginClient$Request(Parcel paramParcel)
  {
    Object localObject1 = paramParcel.readString();
    if (localObject1 != null)
    {
      localObject1 = LoginBehavior.valueOf((String)localObject1);
      loginBehavior = ((LoginBehavior)localObject1);
      localObject1 = new ArrayList();
      paramParcel.readStringList((List)localObject1);
      permissions = new HashSet((Collection)localObject1);
      String str = paramParcel.readString();
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = DefaultAudience.valueOf(str);
      }
      defaultAudience = ((DefaultAudience)localObject1);
      applicationId = paramParcel.readString();
      authId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      isRerequest = bool;
      deviceRedirectUriString = paramParcel.readString();
      return;
      localObject1 = null;
      break;
    }
  }
  
  LoginClient$Request(LoginBehavior paramLoginBehavior, Set<String> paramSet, DefaultAudience paramDefaultAudience, String paramString1, String paramString2)
  {
    loginBehavior = paramLoginBehavior;
    if (paramSet != null) {}
    for (;;)
    {
      permissions = paramSet;
      defaultAudience = paramDefaultAudience;
      applicationId = paramString1;
      authId = paramString2;
      return;
      paramSet = new HashSet();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getApplicationId()
  {
    return applicationId;
  }
  
  String getAuthId()
  {
    return authId;
  }
  
  DefaultAudience getDefaultAudience()
  {
    return defaultAudience;
  }
  
  String getDeviceRedirectUriString()
  {
    return deviceRedirectUriString;
  }
  
  LoginBehavior getLoginBehavior()
  {
    return loginBehavior;
  }
  
  Set<String> getPermissions()
  {
    return permissions;
  }
  
  boolean hasPublishPermission()
  {
    Iterator localIterator = permissions.iterator();
    while (localIterator.hasNext()) {
      if (LoginManager.isPublishPermission((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  boolean isRerequest()
  {
    return isRerequest;
  }
  
  void setDeviceRedirectUriString(String paramString)
  {
    deviceRedirectUriString = paramString;
  }
  
  void setPermissions(Set<String> paramSet)
  {
    Validate.notNull(paramSet, "permissions");
    permissions = paramSet;
  }
  
  void setRerequest(boolean paramBoolean)
  {
    isRerequest = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (loginBehavior != null)
    {
      localObject1 = loginBehavior.name();
      paramParcel.writeString((String)localObject1);
      paramParcel.writeStringList(new ArrayList(permissions));
      localObject1 = localObject2;
      if (defaultAudience != null) {
        localObject1 = defaultAudience.name();
      }
      paramParcel.writeString((String)localObject1);
      paramParcel.writeString(applicationId);
      paramParcel.writeString(authId);
      if (!isRerequest) {
        break label106;
      }
    }
    label106:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(deviceRedirectUriString);
      return;
      localObject1 = null;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginClient.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */