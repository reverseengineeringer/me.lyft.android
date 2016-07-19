package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AccessToken$2
  implements Parcelable.Creator
{
  public AccessToken createFromParcel(Parcel paramParcel)
  {
    return new AccessToken(paramParcel);
  }
  
  public AccessToken[] newArray(int paramInt)
  {
    return new AccessToken[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessToken.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */