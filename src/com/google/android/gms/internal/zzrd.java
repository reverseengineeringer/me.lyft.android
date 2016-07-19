package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzrd
{
  private static final zzpr.zza<?, ?>[] vt = new zzpr.zza[0];
  private final Map<Api.zzc<?>, Api.zze> tY;
  final Set<zzpr.zza<?, ?>> vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zzb vv = new zzb()
  {
    public void zzh(zzpr.zza<?, ?> paramAnonymouszza)
    {
      vu.remove(paramAnonymouszza);
      if ((paramAnonymouszza.zzaog() != null) && (zzrd.zza(zzrd.this) != null)) {
        zzrd.zza(zzrd.this).remove(paramAnonymouszza.zzaog().intValue());
      }
    }
  };
  
  public zzrd(Api.zzc<?> paramzzc, Api.zze paramzze)
  {
    tY = new ArrayMap();
    tY.put(paramzzc, paramzze);
  }
  
  public zzrd(Map<Api.zzc<?>, Api.zze> paramMap)
  {
    tY = paramMap;
  }
  
  private static void zza(zzpr.zza<?, ?> paramzza, zzd paramzzd, IBinder paramIBinder)
  {
    if (paramzza.isReady())
    {
      paramzza.zza(new zza(paramzza, paramzzd, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zza localzza = new zza(paramzza, paramzzd, paramIBinder, null);
      paramzza.zza(localzza);
      try
      {
        paramIBinder.linkToDeath(localzza, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramzza.cancel();
        paramzzd.remove(paramzza.zzaog().intValue());
        return;
      }
    }
    paramzza.zza(null);
    paramzza.cancel();
    paramzzd.remove(paramzza.zzaog().intValue());
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(vu.size());
  }
  
  public void release()
  {
    zzpr.zza[] arrayOfzza = (zzpr.zza[])vu.toArray(vt);
    int j = arrayOfzza.length;
    int i = 0;
    if (i < j)
    {
      zzpr.zza localzza = arrayOfzza[i];
      localzza.zza(null);
      if (localzza.zzaog() == null) {
        if (localzza.zzaos()) {
          vu.remove(localzza);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localzza.zzaoo();
        zza(localzza, null, ((Api.zze)tY.get(localzza.zzanp())).zzans());
        vu.remove(localzza);
      }
    }
  }
  
  public void zzaqv()
  {
    zzpr.zza[] arrayOfzza = (zzpr.zza[])vu.toArray(vt);
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      arrayOfzza[i].zzaa(new Status(8, "The connection to Google Play services was lost"));
      i += 1;
    }
  }
  
  public boolean zzaqw()
  {
    zzpr.zza[] arrayOfzza = (zzpr.zza[])vu.toArray(vt);
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfzza[i].isReady()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  <A extends Api.zzb> void zzg(zzpr.zza<? extends Result, A> paramzza)
  {
    vu.add(paramzza);
    paramzza.zza(vv);
  }
  
  private static class zza
    implements IBinder.DeathRecipient, zzrd.zzb
  {
    private final WeakReference<zzpr.zza<?, ?>> vx;
    private final WeakReference<zzd> vy;
    private final WeakReference<IBinder> vz;
    
    private zza(zzpr.zza<?, ?> paramzza, zzd paramzzd, IBinder paramIBinder)
    {
      vy = new WeakReference(paramzzd);
      vx = new WeakReference(paramzza);
      vz = new WeakReference(paramIBinder);
    }
    
    private void zzaqd()
    {
      Object localObject = (zzpr.zza)vx.get();
      zzd localzzd = (zzd)vy.get();
      if ((localzzd != null) && (localObject != null)) {
        localzzd.remove(((zzpr.zza)localObject).zzaog().intValue());
      }
      localObject = (IBinder)vz.get();
      if (vz != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public void binderDied()
    {
      zzaqd();
    }
    
    public void zzh(zzpr.zza<?, ?> paramzza)
    {
      zzaqd();
    }
  }
  
  static abstract interface zzb
  {
    public abstract void zzh(zzpr.zza<?, ?> paramzza);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */