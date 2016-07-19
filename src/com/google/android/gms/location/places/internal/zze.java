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
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompleteFilter.Builder;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zze
  extends zzk<zzg>
{
  private final PlacesParams afy;
  private final Locale afz = Locale.getDefault();
  
  private zze(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 65, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzg.getAccount() != null) {
      paramContext = getAccountname;
    }
    afy = new PlacesParams(paramString, afz, paramContext, afc, afd);
  }
  
  public void zza(zzl paramzzl, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter)
    throws RemoteException
  {
    zzab.zzb(paramzzl, "callback == null");
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      if (paramAutocompleteFilter == null) {
        paramAutocompleteFilter = new AutocompleteFilter.Builder().build();
      }
      for (;;)
      {
        ((zzg)zzarw()).zza(paramString, paramLatLngBounds, paramAutocompleteFilter, afy, paramzzl);
        return;
      }
    }
  }
  
  public void zza(zzl paramzzl, List<String> paramList)
    throws RemoteException
  {
    ((zzg)zzarw()).zzb(paramList, afy, paramzzl);
  }
  
  protected zzg zzgy(IBinder paramIBinder)
  {
    return zzg.zza.zzha(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.location.places.GeoDataApi";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlacesService";
  }
  
  public static class zza
    extends Api.zza<zze, PlacesOptions>
  {
    public zze zza(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzg paramzzg, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
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
        return new zze(paramContext, paramLooper, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener, str, paramPlacesOptions, null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */