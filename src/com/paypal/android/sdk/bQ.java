package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bq
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new br();
  private bS a;
  private String b;
  private bs c;
  
  public bq() {}
  
  public bq(Parcel paramParcel)
  {
    a = ((bS)paramParcel.readParcelable(bS.class.getClassLoader()));
    b = paramParcel.readString();
    c = ((bs)paramParcel.readSerializable());
  }
  
  public final bS a()
  {
    return a;
  }
  
  public final void a(bS parambS)
  {
    a = parambS;
  }
  
  public final void a(bs parambs)
  {
    c = parambs;
  }
  
  public final void a(String paramString)
  {
    b = paramString;
  }
  
  public final String b()
  {
    return b;
  }
  
  public final bs c()
  {
    return c;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(a, 0);
    paramParcel.writeString(b);
    paramParcel.writeSerializable(c);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */