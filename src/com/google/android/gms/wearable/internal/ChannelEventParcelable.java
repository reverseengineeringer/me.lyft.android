package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzn();
  final int aKd;
  final int aKe;
  final ChannelImpl aKf;
  final int mVersionCode;
  final int type;
  
  ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    mVersionCode = paramInt1;
    aKf = paramChannelImpl;
    type = paramInt2;
    aKd = paramInt3;
    aKe = paramInt4;
  }
  
  private static String zzabn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CHANNEL_OPENED";
    case 2: 
      return "CHANNEL_CLOSED";
    case 4: 
      return "OUTPUT_CLOSED";
    }
    return "INPUT_CLOSED";
  }
  
  private static String zzabo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CLOSE_REASON_DISCONNECTED";
    case 2: 
      return "CLOSE_REASON_REMOTE_CLOSE";
    case 3: 
      return "CLOSE_REASON_LOCAL_CLOSE";
    }
    return "CLOSE_REASON_NORMAL";
  }
  
  public String toString()
  {
    int i = mVersionCode;
    String str1 = String.valueOf(aKf);
    String str2 = String.valueOf(zzabn(type));
    String str3 = String.valueOf(zzabo(aKd));
    int j = aKe;
    return String.valueOf(str1).length() + 104 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelEventParcelable[versionCode=" + i + ", channel=" + str1 + ", type=" + str2 + ", closeReason=" + str3 + ", appErrorCode=" + j + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  public void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (type)
    {
    default: 
      int i = type;
      Log.w("ChannelEventParcelable", 25 + "Unknown type: " + i);
      return;
    case 1: 
      paramChannelListener.onChannelOpened(aKf);
      return;
    case 2: 
      paramChannelListener.onChannelClosed(aKf, aKd, aKe);
      return;
    case 3: 
      paramChannelListener.onInputClosed(aKf, aKd, aKe);
      return;
    }
    paramChannelListener.onOutputClosed(aKf, aKd, aKe);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.ChannelEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */