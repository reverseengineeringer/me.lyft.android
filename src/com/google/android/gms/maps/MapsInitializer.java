package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.internal.zzae;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  private static boolean zzafq = false;
  
  public static int initialize(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        zzab.zzb(paramContext, "Context is null");
        boolean bool = zzafq;
        if (!bool) {
          continue;
        }
      }
      finally
      {
        try
        {
          paramContext = zzae.zzdk(paramContext);
          zza(paramContext);
          zzafq = true;
        }
        catch (GooglePlayServicesNotAvailableException paramContext)
        {
          i = errorCode;
        }
        paramContext = finally;
      }
      return i;
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    try
    {
      CameraUpdateFactory.zza(paramzzc.zzbqb());
      BitmapDescriptorFactory.zza(paramzzc.zzbqc());
      return;
    }
    catch (RemoteException paramzzc)
    {
      throw new RuntimeRemoteException(paramzzc);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.MapsInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */