package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DeviceAuthDialog$RequestState$1
  implements Parcelable.Creator<DeviceAuthDialog.RequestState>
{
  public DeviceAuthDialog.RequestState createFromParcel(Parcel paramParcel)
  {
    return new DeviceAuthDialog.RequestState(paramParcel);
  }
  
  public DeviceAuthDialog.RequestState[] newArray(int paramInt)
  {
    return new DeviceAuthDialog.RequestState[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.RequestState.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */