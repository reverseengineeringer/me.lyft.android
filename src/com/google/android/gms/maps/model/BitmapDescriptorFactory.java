package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.model.internal.zza;

public final class BitmapDescriptorFactory
{
  private static zza aib;
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = new BitmapDescriptor(zzbqf().zzc(paramBitmap));
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      throw new RuntimeRemoteException(paramBitmap);
    }
  }
  
  public static void zza(zza paramzza)
  {
    if (aib != null) {
      return;
    }
    aib = (zza)zzab.zzaa(paramzza);
  }
  
  private static zza zzbqf()
  {
    return (zza)zzab.zzb(aib, "IBitmapDescriptorFactory is not initialized");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.BitmapDescriptorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */