package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzr.zza;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzir
public class zzj
  extends zzr.zza
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzd zzajv;
  private final zzgn zzajz;
  private final com.google.android.gms.ads.internal.client.zzq zzald;
  private final zzee zzale;
  private final zzef zzalf;
  private final SimpleArrayMap<String, zzeh> zzalg;
  private final SimpleArrayMap<String, zzeg> zzalh;
  private final NativeAdOptionsParcel zzali;
  private final List<String> zzalj;
  private final zzy zzalk;
  private final String zzall;
  private final VersionInfoParcel zzalm;
  private WeakReference<zzq> zzaln;
  
  zzj(Context paramContext, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.client.zzq paramzzq, zzee paramzzee, zzef paramzzef, SimpleArrayMap<String, zzeh> paramSimpleArrayMap, SimpleArrayMap<String, zzeg> paramSimpleArrayMap1, NativeAdOptionsParcel paramNativeAdOptionsParcel, zzy paramzzy, zzd paramzzd)
  {
    mContext = paramContext;
    zzall = paramString;
    zzajz = paramzzgn;
    zzalm = paramVersionInfoParcel;
    zzald = paramzzq;
    zzalf = paramzzef;
    zzale = paramzzee;
    zzalg = paramSimpleArrayMap;
    zzalh = paramSimpleArrayMap1;
    zzali = paramNativeAdOptionsParcel;
    zzalj = zzeq();
    zzalk = paramzzy;
    zzajv = paramzzd;
  }
  
  private List<String> zzeq()
  {
    ArrayList localArrayList = new ArrayList();
    if (zzalf != null) {
      localArrayList.add("1");
    }
    if (zzale != null) {
      localArrayList.add("2");
    }
    if (zzalg.size() > 0) {
      localArrayList.add("3");
    }
    return localArrayList;
  }
  
  public String getMediationAdapterClassName()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzaln != null)
        {
          Object localObject1 = (zzq)zzaln.get();
          if (localObject1 != null)
          {
            localObject1 = ((zzq)localObject1).getMediationAdapterClassName();
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public boolean isLoading()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzaln != null)
        {
          zzq localzzq = (zzq)zzaln.get();
          if (localzzq != null)
          {
            bool = localzzq.isLoading();
            return bool;
          }
        }
        else
        {
          return false;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void runOnUiThread(Runnable paramRunnable)
  {
    zzkl.zzclg.post(paramRunnable);
  }
  
  protected zzq zzer()
  {
    return new zzq(mContext, zzajv, AdSizeParcel.zzk(mContext), zzall, zzajz, zzalm);
  }
  
  public void zzf(final AdRequestParcel paramAdRequestParcel)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        synchronized (zzj.zza(zzj.this))
        {
          zzq localzzq = zzer();
          zzj.zza(zzj.this, new WeakReference(localzzq));
          localzzq.zzb(zzj.zzb(zzj.this));
          localzzq.zzb(zzj.zzc(zzj.this));
          localzzq.zza(zzj.zzd(zzj.this));
          localzzq.zza(zzj.zze(zzj.this));
          localzzq.zzb(zzj.zzf(zzj.this));
          localzzq.zzb(zzj.zzg(zzj.this));
          localzzq.zzb(zzj.zzh(zzj.this));
          localzzq.zza(zzj.zzi(zzj.this));
          localzzq.zzb(paramAdRequestParcel);
          return;
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */