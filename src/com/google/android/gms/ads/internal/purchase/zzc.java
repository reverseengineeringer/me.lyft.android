package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzir
public class zzc
  extends zzkg
  implements ServiceConnection
{
  private Context mContext;
  private final Object zzail = new Object();
  private zzhw zzblh;
  private boolean zzbwv = false;
  private zzb zzbww;
  private zzh zzbwx;
  private List<zzf> zzbwy = null;
  private zzk zzbwz;
  
  public zzc(Context paramContext, zzhw paramzzhw, zzk paramzzk)
  {
    this(paramContext, paramzzhw, paramzzk, new zzb(paramContext), zzh.zzs(paramContext.getApplicationContext()));
  }
  
  zzc(Context paramContext, zzhw paramzzhw, zzk paramzzk, zzb paramzzb, zzh paramzzh)
  {
    mContext = paramContext;
    zzblh = paramzzhw;
    zzbwz = paramzzk;
    zzbww = paramzzb;
    zzbwx = paramzzh;
    zzbwy = zzbwx.zzg(10L);
  }
  
  private void zze(long paramLong)
  {
    do
    {
      if (!zzf(paramLong)) {
        zzkh.v("Timeout waiting for pending transaction to be processed.");
      }
    } while (!zzbwv);
  }
  
  private boolean zzf(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      zzail.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        zzkh.zzcy("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (zzail)
    {
      zzbww.zzas(paramIBinder);
      zzps();
      zzbwv = true;
      zzail.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzkh.zzcx("In-app billing service disconnected.");
    zzbww.destroy();
  }
  
  public void onStop()
  {
    synchronized (zzail)
    {
      com.google.android.gms.common.stats.zzb.zzaut().zza(mContext, this);
      zzbww.destroy();
      return;
    }
  }
  
  protected void zza(final zzf paramzzf, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    zzu.zzga();
    localIntent.putExtra("RESPONSE_CODE", 0);
    zzu.zzga();
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    zzu.zzga();
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzc.zza(zzc.this).zza(paramzzfzzbxk, -1, localIntent))
          {
            zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzfzzbxl, true, -1, localIntent, paramzzf));
            return;
          }
          zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzfzzbxl, false, -1, localIntent, paramzzf));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzkh.zzcy("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  public void zzew()
  {
    synchronized (zzail)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      com.google.android.gms.common.stats.zzb.zzaut().zza(mContext, localIntent, this, 1);
      zze(SystemClock.elapsedRealtime());
      com.google.android.gms.common.stats.zzb.zzaut().zza(mContext, this);
      zzbww.destroy();
      return;
    }
  }
  
  protected void zzps()
  {
    if (zzbwy.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = zzbwy.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzf)((Iterator)localObject1).next();
      localHashMap.put(zzbxl, localObject2);
    }
    localObject1 = null;
    for (;;)
    {
      localObject1 = zzbww.zzn(mContext.getPackageName(), (String)localObject1);
      if (localObject1 == null) {}
      do
      {
        do
        {
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            zzbwx.zza((zzf)localHashMap.get(localObject2));
          }
          break;
        } while (zzu.zzga().zze((Bundle)localObject1) != 0);
        localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        int i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          if (localHashMap.containsKey(((ArrayList)localObject2).get(i)))
          {
            String str1 = (String)((ArrayList)localObject2).get(i);
            String str2 = (String)localArrayList1.get(i);
            String str3 = (String)localArrayList2.get(i);
            zzf localzzf = (zzf)localHashMap.get(str1);
            String str4 = zzu.zzga().zzbz(str2);
            if (zzbxk.equals(str4))
            {
              zza(localzzf, str2, str3);
              localHashMap.remove(str1);
            }
          }
          i += 1;
        }
      } while ((localObject1 == null) || (localHashMap.isEmpty()));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */