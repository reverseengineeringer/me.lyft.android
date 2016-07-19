package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzk
  extends com.google.android.gms.common.internal.zzk<zzf>
{
  private final PlacesParams afy;
  private final Locale afz = Locale.getDefault();
  
  private zzk(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 67, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzg.getAccount() != null) {
      paramContext = getAccountname;
    }
    afy = new PlacesParams(paramString, afz, paramContext, afc, afd);
  }
  
  public void zza(zzl paramzzl, PlaceFilter paramPlaceFilter)
    throws RemoteException
  {
    PlaceFilter localPlaceFilter = paramPlaceFilter;
    if (paramPlaceFilter == null) {
      localPlaceFilter = PlaceFilter.zzboc();
    }
    ((zzf)zzarw()).zza(localPlaceFilter, afy, paramzzl);
  }
  
  public void zza(zzl paramzzl, PlaceReport paramPlaceReport)
    throws RemoteException
  {
    zzab.zzaa(paramPlaceReport);
    ((zzf)zzarw()).zza(paramPlaceReport, afy, paramzzl);
  }
  
  protected zzf zzhd(IBinder paramIBinder)
  {
    return zzf.zza.zzgz(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.location.places.PlaceDetectionApi";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
  }
  
  public static class zza
    extends Api.zza<zzk, PlacesOptions>
  {
    public zzk zzb(Context paramContext, Looper paramLooper, zzg paramzzg, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      if (paramPlacesOptions == null) {
        paramPlacesOptions = new PlacesOptions.Builder().build();
      }
      for (;;)
      {
        String str = paramContext.getPackageName();
        if (afb != null) {
          str = afb;
        }
        return new zzk(paramContext, paramLooper, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener, str, paramPlacesOptions, null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */