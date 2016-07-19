package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RemoveListenerRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbg();
  public final zzaw aJE;
  final int mVersionCode;
  
  RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    mVersionCode = paramInt;
    if (paramIBinder != null)
    {
      aJE = zzaw.zza.zzlg(paramIBinder);
      return;
    }
    aJE = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbg.zza(this, paramParcel, paramInt);
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
 * Qualified Name:     com.google.android.gms.wearable.internal.RemoveListenerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */