package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GoogleNowAuthState
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
  String atW;
  String atX;
  long atY;
  final int mVersionCode;
  
  GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    mVersionCode = paramInt;
    atW = paramString1;
    atX = paramString2;
    atY = paramLong;
  }
  
  public String getAccessToken()
  {
    return atX;
  }
  
  public String getAuthCode()
  {
    return atW;
  }
  
  public long getNextAllowedTimeMillis()
  {
    return atY;
  }
  
  public String toString()
  {
    String str1 = atW;
    String str2 = atX;
    long l = atY;
    return String.valueOf(str1).length() + 74 + String.valueOf(str2).length() + "mAuthCode = " + str1 + "\nmAccessToken = " + str2 + "\nmNextAllowedTimeMillis = " + l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.GoogleNowAuthState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */