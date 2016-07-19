package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DeviceAuthMethodHandler$1
  implements Parcelable.Creator
{
  public DeviceAuthMethodHandler createFromParcel(Parcel paramParcel)
  {
    return new DeviceAuthMethodHandler(paramParcel);
  }
  
  public DeviceAuthMethodHandler[] newArray(int paramInt)
  {
    return new DeviceAuthMethodHandler[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthMethodHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */