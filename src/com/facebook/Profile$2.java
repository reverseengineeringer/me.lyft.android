package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Profile$2
  implements Parcelable.Creator
{
  public Profile createFromParcel(Parcel paramParcel)
  {
    return new Profile(paramParcel, null);
  }
  
  public Profile[] newArray(int paramInt)
  {
    return new Profile[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.Profile.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */