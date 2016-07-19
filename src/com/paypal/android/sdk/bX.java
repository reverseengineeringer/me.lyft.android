package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bx
  extends bB
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new by();
  private boolean c;
  private String d;
  
  static
  {
    bx.class.getSimpleName();
  }
  
  public bx(Parcel paramParcel)
  {
    super(paramParcel);
    d = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public bx(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    a = paramString1;
    b = paramLong;
    d = paramString2;
    c = true;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return bx.class.getSimpleName() + "(mToken:" + a + ", mGoodUntil:" + b + ", isCreatedInternally:" + c + ")";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeLong(b);
    paramParcel.writeString(d);
    if (c) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */