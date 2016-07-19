package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzpr.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzbp
  extends zzk<zzax>
{
  private final zzay<Object> aLg = new zzay();
  private final zzay<Object> aLh = new zzay();
  private final zzay<ChannelApi.ChannelListener> aLi = new zzay();
  private final zzay<DataApi.DataListener> aLj = new zzay();
  private final zzay<MessageApi.MessageListener> aLk = new zzay();
  private final zzay<NodeApi.NodeListener> aLl = new zzay();
  private final zzay<Object> aLm = new zzay();
  private final zzay<CapabilityApi.CapabilityListener> aLn = new zzay();
  private zzf aLo;
  private final ExecutorService axF;
  
  public zzbp(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg, Executors.newCachedThreadPool(), zzf.zzbz(paramContext));
  }
  
  zzbp(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg, ExecutorService paramExecutorService, zzf paramzzf)
  {
    super(paramContext, paramLooper, 14, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    axF = ((ExecutorService)zzab.zzaa(paramExecutorService));
    aLo = paramzzf;
  }
  
  public static Intent zzeg(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
    if (paramContext.getPackageManager().resolveActivity(localIntent, 65536) != null) {
      return localIntent;
    }
    return new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", 41 + "onPostInitHandler: statusCode " + paramInt1);
    }
    if (paramInt1 == 0)
    {
      aLg.zzli(paramIBinder);
      aLh.zzli(paramIBinder);
      aLi.zzli(paramIBinder);
      aLj.zzli(paramIBinder);
      aLk.zzli(paramIBinder);
      aLl.zzli(paramIBinder);
      aLm.zzli(paramIBinder);
      aLn.zzli(paramIBinder);
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(zzd.zzf paramzzf)
  {
    int i = 0;
    if (!zzanr()) {
      try
      {
        Bundle localBundle = getContextgetPackageManagergetApplicationInfo"com.google.android.wearable.app.cn"128metaData;
        if (localBundle != null) {
          i = localBundle.getInt("com.google.android.wearable.api.version", 0);
        }
        if (i < zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
          int j = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
          Log.w("WearableClient", 80 + "Android Wear out of date. Requires API version " + j + " but found " + i);
          zza(paramzzf, new ConnectionResult(6, PendingIntent.getActivity(getContext(), 0, zzeg(getContext()), 0)));
          return;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        zza(paramzzf, new ConnectionResult(16));
        return;
      }
    }
    super.zza(paramzzf);
  }
  
  public boolean zzanr()
  {
    return !aLo.zzb(getContext().getPackageManager(), "com.google.android.wearable.app.cn");
  }
  
  protected String zzarp()
  {
    if (aLo.zzb(getContext().getPackageManager(), "com.google.android.wearable.app.cn")) {
      return "com.google.android.wearable.app.cn";
    }
    return "com.google.android.gms";
  }
  
  public void zzb(zzpr.zzb<DataApi.DeleteDataItemsResult> paramzzb, Uri paramUri, int paramInt)
    throws RemoteException
  {
    ((zzax)zzarw()).zzb(new zzbo.zze(paramzzb), paramUri, paramInt);
  }
  
  protected zzax zzlj(IBinder paramIBinder)
  {
    return zzax.zza.zzlh(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */