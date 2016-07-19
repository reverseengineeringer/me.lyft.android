package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzle;

@zzir
public class zzd$zzb
  extends zzd
  implements com.google.android.gms.common.internal.zzd.zzb, zzd.zzc
{
  private Context mContext;
  private final Object zzail = new Object();
  private VersionInfoParcel zzalm;
  private zzle<AdRequestInfoParcel> zzcan;
  private final zzc.zza zzcao;
  protected zze zzcar;
  private boolean zzcas;
  
  public zzd$zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzle<AdRequestInfoParcel> paramzzle, zzc.zza paramzza)
  {
    super(paramzzle, paramzza);
    mContext = paramContext;
    zzalm = paramVersionInfoParcel;
    zzcan = paramzzle;
    zzcao = paramzza;
    if (((Boolean)zzdc.zzayw.get()).booleanValue()) {
      zzcas = true;
    }
    for (paramVersionInfoParcel = zzu.zzgc().zztr();; paramVersionInfoParcel = paramContext.getMainLooper())
    {
      zzcar = new zze(paramContext, paramVersionInfoParcel, this, this, zzalm.zzcnp);
      connect();
      return;
    }
  }
  
  protected void connect()
  {
    zzcar.zzart();
  }
  
  public void onConnected(Bundle paramBundle)
  {
    paramBundle = (Void)zzpz();
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzkh.zzcw("Cannot connect to remote service, fallback to local instance.");
    zzqz().zzpz();
    paramConnectionResult = new Bundle();
    paramConnectionResult.putString("action", "gms_connection_failed_fallback_to_local");
    zzu.zzfq().zzb(mContext, zzalm.zzcs, "gmob-apps", paramConnectionResult, true);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzkh.zzcw("Disconnected from remote ad request service.");
  }
  
  public void zzqx()
  {
    synchronized (zzail)
    {
      if ((zzcar.isConnected()) || (zzcar.isConnecting())) {
        zzcar.disconnect();
      }
      Binder.flushPendingCommands();
      if (zzcas)
      {
        zzu.zzgc().zzts();
        zzcas = false;
      }
      return;
    }
  }
  
  /* Error */
  public zzk zzqy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/google/android/gms/ads/internal/request/zzd$zzb:zzail	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 90	com/google/android/gms/ads/internal/request/zzd$zzb:zzcar	Lcom/google/android/gms/ads/internal/request/zze;
    //   11: invokevirtual 189	com/google/android/gms/ads/internal/request/zze:zzrc	()Lcom/google/android/gms/ads/internal/request/zzk;
    //   14: astore_2
    //   15: aload_1
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_1
    //   20: monitorexit
    //   21: aconst_null
    //   22: areturn
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: astore_2
    //   29: goto -10 -> 19
    //   32: astore_2
    //   33: goto -14 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	zzb
    //   14	4	2	localzzk	zzk
    //   23	4	2	localObject2	Object
    //   28	1	2	localDeadObjectException	android.os.DeadObjectException
    //   32	1	2	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   7	15	23	finally
    //   15	17	23	finally
    //   19	21	23	finally
    //   24	26	23	finally
    //   7	15	28	android/os/DeadObjectException
    //   7	15	32	java/lang/IllegalStateException
  }
  
  zzkn zzqz()
  {
    return new zzd.zza(mContext, zzcan, zzcao);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */