package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public class StringParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StringParcel> CREATOR = new zzo();
  final int mVersionCode;
  String zzbek;
  
  StringParcel(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzbek = paramString;
  }
  
  public StringParcel(String paramString)
  {
    mVersionCode = 1;
    zzbek = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public String zzrf()
  {
    return zzbek;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.StringParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */