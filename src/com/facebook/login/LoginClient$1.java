package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LoginClient$1
  implements Parcelable.Creator
{
  public LoginClient createFromParcel(Parcel paramParcel)
  {
    return new LoginClient(paramParcel);
  }
  
  public LoginClient[] newArray(int paramInt)
  {
    return new LoginClient[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */