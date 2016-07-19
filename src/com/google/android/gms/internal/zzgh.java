package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzgh
  implements zzgi.zza
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzgn zzajz;
  private final NativeAdOptionsParcel zzali;
  private final List<String> zzalj;
  private final VersionInfoParcel zzalm;
  private AdRequestParcel zzana;
  private final AdSizeParcel zzang;
  private final boolean zzarj;
  private final boolean zzawl;
  private final String zzbog;
  private final long zzboh;
  private final zzge zzboi;
  private final zzgd zzboj;
  private zzgo zzbok;
  private int zzbol = -2;
  private zzgq zzbom;
  
  public zzgh(Context paramContext, String paramString, zzgn paramzzgn, zzge paramzzge, zzgd paramzzgd, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean1, boolean paramBoolean2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    mContext = paramContext;
    zzajz = paramzzgn;
    zzboj = paramzzgd;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      zzbog = zzmj();
      zzboi = paramzzge;
      if (zzbnp == -1L) {
        break label136;
      }
    }
    label136:
    for (long l = zzbnp;; l = 10000L)
    {
      zzboh = l;
      zzana = paramAdRequestParcel;
      zzang = paramAdSizeParcel;
      zzalm = paramVersionInfoParcel;
      zzarj = paramBoolean1;
      zzawl = paramBoolean2;
      zzali = paramNativeAdOptionsParcel;
      zzalj = paramList;
      return;
      zzbog = paramString;
      break;
    }
  }
  
  private long zza(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (zzbol != -2) {
        return zzu.zzfu().elapsedRealtime() - paramLong1;
      }
      zzb(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void zza(zzgg paramzzgg)
  {
    if ("com.google.ads.mediation.AdUrlAdapter".equals(zzbog))
    {
      if (zzana.zzatu == null) {
        zzana = new zzf(zzana).zzc(new Bundle()).zzig();
      }
      Bundle localBundle = zzana.zzatu.getBundle(zzbog);
      localObject = localBundle;
      if (localBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putString("sdk_less_network_id", zzboj.zzbmz);
      zzana.zzatu.putBundle(zzbog, (Bundle)localObject);
    }
    Object localObject = zzbk(zzboj.zzbng);
    try
    {
      if (zzalm.zzcnp < 4100000)
      {
        if (zzang.zzauq)
        {
          zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzana, (String)localObject, paramzzgg);
          return;
        }
        zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzang, zzana, (String)localObject, paramzzgg);
        return;
      }
    }
    catch (RemoteException paramzzgg)
    {
      zzkh.zzd("Could not request ad from mediation adapter.", paramzzgg);
      zzy(5);
      return;
    }
    if (zzarj)
    {
      zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzana, (String)localObject, zzboj.zzbmy, paramzzgg, zzali, zzalj);
      return;
    }
    if (zzang.zzauq)
    {
      zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzana, (String)localObject, zzboj.zzbmy, paramzzgg);
      return;
    }
    if (zzawl)
    {
      if (zzboj.zzbnj != null)
      {
        zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzana, (String)localObject, zzboj.zzbmy, paramzzgg, new NativeAdOptionsParcel(zzbl(zzboj.zzbnn)), zzboj.zzbnm);
        return;
      }
      zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzang, zzana, (String)localObject, zzboj.zzbmy, paramzzgg);
      return;
    }
    zzbok.zza(com.google.android.gms.dynamic.zze.zzae(mContext), zzang, zzana, (String)localObject, zzboj.zzbmy, paramzzgg);
  }
  
  private static zzgq zzaa(int paramInt)
  {
    new zzgq.zza()
    {
      public int zzmo()
        throws RemoteException
      {
        return zzbop;
      }
    };
  }
  
  private void zzb(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      zzkh.zzcx("Timed out waiting for adapter.");
      zzbol = 3;
      return;
    }
    try
    {
      zzail.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzbol = -1;
    }
  }
  
  private String zzbk(String paramString)
  {
    if ((paramString == null) || (!zzmm()) || (zzz(2))) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).remove("cpm_floor_cents");
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzcy("Could not remove field. Returning the original value");
    }
    return paramString;
  }
  
  private static NativeAdOptions zzbl(String paramString)
  {
    NativeAdOptions.Builder localBuilder = new NativeAdOptions.Builder();
    if (paramString == null) {
      return localBuilder.build();
    }
    try
    {
      paramString = new JSONObject(paramString);
      localBuilder.setRequestMultipleImages(paramString.optBoolean("multiple_images", false));
      localBuilder.setReturnUrlsForImageAssets(paramString.optBoolean("only_urls", false));
      localBuilder.setImageOrientation(zzbm(paramString.optString("native_image_orientation", "any")));
      return localBuilder.build();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        zzkh.zzd("Exception occurred when creating native ad options", paramString);
      }
    }
  }
  
  private static int zzbm(String paramString)
  {
    if ("landscape".equals(paramString)) {
      return 2;
    }
    if ("portrait".equals(paramString)) {
      return 1;
    }
    return 0;
  }
  
  private String zzmj()
  {
    try
    {
      if (!TextUtils.isEmpty(zzboj.zzbnc))
      {
        if (zzajz.zzbo(zzboj.zzbnc)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzcy("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private zzgq zzmk()
  {
    if ((zzbol != 0) || (!zzmm())) {
      return null;
    }
    try
    {
      if ((zzz(4)) && (zzbom != null) && (zzbom.zzmo() != 0))
      {
        zzgq localzzgq = zzbom;
        return localzzgq;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzcy("Could not get cpm value from MediationResponseMetadata");
    }
    return zzaa(zzmn());
  }
  
  private zzgo zzml()
  {
    Object localObject = String.valueOf(zzbog);
    if (((String)localObject).length() != 0) {}
    for (localObject = "Instantiating mediation adapter: ".concat((String)localObject);; localObject = new String("Instantiating mediation adapter: "))
    {
      zzkh.zzcx((String)localObject);
      if (zzarj) {
        break label155;
      }
      if ((!((Boolean)zzdc.zzbbc.get()).booleanValue()) || (!"com.google.ads.mediation.admob.AdMobAdapter".equals(zzbog))) {
        break;
      }
      return zza(new AdMobAdapter());
    }
    if ((((Boolean)zzdc.zzbbd.get()).booleanValue()) && ("com.google.ads.mediation.AdUrlAdapter".equals(zzbog))) {
      return zza(new AdUrlAdapter());
    }
    if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(zzbog)) {
      return new zzgu(new zzhc());
    }
    try
    {
      label155:
      localObject = zzajz.zzbn(zzbog);
      return (zzgo)localObject;
    }
    catch (RemoteException localRemoteException)
    {
      localObject = String.valueOf(zzbog);
      if (((String)localObject).length() == 0) {}
    }
    for (localObject = "Could not instantiate mediation adapter: ".concat((String)localObject);; localObject = new String("Could not instantiate mediation adapter: "))
    {
      zzkh.zza((String)localObject, localRemoteException);
      return null;
    }
  }
  
  private boolean zzmm()
  {
    return zzboi.zzbnz != -1;
  }
  
  private int zzmn()
  {
    int j;
    if (zzboj.zzbng == null)
    {
      j = 0;
      return j;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(zzboj.zzbng);
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzbog)) {
        return localJSONObject.optInt("cpm_cents", 0);
      }
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzcy("Could not convert to json. Returning 0");
      return 0;
    }
    if (zzz(2)) {}
    for (int i = localJSONException.optInt("cpm_floor_cents", 0);; i = 0)
    {
      j = i;
      if (i != 0) {
        break;
      }
      return localJSONException.optInt("penalized_average_cpm_cents", 0);
    }
  }
  
  private boolean zzz(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Bundle localBundle;
        if (zzarj)
        {
          localBundle = zzbok.zzmt();
          if (localBundle != null)
          {
            if ((localBundle.getInt("capabilities", 0) & paramInt) == paramInt) {
              bool = true;
            }
          }
          else {
            return bool;
          }
        }
        else
        {
          if (zzang.zzauq)
          {
            localBundle = zzbok.getInterstitialAdapterInfo();
            continue;
          }
          localBundle = zzbok.zzms();
          continue;
        }
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzkh.zzcy("Could not get adapter info. Returning false");
        return false;
      }
    }
  }
  
  public void cancel()
  {
    synchronized (zzail)
    {
      try
      {
        if (zzbok != null) {
          zzbok.destroy();
        }
        zzbol = -1;
        zzail.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          zzkh.zzd("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public zzgi zza(long paramLong1, long paramLong2)
  {
    synchronized (zzail)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new zzgg();
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          synchronized (zzgh.zza(zzgh.this))
          {
            if (zzgh.zzb(zzgh.this) != -2) {
              return;
            }
            zzgh.zza(zzgh.this, zzgh.zzc(zzgh.this));
            if (zzgh.zzd(zzgh.this) == null)
            {
              zzy(4);
              return;
            }
          }
          if ((zzgh.zze(zzgh.this)) && (!zzgh.zza(zzgh.this, 1)))
          {
            String str = zzgh.zzf(zzgh.this);
            zzkh.zzcy(String.valueOf(str).length() + 56 + "Ignoring adapter " + str + " as delayed impression is not supported");
            zzy(2);
            return;
          }
          localObject2.zza(zzgh.this);
          zzgh.zza(zzgh.this, localObject2);
        }
      });
      paramLong1 = zza(l, zzboh, paramLong1, paramLong2);
      localObject2 = new zzgi(zzboj, zzbok, zzbog, (zzgg)localObject2, zzbol, zzmk(), paramLong1);
      return (zzgi)localObject2;
    }
  }
  
  protected zzgo zza(MediationAdapter paramMediationAdapter)
  {
    return new zzgu(paramMediationAdapter);
  }
  
  public void zza(int paramInt, zzgq paramzzgq)
  {
    synchronized (zzail)
    {
      zzbol = paramInt;
      zzbom = paramzzgq;
      zzail.notify();
      return;
    }
  }
  
  public void zzy(int paramInt)
  {
    synchronized (zzail)
    {
      zzbol = paramInt;
      zzail.notify();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */