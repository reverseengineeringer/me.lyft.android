package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FacebookRequestError$1
  implements Parcelable.Creator<FacebookRequestError>
{
  public FacebookRequestError createFromParcel(Parcel paramParcel)
  {
    return new FacebookRequestError(paramParcel, null);
  }
  
  public FacebookRequestError[] newArray(int paramInt)
  {
    return new FacebookRequestError[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookRequestError.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */