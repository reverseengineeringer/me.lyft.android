package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class EventParcel
  extends AbstractSafeParcelable
{
  public static final zzk CREATOR = new zzk();
  public final EventParams akf;
  public final String akg;
  public final long akh;
  public final String name;
  public final int versionCode;
  
  EventParcel(int paramInt, String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    versionCode = paramInt;
    name = paramString1;
    akf = paramEventParams;
    akg = paramString2;
    akh = paramLong;
  }
  
  public EventParcel(String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    versionCode = 1;
    name = paramString1;
    akf = paramEventParams;
    akg = paramString2;
    akh = paramLong;
  }
  
  public String toString()
  {
    String str1 = akg;
    String str2 = name;
    String str3 = String.valueOf(akf);
    return String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + String.valueOf(str3).length() + "origin=" + str1 + ",name=" + str2 + ",params=" + str3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.EventParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */