package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@zzir
public class zzcg
  implements zzch
{
  private final Object zzail = new Object();
  private final VersionInfoParcel zzalm;
  private final Context zzaqj;
  private final WeakHashMap<zzjy, zzcd> zzark = new WeakHashMap();
  private final ArrayList<zzcd> zzarl = new ArrayList();
  private final zzfw zzarm;
  
  public zzcg(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzfw paramzzfw)
  {
    zzaqj = paramContext.getApplicationContext();
    zzalm = paramVersionInfoParcel;
    zzarm = paramzzfw;
  }
  
  public zzcd zza(AdSizeParcel paramAdSizeParcel, zzjy paramzzjy)
  {
    return zza(paramAdSizeParcel, paramzzjy, zzbtq.getView());
  }
  
  public zzcd zza(AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, View paramView)
  {
    return zza(paramAdSizeParcel, paramzzjy, new zzcd.zzd(paramView, paramzzjy), null);
  }
  
  public zzcd zza(AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, View paramView, zzfx paramzzfx)
  {
    return zza(paramAdSizeParcel, paramzzjy, new zzcd.zzd(paramView, paramzzjy), paramzzfx);
  }
  
  public zzcd zza(AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, zzh paramzzh)
  {
    return zza(paramAdSizeParcel, paramzzjy, new zzcd.zza(paramzzh), null);
  }
  
  public zzcd zza(AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, zzck paramzzck, zzfx paramzzfx)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzh(paramzzjy))
        {
          paramAdSizeParcel = (zzcd)zzark.get(paramzzjy);
          return paramAdSizeParcel;
        }
        if (paramzzfx != null)
        {
          paramAdSizeParcel = new zzci(zzaqj, paramAdSizeParcel, paramzzjy, zzalm, paramzzck, paramzzfx);
          paramAdSizeParcel.zza(this);
          zzark.put(paramzzjy, paramAdSizeParcel);
          zzarl.add(paramAdSizeParcel);
          return paramAdSizeParcel;
        }
      }
      paramAdSizeParcel = new zzcj(zzaqj, paramAdSizeParcel, paramzzjy, zzalm, paramzzck, zzarm);
    }
  }
  
  public void zza(zzcd paramzzcd)
  {
    synchronized (zzail)
    {
      if (!paramzzcd.zzha())
      {
        zzarl.remove(paramzzcd);
        Iterator localIterator = zzark.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramzzcd) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public boolean zzh(zzjy paramzzjy)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        paramzzjy = (zzcd)zzark.get(paramzzjy);
        if ((paramzzjy != null) && (paramzzjy.zzha()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zzi(zzjy paramzzjy)
  {
    synchronized (zzail)
    {
      paramzzjy = (zzcd)zzark.get(paramzzjy);
      if (paramzzjy != null) {
        paramzzjy.zzgy();
      }
      return;
    }
  }
  
  public void zzj(zzjy paramzzjy)
  {
    synchronized (zzail)
    {
      paramzzjy = (zzcd)zzark.get(paramzzjy);
      if (paramzzjy != null) {
        paramzzjy.stop();
      }
      return;
    }
  }
  
  public void zzk(zzjy paramzzjy)
  {
    synchronized (zzail)
    {
      paramzzjy = (zzcd)zzark.get(paramzzjy);
      if (paramzzjy != null) {
        paramzzjy.pause();
      }
      return;
    }
  }
  
  public void zzl(zzjy paramzzjy)
  {
    synchronized (zzail)
    {
      paramzzjy = (zzcd)zzark.get(paramzzjy);
      if (paramzzjy != null) {
        paramzzjy.resume();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */