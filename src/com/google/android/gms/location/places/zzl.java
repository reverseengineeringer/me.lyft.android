package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzu;
import com.google.android.gms.internal.zzpr.zza;
import com.google.android.gms.location.places.internal.zzi.zza;
import com.google.android.gms.location.places.personalized.zze;

public class zzl
  extends zzi.zza
{
  private static final String TAG = zzl.class.getSimpleName();
  private final zzd aeW;
  private final zza aeX;
  private final zze aeY;
  private final zzf aeZ;
  private final zzc afa;
  private final Context mContext;
  
  public zzl(zza paramzza)
  {
    aeW = null;
    aeX = paramzza;
    aeY = null;
    aeZ = null;
    afa = null;
    mContext = null;
  }
  
  public zzl(zzc paramzzc, Context paramContext)
  {
    aeW = null;
    aeX = null;
    aeY = null;
    aeZ = null;
    afa = paramzzc;
    mContext = paramContext.getApplicationContext();
  }
  
  public zzl(zzd paramzzd, Context paramContext)
  {
    aeW = paramzzd;
    aeX = null;
    aeY = null;
    aeZ = null;
    afa = null;
    mContext = paramContext.getApplicationContext();
  }
  
  public zzl(zzf paramzzf)
  {
    aeW = null;
    aeX = null;
    aeY = null;
    aeZ = paramzzf;
    afa = null;
    mContext = null;
  }
  
  public void zzbm(DataHolder paramDataHolder)
    throws RemoteException
  {
    boolean bool;
    if (aeW != null)
    {
      bool = true;
      zzab.zza(bool, "placeEstimator cannot be null");
      if (paramDataHolder != null) {
        break label92;
      }
      if (Log.isLoggable(TAG, 6))
      {
        localObject = TAG;
        paramDataHolder = String.valueOf(zzu.zzavw());
        if (paramDataHolder.length() == 0) {
          break label79;
        }
      }
    }
    label79:
    for (paramDataHolder = "onPlaceEstimated received null DataHolder: ".concat(paramDataHolder);; paramDataHolder = new String("onPlaceEstimated received null DataHolder: "))
    {
      Log.e((String)localObject, paramDataHolder);
      aeW.zzz(Status.si);
      return;
      bool = false;
      break;
    }
    label92:
    Object localObject = paramDataHolder.zzaqy();
    if (localObject == null) {}
    for (int i = 100;; i = PlaceLikelihoodBuffer.zzak((Bundle)localObject))
    {
      paramDataHolder = new PlaceLikelihoodBuffer(paramDataHolder, i, mContext);
      aeW.zzc(paramDataHolder);
      return;
    }
  }
  
  public void zzbn(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      String str;
      if (Log.isLoggable(TAG, 6))
      {
        str = TAG;
        paramDataHolder = String.valueOf(zzu.zzavw());
        if (paramDataHolder.length() == 0) {
          break label57;
        }
      }
      label57:
      for (paramDataHolder = "onAutocompletePrediction received null DataHolder: ".concat(paramDataHolder);; paramDataHolder = new String("onAutocompletePrediction received null DataHolder: "))
      {
        Log.e(str, paramDataHolder);
        aeX.zzz(Status.si);
        return;
      }
    }
    aeX.zzc(new AutocompletePredictionBuffer(paramDataHolder));
  }
  
  public void zzbo(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      String str;
      if (Log.isLoggable(TAG, 6))
      {
        str = TAG;
        paramDataHolder = String.valueOf(zzu.zzavw());
        if (paramDataHolder.length() == 0) {
          break label58;
        }
      }
      label58:
      for (paramDataHolder = "onPlaceUserDataFetched received null DataHolder: ".concat(paramDataHolder);; paramDataHolder = new String("onPlaceUserDataFetched received null DataHolder: "))
      {
        Log.e(str, paramDataHolder);
        paramDataHolder = Status.si;
        throw new NullPointerException();
      }
    }
    new zze(paramDataHolder);
    throw new NullPointerException();
  }
  
  public void zzbp(DataHolder paramDataHolder)
    throws RemoteException
  {
    paramDataHolder = new PlaceBuffer(paramDataHolder, mContext);
    afa.zzc(paramDataHolder);
  }
  
  public void zzdm(Status paramStatus)
    throws RemoteException
  {
    aeZ.zzc(paramStatus);
  }
  
  public static abstract class zza<A extends Api.zze>
    extends zzl.zzb<AutocompletePredictionBuffer, A>
  {
    public zza(Api paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected AutocompletePredictionBuffer zzdn(Status paramStatus)
    {
      return new AutocompletePredictionBuffer(DataHolder.zzfp(paramStatus.getStatusCode()));
    }
  }
  
  public static abstract class zzb<R extends Result, A extends Api.zze>
    extends zzpr.zza<R, A>
  {
    public zzb(Api paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static abstract class zzc<A extends Api.zze>
    extends zzl.zzb<PlaceBuffer, A>
  {
    public zzc(Api paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceBuffer zzdo(Status paramStatus)
    {
      return new PlaceBuffer(DataHolder.zzfp(paramStatus.getStatusCode()), null);
    }
  }
  
  public static abstract class zzd<A extends Api.zze>
    extends zzl.zzb<PlaceLikelihoodBuffer, A>
  {
    public zzd(Api paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceLikelihoodBuffer zzdp(Status paramStatus)
    {
      return new PlaceLikelihoodBuffer(DataHolder.zzfp(paramStatus.getStatusCode()), 100, null);
    }
  }
  
  public static abstract class zze<A extends Api.zze>
    extends zzl.zzb<zze, A>
  {}
  
  public static abstract class zzf<A extends Api.zze>
    extends zzl.zzb<Status, A>
  {
    public zzf(Api paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */