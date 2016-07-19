package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AddListenerRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzc();
  public final zzaw aJE;
  public final IntentFilter[] aJF;
  public final String aJG;
  public final String aJH;
  final int mVersionCode;
  
  AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    if (paramIBinder != null) {}
    for (aJE = zzaw.zza.zzlg(paramIBinder);; aJE = null)
    {
      aJF = paramArrayOfIntentFilter;
      aJG = paramString1;
      aJH = paramString2;
      return;
    }
  }
  
  public AddListenerRequest(zzbq paramzzbq)
  {
    mVersionCode = 1;
    aJE = paramzzbq;
    aJF = paramzzbq.zzcjd();
    aJG = paramzzbq.zzcje();
    aJH = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzaxk()
  {
    if (aJE == null) {
      return null;
    }
    return aJE.asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AddListenerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */