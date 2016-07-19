package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzir
public class zzij
  extends zzif
{
  private final zzdk zzajn;
  private zzgn zzajz;
  private final zzll zzbgj;
  private zzge zzboi;
  zzgc zzbyq;
  protected zzgi zzbyr;
  private boolean zzbys;
  
  zzij(Context paramContext, zzjy.zza paramzza, zzgn paramzzgn, zzig.zza paramzza1, zzdk paramzzdk, zzll paramzzll)
  {
    super(paramContext, paramzza, paramzza1);
    zzajz = paramzzgn;
    zzboi = zzcik;
    zzajn = paramzzdk;
    zzbgj = paramzzll;
  }
  
  private static String zza(zzgi paramzzgi)
  {
    String str = zzbor.zzbnb;
    int i = zzal(zzboq);
    long l = zzbow;
    return String.valueOf(str).length() + 33 + str + "." + i + "." + l;
  }
  
  private static int zzal(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 6;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case -1: 
      return 4;
    }
    return 5;
  }
  
  private static String zzg(List<zzgi> paramList)
  {
    if (paramList == null) {
      return "".toString();
    }
    Iterator localIterator = paramList.iterator();
    label20:
    Object localObject;
    for (paramList = ""; localIterator.hasNext(); paramList = String.valueOf(paramList).length() + 1 + String.valueOf(localObject).length() + paramList + (String)localObject + "_")
    {
      localObject = (zzgi)localIterator.next();
      if ((localObject == null) || (zzbor == null) || (TextUtils.isEmpty(zzbor.zzbnb))) {
        break label20;
      }
      paramList = String.valueOf(paramList);
      localObject = String.valueOf(zza((zzgi)localObject));
    }
    return paramList.substring(0, Math.max(0, paramList.length() - 1));
  }
  
  private void zzqg()
    throws zzif.zza
  {
    ??? = new CountDownLatch(1);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        synchronized (zzbxy)
        {
          zzij.zza(zzij.this, zzn.zza(zzij.zza(zzij.this), zzbyr, localObject1));
          return;
        }
      }
    });
    String str;
    try
    {
      ((CountDownLatch)???).await(10L, TimeUnit.SECONDS);
      synchronized (zzbxy)
      {
        if (!zzbys) {
          throw new zzif.zza("View could not be prepared", 0);
        }
      }
      if (!zzbgj.isDestroyed()) {
        break label133;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      str = String.valueOf(localInterruptedException);
      throw new zzif.zza(String.valueOf(str).length() + 38 + "Interrupted while waiting for latch : " + str, 0);
    }
    throw new zzif.zza("Assets not loaded, web view is destroyed", 0);
    label133:
  }
  
  public void onStop()
  {
    synchronized (zzbxy)
    {
      super.onStop();
      if (zzbyq != null) {
        zzbyq.cancel();
      }
      return;
    }
  }
  
  protected zzjy zzak(int paramInt)
  {
    Object localObject = zzbxv.zzcit;
    AdRequestParcel localAdRequestParcel = zzcav;
    zzll localzzll = zzbgj;
    List localList1 = zzbxw.zzbnq;
    List localList2 = zzbxw.zzbnr;
    List localList3 = zzbxw.zzcce;
    int i = zzbxw.orientation;
    long l1 = zzbxw.zzbnw;
    String str3 = zzcay;
    boolean bool2 = zzbxw.zzccc;
    zzgo localzzgo;
    label113:
    String str1;
    label129:
    zzge localzzge;
    zzgg localzzgg;
    label151:
    long l2;
    AdSizeParcel localAdSizeParcel;
    long l3;
    long l4;
    long l5;
    String str4;
    JSONObject localJSONObject;
    RewardItemParcel localRewardItemParcel;
    List localList4;
    List localList5;
    boolean bool1;
    label257:
    AutoClickProtectionConfigurationParcel localAutoClickProtectionConfigurationParcel;
    if (zzbyr != null)
    {
      localObject = zzbyr.zzbor;
      if (zzbyr == null) {
        break label362;
      }
      localzzgo = zzbyr.zzbos;
      if (zzbyr == null) {
        break label368;
      }
      str1 = zzbyr.zzbot;
      localzzge = zzboi;
      if (zzbyr == null) {
        break label379;
      }
      localzzgg = zzbyr.zzbou;
      l2 = zzbxw.zzccd;
      localAdSizeParcel = zzbxv.zzaoy;
      l3 = zzbxw.zzccb;
      l4 = zzbxv.zzcio;
      l5 = zzbxw.zzccg;
      str4 = zzbxw.zzcch;
      localJSONObject = zzbxv.zzcii;
      localRewardItemParcel = zzbxw.zzccr;
      localList4 = zzbxw.zzccs;
      localList5 = zzbxw.zzcct;
      if (zzboi == null) {
        break label385;
      }
      bool1 = zzboi.zzbob;
      localAutoClickProtectionConfigurationParcel = zzbxw.zzccv;
      if (zzbyq == null) {
        break label391;
      }
    }
    label362:
    label368:
    label379:
    label385:
    label391:
    for (String str2 = zzg(zzbyq.zzmi());; str2 = null)
    {
      return new zzjy(localAdRequestParcel, localzzll, localList1, paramInt, localList2, localList3, i, l1, str3, bool2, (zzgd)localObject, localzzgo, str1, localzzge, localzzgg, l2, localAdSizeParcel, l3, l4, l5, str4, localJSONObject, null, localRewardItemParcel, localList4, localList5, bool1, localAutoClickProtectionConfigurationParcel, str2, zzbxw.zzbnt);
      localObject = null;
      break;
      localzzgo = null;
      break label113;
      str1 = AdMobAdapter.class.getName();
      break label129;
      localzzgg = null;
      break label151;
      bool1 = false;
      break label257;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzif.zza
  {
    for (;;)
    {
      synchronized (zzbxy)
      {
        zzbyq = zzi(paramLong);
        ??? = new ArrayList(zzboi.zzbno);
        Object localObject2 = zzbxv.zzcit.zzcav.zzatu;
        if (localObject2 == null) {
          break label271;
        }
        localObject2 = ((Bundle)localObject2).getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (localObject2 == null) {
          break label271;
        }
        bool = ((Bundle)localObject2).getBoolean("_skipMediation");
        if (bool)
        {
          localObject2 = ((List)???).listIterator();
          if (((ListIterator)localObject2).hasNext())
          {
            if (nextzzbna.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
              continue;
            }
            ((ListIterator)localObject2).remove();
          }
        }
      }
      zzbyr = zzbyq.zzd((List)???);
      switch (zzbyr.zzboq)
      {
      default: 
        int i = zzbyr.zzboq;
        throw new zzif.zza(40 + "Unexpected mediation result: " + i, 0);
      case 1: 
        throw new zzif.zza("No fill from any mediation ad networks.", 3);
      }
      if ((zzbyr.zzbor != null) && (zzbyr.zzbor.zzbnj != null)) {
        zzqg();
      }
      return;
      label271:
      boolean bool = false;
    }
  }
  
  zzgc zzi(long paramLong)
  {
    if (zzboi.zzbnz != -1) {
      return new zzgk(mContext, zzbxv.zzcit, zzajz, zzboi, zzbxw.zzaus, zzbxw.zzauu, paramLong, ((Long)zzdc.zzbbf.get()).longValue(), 2);
    }
    return new zzgl(mContext, zzbxv.zzcit, zzajz, zzboi, zzbxw.zzaus, zzbxw.zzauu, paramLong, ((Long)zzdc.zzbbf.get()).longValue(), zzajn);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */