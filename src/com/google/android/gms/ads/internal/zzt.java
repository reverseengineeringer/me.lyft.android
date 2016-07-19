package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzir
public class zzt
  extends zzu.zza
{
  private final Context mContext;
  private zzq zzald;
  private final VersionInfoParcel zzalm;
  private final AdSizeParcel zzang;
  private final Future<zzbw> zzanh;
  private final zzb zzani;
  private WebView zzanj;
  private zzbw zzank;
  private AsyncTask<Void, Void, Void> zzanl;
  
  public zzt(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzalm = paramVersionInfoParcel;
    zzang = paramAdSizeParcel;
    zzanj = new WebView(mContext);
    zzanh = zzfg();
    zzani = new zzb(paramString);
    zzfd();
  }
  
  private void zzfd()
  {
    zzj(0);
    zzanj.setVerticalScrollBarEnabled(false);
    zzanj.getSettings().setJavaScriptEnabled(true);
    zzanj.setWebViewClient(new WebViewClient()
    {
      public void onReceivedError(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        if (zzt.zza(zzt.this) != null) {}
        try
        {
          zzt.zza(zzt.this).onAdFailedToLoad(0);
          return;
        }
        catch (RemoteException paramAnonymousWebView)
        {
          zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
        }
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith(zzff())) {
          return false;
        }
        if (paramAnonymousString.startsWith((String)zzdc.zzbcw.get()))
        {
          if (zzt.zza(zzt.this) != null) {}
          try
          {
            zzt.zza(zzt.this).onAdFailedToLoad(3);
            zzj(0);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith((String)zzdc.zzbcx.get()))
        {
          if (zzt.zza(zzt.this) != null) {}
          try
          {
            zzt.zza(zzt.this).onAdFailedToLoad(0);
            zzj(0);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith((String)zzdc.zzbcy.get()))
        {
          if (zzt.zza(zzt.this) != null) {}
          try
          {
            zzt.zza(zzt.this).onAdLoaded();
            int i = zzw(paramAnonymousString);
            zzj(i);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzkh.zzd("Could not call AdListener.onAdLoaded().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith("gmsg://")) {
          return true;
        }
        if (zzt.zza(zzt.this) != null) {}
        try
        {
          zzt.zza(zzt.this).onAdLeftApplication();
          paramAnonymousWebView = zzt.zza(zzt.this, paramAnonymousString);
          zzt.zzb(zzt.this, paramAnonymousWebView);
          return true;
        }
        catch (RemoteException paramAnonymousWebView)
        {
          for (;;)
          {
            zzkh.zzd("Could not call AdListener.onAdLeftApplication().", paramAnonymousWebView);
          }
        }
      }
    });
    zzanj.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (zzt.zzb(zzt.this) != null) {}
        try
        {
          zzt.zzb(zzt.this).zza(paramAnonymousMotionEvent);
          return false;
        }
        catch (RemoteException paramAnonymousView)
        {
          for (;;)
          {
            zzkh.zzd("Unable to process ad data", paramAnonymousView);
          }
        }
      }
    });
  }
  
  private Future<zzbw> zzfg()
  {
    zzkk.zza(new Callable()
    {
      public zzbw zzfh()
        throws Exception
      {
        return new zzbw(zzczzcs, zzt.zzd(zzt.this), false);
      }
    });
  }
  
  private String zzx(String paramString)
  {
    if (zzank == null) {
      return paramString;
    }
    paramString = Uri.parse(paramString);
    try
    {
      Uri localUri = zzank.zzd(paramString, mContext);
      paramString = localUri;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzkh.zzd("Unable to process ad data", localRemoteException);
      }
    }
    catch (zzbx localzzbx)
    {
      for (;;)
      {
        zzkh.zzd("Unable to parse ad click url", localzzbx);
      }
    }
    return paramString.toString();
  }
  
  private void zzy(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    mContext.startActivity(localIntent);
  }
  
  public void destroy()
    throws RemoteException
  {
    com.google.android.gms.common.internal.zzab.zzhj("destroy must be called on the main UI thread.");
    zzanl.cancel(true);
    zzanh.cancel(true);
    zzanj.destroy();
    zzanj = null;
  }
  
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return false;
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return false;
  }
  
  public void pause()
    throws RemoteException
  {
    com.google.android.gms.common.internal.zzab.zzhj("pause must be called on the main UI thread.");
  }
  
  public void resume()
    throws RemoteException
  {
    com.google.android.gms.common.internal.zzab.zzhj("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {}
  
  public void setUserId(String paramString)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void stopLoading()
    throws RemoteException
  {}
  
  public void zza(AdSizeParcel paramAdSizeParcel)
    throws RemoteException
  {
    throw new IllegalStateException("AdSize must be set before initialization");
  }
  
  public void zza(VideoOptionsParcel paramVideoOptionsParcel)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzp paramzzp)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzq paramzzq)
    throws RemoteException
  {
    zzald = paramzzq;
  }
  
  public void zza(zzw paramzzw)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzy paramzzy)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(com.google.android.gms.ads.internal.reward.client.zzd paramzzd)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzdo paramzzdo)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzhs paramzzhs)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzhw paramzzhw, String paramString)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
    throws RemoteException
  {
    com.google.android.gms.common.internal.zzab.zzb(zzanj, "This Search Ad has already been torn down");
    zzani.zzh(paramAdRequestParcel);
    zzanl = new zza(null).execute(new Void[0]);
    return true;
  }
  
  public com.google.android.gms.dynamic.zzd zzdn()
    throws RemoteException
  {
    com.google.android.gms.common.internal.zzab.zzhj("getAdFrame must be called on the main UI thread.");
    return zze.zzae(zzanj);
  }
  
  public AdSizeParcel zzdo()
    throws RemoteException
  {
    return zzang;
  }
  
  public void zzdq()
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public com.google.android.gms.ads.internal.client.zzab zzdr()
  {
    return null;
  }
  
  String zzfe()
  {
    Object localObject1 = new Uri.Builder();
    ((Uri.Builder)localObject1).scheme("https://").appendEncodedPath((String)zzdc.zzbcz.get());
    ((Uri.Builder)localObject1).appendQueryParameter("query", zzani.getQuery());
    ((Uri.Builder)localObject1).appendQueryParameter("pubId", zzani.zzfj());
    Object localObject3 = zzani.zzfk();
    Iterator localIterator = ((Map)localObject3).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Uri.Builder)localObject1).appendQueryParameter(str, (String)((Map)localObject3).get(str));
    }
    localObject3 = ((Uri.Builder)localObject1).build();
    if (zzank != null) {}
    try
    {
      localObject1 = zzank.zzc((Uri)localObject3, mContext);
      localObject3 = String.valueOf(zzff());
      localObject1 = String.valueOf(((Uri)localObject1).getEncodedQuery());
      return String.valueOf(localObject3).length() + 1 + String.valueOf(localObject1).length() + (String)localObject3 + "#" + (String)localObject1;
    }
    catch (zzbx localzzbx)
    {
      for (;;)
      {
        zzkh.zzd("Unable to process ad data", localzzbx);
        Object localObject2 = localObject3;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  String zzff()
  {
    String str1 = zzani.zzfi();
    if (TextUtils.isEmpty(str1)) {
      str1 = "www.google.com";
    }
    for (;;)
    {
      String str2 = String.valueOf("https://");
      String str3 = (String)zzdc.zzbcz.get();
      return String.valueOf(str2).length() + 0 + String.valueOf(str1).length() + String.valueOf(str3).length() + str2 + str1 + str3;
    }
  }
  
  void zzj(int paramInt)
  {
    if (zzanj == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
    zzanj.setLayoutParams(localLayoutParams);
  }
  
  int zzw(String paramString)
  {
    paramString = Uri.parse(paramString).getQueryParameter("height");
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = zzm.zziw().zza(mContext, Integer.parseInt(paramString));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  private class zza
    extends AsyncTask<Void, Void, Void>
  {
    private zza() {}
    
    protected Void zza(Void... paramVarArgs)
    {
      try
      {
        zzt.zza(zzt.this, (zzbw)zzt.zze(zzt.this).get(((Long)zzdc.zzbdb.get()).longValue(), TimeUnit.MILLISECONDS));
        return null;
      }
      catch (InterruptedException paramVarArgs)
      {
        for (;;)
        {
          zzkh.zzd("Failed to load ad data", paramVarArgs);
        }
      }
      catch (TimeoutException paramVarArgs)
      {
        for (;;)
        {
          zzkh.zzcy("Timed out waiting for ad data");
        }
      }
      catch (ExecutionException paramVarArgs)
      {
        for (;;) {}
      }
    }
    
    protected void zza(Void paramVoid)
    {
      paramVoid = zzfe();
      if (zzt.zzf(zzt.this) != null) {
        zzt.zzf(zzt.this).loadUrl(paramVoid);
      }
    }
  }
  
  private static class zzb
  {
    private final String zzann;
    private final Map<String, String> zzano;
    private String zzanp;
    private String zzanq;
    
    public zzb(String paramString)
    {
      zzann = paramString;
      zzano = new TreeMap();
    }
    
    public String getQuery()
    {
      return zzanp;
    }
    
    public String zzfi()
    {
      return zzanq;
    }
    
    public String zzfj()
    {
      return zzann;
    }
    
    public Map<String, String> zzfk()
    {
      return zzano;
    }
    
    public void zzh(AdRequestParcel paramAdRequestParcel)
    {
      zzanp = zzatr.zzaxj;
      if (zzatu != null) {}
      for (paramAdRequestParcel = zzatu.getBundle(AdMobAdapter.class.getName());; paramAdRequestParcel = null)
      {
        if (paramAdRequestParcel == null) {}
        for (;;)
        {
          return;
          String str1 = (String)zzdc.zzbda.get();
          Iterator localIterator = paramAdRequestParcel.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if (str1.equals(str2)) {
              zzanq = paramAdRequestParcel.getString(str2);
            } else if (str2.startsWith("csa_")) {
              zzano.put(str2.substring("csa_".length()), paramAdRequestParcel.getString(str2));
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */