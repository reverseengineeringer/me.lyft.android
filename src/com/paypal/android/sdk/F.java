package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class f
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  private String a;
  
  public f(Parcel paramParcel)
  {
    a = paramParcel.readString();
  }
  
  public f(String paramString)
  {
    if ((!paramString.equals("OTHER")) && (paramString.length() != 2))
    {
      a = "US";
      return;
    }
    a = paramString;
  }
  
  public final String a()
  {
    return a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (f)paramObject;
    return a.equals(a);
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */