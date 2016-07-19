package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Random;

public final class cm
  extends bB
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cn();
  
  public cm()
  {
    long l = System.currentTimeMillis();
    if (a == null) {
      b = l;
    }
    if (b + 1800000L > l)
    {
      b = l;
      Random localRandom = new Random(b);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < 8)
      {
        localStringBuilder.append((char)(Math.abs(localRandom.nextInt()) % 10 + 48));
        i += 1;
      }
      a = localStringBuilder.toString();
    }
  }
  
  public cm(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeLong(b);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */