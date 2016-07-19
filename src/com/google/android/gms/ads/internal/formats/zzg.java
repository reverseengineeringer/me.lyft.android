package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzir
public class zzg
  extends zzi
{
  private Object zzail = new Object();
  private zzgr zzbfz;
  private zzgs zzbga;
  private final zzq zzbgb;
  private zzh zzbgc;
  private boolean zzbgd = false;
  
  private zzg(Context paramContext, zzq paramzzq, zzas paramzzas)
  {
    super(paramContext, paramzzq, null, paramzzas, null, null, null, null);
    zzbgb = paramzzq;
  }
  
  public zzg(Context paramContext, zzq paramzzq, zzas paramzzas, zzgr paramzzgr)
  {
    this(paramContext, paramzzq, paramzzas);
    zzbfz = paramzzgr;
  }
  
  public zzg(Context paramContext, zzq paramzzq, zzas paramzzas, zzgs paramzzgs)
  {
    this(paramContext, paramzzq, paramzzas);
    zzbga = paramzzgs;
  }
  
  public void recordImpression()
  {
    zzab.zzhj("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      synchronized (zzail)
      {
        zzq(true);
        if (zzbgc != null)
        {
          zzbgc.recordImpression();
          zzbgb.recordImpression();
          return;
        }
        try
        {
          if ((zzbfz != null) && (!zzbfz.getOverrideImpressionRecording()))
          {
            zzbfz.recordImpression();
            zzbgb.recordImpression();
          }
        }
        catch (RemoteException localRemoteException)
        {
          zzkh.zzd("Failed to call recordImpression", localRemoteException);
        }
      }
      if ((zzbga != null) && (!zzbga.getOverrideImpressionRecording()))
      {
        zzbga.recordImpression();
        zzbgb.recordImpression();
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> arg2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    synchronized (zzail)
    {
      zzbgd = true;
      try
      {
        if (zzbfz != null) {
          zzbfz.zzl(zze.zzae(paramView));
        }
        for (;;)
        {
          zzbgd = false;
          return;
          if (zzbga != null) {
            zzbga.zzl(zze.zzae(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          zzkh.zzd("Failed to call prepareAd", paramView);
        }
      }
    }
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzab.zzhj("performClick must be called on the main UI thread.");
    synchronized (zzail)
    {
      if (zzbgc != null)
      {
        zzbgc.zza(paramView, paramMap, paramJSONObject1, paramJSONObject2, paramJSONObject3);
        zzbgb.onAdClicked();
      }
      for (;;)
      {
        return;
        try
        {
          if ((zzbfz != null) && (!zzbfz.getOverrideClickHandling()))
          {
            zzbfz.zzk(zze.zzae(paramView));
            zzbgb.onAdClicked();
          }
          if ((zzbga == null) || (zzbga.getOverrideClickHandling())) {
            continue;
          }
          zzbga.zzk(zze.zzae(paramView));
          zzbgb.onAdClicked();
        }
        catch (RemoteException paramView)
        {
          zzkh.zzd("Failed to call performClick", paramView);
        }
      }
    }
  }
  
  public void zzb(View paramView, Map<String, WeakReference<View>> arg2)
  {
    synchronized (zzail)
    {
      try
      {
        if (zzbfz != null) {
          zzbfz.zzm(zze.zzae(paramView));
        }
        for (;;)
        {
          return;
          if (zzbga != null) {
            zzbga.zzm(zze.zzae(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          zzkh.zzd("Failed to call untrackView", paramView);
        }
      }
    }
  }
  
  public void zzc(zzh paramzzh)
  {
    synchronized (zzail)
    {
      zzbgc = paramzzh;
      return;
    }
  }
  
  public boolean zzlb()
  {
    synchronized (zzail)
    {
      boolean bool = zzbgd;
      return bool;
    }
  }
  
  public zzh zzlc()
  {
    synchronized (zzail)
    {
      zzh localzzh = zzbgc;
      return localzzh;
    }
  }
  
  public zzll zzld()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */