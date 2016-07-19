package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfw.zzc;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzle.zza;
import com.google.android.gms.internal.zzle.zzc;
import com.google.android.gms.internal.zzll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzn
  extends zzkg
{
  private static final Object zzamp;
  private static zzfw zzbyz = null;
  static final long zzcdj = TimeUnit.SECONDS.toMillis(10L);
  static boolean zzcdk;
  private static zzeu zzcdl = null;
  private static zzey zzcdm = null;
  private static zzet zzcdn = null;
  private final Context mContext;
  private final Object zzbxy = new Object();
  private final zza.zza zzcai;
  private final AdRequestInfoParcel.zza zzcaj;
  private zzfw.zzc zzcdo;
  
  static
  {
    zzamp = new Object();
    zzcdk = false;
  }
  
  public zzn(Context paramContext, AdRequestInfoParcel.zza paramzza, zza.zza arg3)
  {
    super(true);
    zzcai = ???;
    mContext = paramContext;
    zzcaj = paramzza;
    synchronized (zzamp)
    {
      if (!zzcdk)
      {
        zzcdm = new zzey();
        zzcdl = new zzeu(paramContext.getApplicationContext(), zzaou);
        zzcdn = new zzc();
        zzbyz = new zzfw(mContext.getApplicationContext(), zzcaj.zzaou, (String)zzdc.zzaxw.get(), new zzb(), new zza());
        zzcdk = true;
      }
      return;
    }
  }
  
  private JSONObject zza(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    Bundle localBundle = zzcav.extras.getBundle("sdk_less_server_data");
    String str = zzcav.extras.getString("sdk_less_network_id");
    if (localBundle == null) {}
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = zziu.zza(mContext, paramAdRequestInfoParcel, zzu.zzfw().zzy(mContext), null, null, new zzcv((String)zzdc.zzaxw.get()), null, new ArrayList(), null, null);
    } while (localJSONObject == null);
    try
    {
      paramAdRequestInfoParcel = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
      localHashMap = new HashMap();
      localHashMap.put("request_id", paramString);
      localHashMap.put("network_id", str);
      localHashMap.put("request_param", localJSONObject);
      localHashMap.put("data", localBundle);
      if (paramAdRequestInfoParcel != null)
      {
        localHashMap.put("adid", paramAdRequestInfoParcel.getId());
        if (!paramAdRequestInfoParcel.isLimitAdTrackingEnabled()) {
          break label204;
        }
        i = 1;
        localHashMap.put("lat", Integer.valueOf(i));
      }
    }
    catch (IOException paramAdRequestInfoParcel)
    {
      for (;;)
      {
        try
        {
          HashMap localHashMap;
          paramAdRequestInfoParcel = zzu.zzfq().zzam(localHashMap);
          return paramAdRequestInfoParcel;
        }
        catch (JSONException paramAdRequestInfoParcel)
        {
          int i;
          return null;
        }
        paramAdRequestInfoParcel = paramAdRequestInfoParcel;
        zzkh.zzd("Cannot get advertising id info", paramAdRequestInfoParcel);
        paramAdRequestInfoParcel = null;
        continue;
        i = 0;
      }
    }
    catch (IllegalStateException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesNotAvailableException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesRepairableException paramAdRequestInfoParcel)
    {
      label204:
      for (;;) {}
    }
  }
  
  protected static void zzb(zzft paramzzft)
  {
    paramzzft.zza("/loadAd", zzcdm);
    paramzzft.zza("/fetchHttpRequest", zzcdl);
    paramzzft.zza("/invalidRequest", zzcdn);
  }
  
  protected static void zzc(zzft paramzzft)
  {
    paramzzft.zzb("/loadAd", zzcdm);
    paramzzft.zzb("/fetchHttpRequest", zzcdl);
    paramzzft.zzb("/invalidRequest", zzcdn);
  }
  
  private AdResponseParcel zze(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    final Object localObject = zzu.zzfq().zztf();
    final JSONObject localJSONObject = zza(paramAdRequestInfoParcel, (String)localObject);
    if (localJSONObject == null) {
      paramAdRequestInfoParcel = new AdResponseParcel(0);
    }
    for (;;)
    {
      return paramAdRequestInfoParcel;
      long l1 = zzu.zzfu().elapsedRealtime();
      Future localFuture = zzcdm.zzax((String)localObject);
      zza.zzcnf.post(new Runnable()
      {
        public void run()
        {
          zzn.zza(zzn.this, zzn.zzre().zzmc());
          zzn.zzb(zzn.this).zza(new zzle.zzc()new zzle.zza
          {
            public void zzb(zzfx paramAnonymous2zzfx)
            {
              try
              {
                paramAnonymous2zzfx.zza("AFMA_getAdapterLessMediationAd", zzcdq);
                return;
              }
              catch (Exception paramAnonymous2zzfx)
              {
                zzkh.zzb("Error requesting an ad url", paramAnonymous2zzfx);
                zzn.zzrd().zzay(zzcdr);
              }
            }
          }, new zzle.zza()
          {
            public void run()
            {
              zzn.zzrd().zzay(zzcdr);
            }
          });
        }
      });
      long l2 = zzcdj;
      long l3 = zzu.zzfu().elapsedRealtime();
      try
      {
        localObject = (JSONObject)localFuture.get(l2 - (l3 - l1), TimeUnit.MILLISECONDS);
        if (localObject == null) {
          return new AdResponseParcel(-1);
        }
      }
      catch (CancellationException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(-1);
      }
      catch (TimeoutException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(2);
      }
      catch (ExecutionException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(0);
        localObject = zziu.zza(mContext, paramAdRequestInfoParcel, ((JSONObject)localObject).toString());
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (errorCode == -3) {
          continue;
        }
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (!TextUtils.isEmpty(body)) {
          continue;
        }
        return new AdResponseParcel(3);
      }
      catch (InterruptedException paramAdRequestInfoParcel)
      {
        for (;;) {}
      }
    }
  }
  
  public void onStop()
  {
    synchronized (zzbxy)
    {
      zza.zzcnf.post(new Runnable()
      {
        public void run()
        {
          if (zzn.zzb(zzn.this) != null)
          {
            zzn.zzb(zzn.this).release();
            zzn.zza(zzn.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzew()
  {
    zzkh.zzcw("SdkLessAdLoaderBackgroundTask started.");
    final Object localObject = new AdRequestInfoParcel(zzcaj, null, -1L);
    AdResponseParcel localAdResponseParcel = zze((AdRequestInfoParcel)localObject);
    long l = zzu.zzfu().elapsedRealtime();
    localObject = new zzjy.zza((AdRequestInfoParcel)localObject, localAdResponseParcel, null, null, errorCode, l, zzccg, null);
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        zzn.zza(zzn.this).zza(localObject);
        if (zzn.zzb(zzn.this) != null)
        {
          zzn.zzb(zzn.this).release();
          zzn.zza(zzn.this, null);
        }
      }
    });
  }
  
  public static class zza
    implements zzkp<zzft>
  {
    public void zza(zzft paramzzft)
    {
      zzn.zzc(paramzzft);
    }
  }
  
  public static class zzb
    implements zzkp<zzft>
  {
    public void zza(zzft paramzzft)
    {
      zzn.zzb(paramzzft);
    }
  }
  
  public static class zzc
    implements zzet
  {
    public void zza(zzll paramzzll, Map<String, String> paramMap)
    {
      String str = (String)paramMap.get("request_id");
      paramzzll = String.valueOf((String)paramMap.get("errors"));
      if (paramzzll.length() != 0) {}
      for (paramzzll = "Invalid request: ".concat(paramzzll);; paramzzll = new String("Invalid request: "))
      {
        zzkh.zzcy(paramzzll);
        zzn.zzrd().zzay(str);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */