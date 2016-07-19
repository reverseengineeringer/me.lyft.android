package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LoginClient$Request$1
  implements Parcelable.Creator
{
  public LoginClient.Request createFromParcel(Parcel paramParcel)
  {
    return new LoginClient.Request(paramParcel, null);
  }
  
  public LoginClient.Request[] newArray(int paramInt)
  {
    return new LoginClient.Request[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginClient.Request.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */