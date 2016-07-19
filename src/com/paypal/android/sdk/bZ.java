package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bz
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bA();
  private String a;
  private String b;
  
  static
  {
    bz.class.getSimpleName();
  }
  
  public bz(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
  }
  
  public bz(String paramString1, String paramString2)
  {
    a = paramString1;
    b = paramString2;
  }
  
  public final String a()
  {
    return b;
  }
  
  public final String b()
  {
    return a;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return bz.class.getSimpleName() + "(authCode:" + a + ", scope:" + b + ")";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */