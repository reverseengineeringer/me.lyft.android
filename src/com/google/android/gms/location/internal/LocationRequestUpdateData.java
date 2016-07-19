package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import com.google.android.gms.location.zze;
import com.google.android.gms.location.zze.zza;

public class LocationRequestUpdateData
  extends AbstractSafeParcelable
{
  public static final zzn CREATOR = new zzn();
  int adX;
  LocationRequestInternal adY;
  zze adZ;
  zzd aea;
  zzg aeb;
  PendingIntent mPendingIntent;
  private final int mVersionCode;
  
  LocationRequestUpdateData(int paramInt1, int paramInt2, LocationRequestInternal paramLocationRequestInternal, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    mVersionCode = paramInt1;
    adX = paramInt2;
    adY = paramLocationRequestInternal;
    if (paramIBinder1 == null)
    {
      paramLocationRequestInternal = null;
      adZ = paramLocationRequestInternal;
      mPendingIntent = paramPendingIntent;
      if (paramIBinder2 != null) {
        break label75;
      }
      paramLocationRequestInternal = null;
      label47:
      aea = paramLocationRequestInternal;
      if (paramIBinder3 != null) {
        break label84;
      }
    }
    label75:
    label84:
    for (paramLocationRequestInternal = (LocationRequestInternal)localObject;; paramLocationRequestInternal = zzg.zza.zzgu(paramIBinder3))
    {
      aeb = paramLocationRequestInternal;
      return;
      paramLocationRequestInternal = zze.zza.zzgs(paramIBinder1);
      break;
      paramLocationRequestInternal = zzd.zza.zzgr(paramIBinder2);
      break label47;
    }
  }
  
  public static LocationRequestUpdateData zza(LocationRequestInternal paramLocationRequestInternal, zze paramzze, zzg paramzzg)
  {
    IBinder localIBinder = paramzze.asBinder();
    if (paramzzg != null) {}
    for (paramzze = paramzzg.asBinder();; paramzze = null) {
      return new LocationRequestUpdateData(1, 1, paramLocationRequestInternal, localIBinder, null, null, paramzze);
    }
  }
  
  public static LocationRequestUpdateData zza(zzd paramzzd, zzg paramzzg)
  {
    IBinder localIBinder = paramzzd.asBinder();
    if (paramzzg != null) {}
    for (paramzzd = paramzzg.asBinder();; paramzzd = null) {
      return new LocationRequestUpdateData(1, 2, null, null, null, localIBinder, paramzzd);
    }
  }
  
  public static LocationRequestUpdateData zza(zze paramzze, zzg paramzzg)
  {
    IBinder localIBinder = paramzze.asBinder();
    if (paramzzg != null) {}
    for (paramzze = paramzzg.asBinder();; paramzze = null) {
      return new LocationRequestUpdateData(1, 2, null, localIBinder, null, null, paramzze);
    }
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzbnn()
  {
    if (adZ == null) {
      return null;
    }
    return adZ.asBinder();
  }
  
  IBinder zzbno()
  {
    if (aea == null) {
      return null;
    }
    return aea.asBinder();
  }
  
  IBinder zzbnp()
  {
    if (aeb == null) {
      return null;
    }
    return aeb.asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.LocationRequestUpdateData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */