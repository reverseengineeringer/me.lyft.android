package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzs;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

@zzir
public class zzkb
  implements zzkj.zzb
{
  private Context mContext;
  private final Object zzail = new Object();
  private zzcg zzaju;
  private VersionInfoParcel zzalm;
  private boolean zzamr = false;
  private zzcn zzasi = null;
  private zzcm zzasj = null;
  private String zzbjj;
  private boolean zzcfj = true;
  private boolean zzcfk = true;
  private boolean zzcfs = false;
  private final String zzcjq;
  private final zzkc zzcjr;
  private BigInteger zzcjs = BigInteger.ONE;
  private final HashSet<zzjz> zzcjt = new HashSet();
  private final HashMap<String, zzke> zzcju = new HashMap();
  private boolean zzcjv = false;
  private int zzcjw = 0;
  private zzde zzcjx = null;
  private zzco zzcjy = null;
  private String zzcjz;
  private Boolean zzcka = null;
  private boolean zzckb = false;
  private boolean zzckc = false;
  private boolean zzckd = false;
  private String zzcke = "";
  private long zzckf = 0L;
  
  public zzkb(zzkl paramzzkl)
  {
    zzcjq = paramzzkl.zztg();
    zzcjr = new zzkc(zzcjq);
  }
  
  public Resources getResources()
  {
    Resources localResources = null;
    if (zzalm.zzcnq) {
      localResources = mContext.getResources();
    }
    for (;;)
    {
      return localResources;
      try
      {
        zzsj localzzsj = zzsj.zza(mContext, zzsj.Mg, "com.google.android.gms.ads.dynamite");
        if (localzzsj != null)
        {
          localResources = localzzsj.zzbcw().getResources();
          return localResources;
        }
      }
      catch (zzsj.zza localzza)
      {
        zzkh.zzd("Cannot load resource from dynamite apk or local jar", localzza);
      }
    }
    return null;
  }
  
  public String getSessionId()
  {
    return zzcjq;
  }
  
  public Bundle zza(Context paramContext, zzkd paramzzkd, String paramString)
  {
    Bundle localBundle;
    synchronized (zzail)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", zzcjr.zzf(paramContext, paramString));
      paramContext = new Bundle();
      paramString = zzcju.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((zzke)zzcju.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = zzcjt.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((zzjz)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramzzkd.zza(zzcjt);
    zzcjt.clear();
    return localBundle;
  }
  
  public void zza(zzjz paramzzjz)
  {
    synchronized (zzail)
    {
      zzcjt.add(paramzzjz);
      return;
    }
  }
  
  public void zza(String paramString, zzke paramzzke)
  {
    synchronized (zzail)
    {
      zzcju.put(paramString, paramzzke);
      return;
    }
  }
  
  public void zza(Thread paramThread)
  {
    zziq.zza(mContext, paramThread, zzalm);
  }
  
  public zzco zzaa(Context paramContext)
  {
    if ((!((Boolean)zzdc.zzazf.get()).booleanValue()) || (!zzs.zzavm()) || (zzsj())) {
      return null;
    }
    synchronized (zzail)
    {
      if ((Looper.getMainLooper() == null) || (paramContext == null)) {
        return null;
      }
      if (zzasi == null)
      {
        Application localApplication2 = (Application)paramContext.getApplicationContext();
        Application localApplication1 = localApplication2;
        if (localApplication2 == null) {
          localApplication1 = (Application)paramContext;
        }
        zzasi = new zzcn(localApplication1, paramContext);
      }
      if (zzasj == null) {
        zzasj = new zzcm();
      }
      if (zzcjy == null) {
        zzcjy = new zzco(zzasi, zzasj, new zziq(mContext, zzalm, null, null));
      }
      zzcjy.zzhz();
      paramContext = zzcjy;
      return paramContext;
    }
  }
  
  public void zzae(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (zzcfk != paramBoolean) {
        zzkj.zze(mContext, paramBoolean);
      }
      zzcfk = paramBoolean;
      zzco localzzco = zzaa(mContext);
      if ((localzzco != null) && (!localzzco.isAlive()))
      {
        zzkh.zzcx("start fetching content...");
        localzzco.zzhz();
      }
      return;
    }
  }
  
  public void zzaf(boolean paramBoolean)
  {
    zzckd = paramBoolean;
  }
  
  public void zzag(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzckb = paramBoolean;
      return;
    }
  }
  
  @TargetApi(23)
  public void zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (zzail)
    {
      if (!zzamr)
      {
        mContext = paramContext.getApplicationContext();
        zzalm = paramVersionInfoParcel;
        zzkj.zza(paramContext, this);
        zzkj.zzb(paramContext, this);
        zzkj.zzc(paramContext, this);
        zzkj.zzd(paramContext, this);
        zzkj.zze(paramContext, this);
        zzkj.zzf(paramContext, this);
        zza(Thread.currentThread());
        zzbjj = zzu.zzfq().zzh(paramContext, zzcs);
        if ((zzs.zzavt()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
          zzckc = true;
        }
        zzaju = new zzcg(paramContext.getApplicationContext(), zzalm, zzu.zzfq().zzc(paramContext, paramVersionInfoParcel));
        zzsx();
        zzu.zzga().zzt(mContext);
        zzamr = true;
      }
      return;
    }
  }
  
  public void zzb(Boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcka = paramBoolean;
      return;
    }
  }
  
  public void zzb(Throwable paramThrowable, boolean paramBoolean)
  {
    new zziq(mContext, zzalm, null, null).zza(paramThrowable, paramBoolean);
  }
  
  public void zzb(HashSet<zzjz> paramHashSet)
  {
    synchronized (zzail)
    {
      zzcjt.addAll(paramHashSet);
      return;
    }
  }
  
  public Future zzc(Context paramContext, boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (paramBoolean != zzcfj)
      {
        zzcfj = paramBoolean;
        paramContext = zzkj.zzc(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public Future zzcn(String paramString)
  {
    Object localObject = zzail;
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(zzcjz))
      {
        zzcjz = paramString;
        paramString = zzkj.zzg(mContext, paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public Future zzd(Context paramContext, boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (paramBoolean != zzcfs)
      {
        zzcfs = paramBoolean;
        paramContext = zzkj.zzf(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public Future zze(Context paramContext, String paramString)
  {
    zzckf = zzu.zzfu().currentTimeMillis();
    Object localObject = zzail;
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(zzcke))
      {
        zzcke = paramString;
        paramContext = zzkj.zza(paramContext, paramString, zzckf);
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public void zzg(Bundle paramBundle)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (paramBundle.containsKey("use_https"))
        {
          bool = paramBundle.getBoolean("use_https");
          zzcfj = bool;
          if (paramBundle.containsKey("webview_cache_version"))
          {
            i = paramBundle.getInt("webview_cache_version");
            zzcjw = i;
            if (paramBundle.containsKey("content_url_opted_out")) {
              zzae(paramBundle.getBoolean("content_url_opted_out"));
            }
            if (paramBundle.containsKey("content_url_hashes")) {
              zzcjz = paramBundle.getString("content_url_hashes");
            }
            if (!paramBundle.containsKey("auto_collect_location")) {
              continue;
            }
            bool = paramBundle.getBoolean("auto_collect_location");
            zzcfs = bool;
            if (!paramBundle.containsKey("app_settings_json")) {
              continue;
            }
            str = paramBundle.getString("app_settings_json");
            zzcke = str;
            if (!paramBundle.containsKey("app_settings_last_update_ms")) {
              break label213;
            }
            l = paramBundle.getLong("app_settings_last_update_ms");
            zzckf = l;
          }
        }
        else
        {
          bool = zzcfj;
          continue;
        }
        int i = zzcjw;
        continue;
        boolean bool = zzcfs;
        continue;
        String str = zzcke;
      }
      label213:
      long l = 0L;
    }
  }
  
  public boolean zzsj()
  {
    synchronized (zzail)
    {
      boolean bool = zzcfk;
      return bool;
    }
  }
  
  public String zzsk()
  {
    synchronized (zzail)
    {
      String str = zzcjs.toString();
      zzcjs = zzcjs.add(BigInteger.ONE);
      return str;
    }
  }
  
  public zzkc zzsl()
  {
    synchronized (zzail)
    {
      zzkc localzzkc = zzcjr;
      return localzzkc;
    }
  }
  
  public zzde zzsm()
  {
    synchronized (zzail)
    {
      zzde localzzde = zzcjx;
      return localzzde;
    }
  }
  
  public boolean zzsn()
  {
    synchronized (zzail)
    {
      boolean bool = zzcjv;
      zzcjv = true;
      return bool;
    }
  }
  
  public boolean zzso()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (!zzcfj)
        {
          if (!zzckc) {
            break label38;
          }
          break label33;
          return bool;
        }
      }
      label33:
      boolean bool = true;
      continue;
      label38:
      bool = false;
    }
  }
  
  public String zzsp()
  {
    synchronized (zzail)
    {
      String str = zzbjj;
      return str;
    }
  }
  
  public String zzsq()
  {
    synchronized (zzail)
    {
      String str = zzcjz;
      return str;
    }
  }
  
  public Boolean zzsr()
  {
    synchronized (zzail)
    {
      Boolean localBoolean = zzcka;
      return localBoolean;
    }
  }
  
  public boolean zzss()
  {
    synchronized (zzail)
    {
      boolean bool = zzcfs;
      return bool;
    }
  }
  
  public boolean zzst()
  {
    return zzckd;
  }
  
  public zzka zzsu()
  {
    synchronized (zzail)
    {
      zzka localzzka = new zzka(zzcke, zzckf);
      return localzzka;
    }
  }
  
  public zzcg zzsv()
  {
    return zzaju;
  }
  
  public boolean zzsw()
  {
    synchronized (zzail)
    {
      boolean bool = zzckb;
      return bool;
    }
  }
  
  void zzsx()
  {
    zzdd localzzdd = new zzdd(mContext, zzalm.zzcs);
    try
    {
      zzcjx = zzu.zzfv().zza(localzzdd);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzkh.zzd("Cannot initialize CSI reporter.", localIllegalArgumentException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */