package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlf;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzb
  extends zzkg
  implements zzc.zza
{
  private final Context mContext;
  private final zzas zzbgh;
  zzge zzboi;
  private AdRequestInfoParcel zzbox;
  AdResponseParcel zzbxw;
  private Runnable zzbxx;
  private final Object zzbxy = new Object();
  private final zza.zza zzcai;
  private final AdRequestInfoParcel.zza zzcaj;
  zzkn zzcak;
  
  public zzb(Context paramContext, AdRequestInfoParcel.zza paramzza, zzas paramzzas, zza.zza paramzza1)
  {
    zzcai = paramzza1;
    mContext = paramContext;
    zzcaj = paramzza;
    zzbgh = paramzzas;
  }
  
  private void zzd(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      zzkh.zzcx(paramString);
      if (zzbxw != null) {
        break label93;
      }
      zzbxw = new AdResponseParcel(paramInt);
      label33:
      if (zzbox == null) {
        break label115;
      }
    }
    label93:
    label115:
    for (paramString = zzbox;; paramString = new AdRequestInfoParcel(zzcaj, null, -1L))
    {
      paramString = new zzjy.zza(paramString, zzbxw, zzboi, null, paramInt, -1L, zzbxw.zzccg, null);
      zzcai.zza(paramString);
      return;
      zzkh.zzcy(paramString);
      break;
      zzbxw = new AdResponseParcel(paramInt, zzbxw.zzbnw);
      break label33;
    }
  }
  
  public void onStop()
  {
    synchronized (zzbxy)
    {
      if (zzcak != null) {
        zzcak.cancel();
      }
      return;
    }
  }
  
  zzkn zza(VersionInfoParcel paramVersionInfoParcel, zzle<AdRequestInfoParcel> paramzzle)
  {
    return zzc.zza(mContext, paramVersionInfoParcel, paramzzle, this);
  }
  
  protected AdSizeParcel zzb(AdRequestInfoParcel paramAdRequestInfoParcel)
    throws zzb.zza
  {
    if (zzbxw.zzccf == null) {
      throw new zza("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = zzbxw.zzccf.split("x");
    if (localObject.length != 2)
    {
      paramAdRequestInfoParcel = String.valueOf(zzbxw.zzccf);
      if (paramAdRequestInfoParcel.length() != 0) {}
      for (paramAdRequestInfoParcel = "Invalid ad size format from the ad response: ".concat(paramAdRequestInfoParcel);; paramAdRequestInfoParcel = new String("Invalid ad size format from the ad response: ")) {
        throw new zza(paramAdRequestInfoParcel, 0);
      }
    }
    try
    {
      m = Integer.parseInt(localObject[0]);
      n = Integer.parseInt(localObject[1]);
      localObject = zzaoy.zzaur;
      i1 = localObject.length;
      i = 0;
    }
    catch (NumberFormatException paramAdRequestInfoParcel)
    {
      for (;;)
      {
        int m;
        int n;
        int i1;
        int i;
        AdSizeParcel localAdSizeParcel;
        float f;
        paramAdRequestInfoParcel = String.valueOf(zzbxw.zzccf);
        if (paramAdRequestInfoParcel.length() != 0) {}
        for (paramAdRequestInfoParcel = "Invalid ad size number from the ad response: ".concat(paramAdRequestInfoParcel);; paramAdRequestInfoParcel = new String("Invalid ad size number from the ad response: ")) {
          throw new zza(paramAdRequestInfoParcel, 0);
        }
        int j = width;
        continue;
        int k = height;
        continue;
        i += 1;
      }
      paramAdRequestInfoParcel = String.valueOf(zzbxw.zzccf);
      if (paramAdRequestInfoParcel.length() == 0) {
        break label333;
      }
    }
    if (i < i1)
    {
      localAdSizeParcel = localObject[i];
      f = mContext.getResources().getDisplayMetrics().density;
      if (width == -1)
      {
        j = (int)(widthPixels / f);
        if (height != -2) {
          break label281;
        }
        k = (int)(heightPixels / f);
        if ((m != j) || (n != k)) {
          break label291;
        }
        return new AdSizeParcel(localAdSizeParcel, zzaoy.zzaur);
      }
    }
    label281:
    label291:
    label333:
    for (paramAdRequestInfoParcel = "The ad size from the ad response was not one of the requested sizes: ".concat(paramAdRequestInfoParcel);; paramAdRequestInfoParcel = new String("The ad size from the ad response was not one of the requested sizes: ")) {
      throw new zza(paramAdRequestInfoParcel, 0);
    }
  }
  
  public void zzb(AdResponseParcel arg1)
  {
    zzkh.zzcw("Received ad response.");
    zzbxw = ???;
    long l = zzu.zzfu().elapsedRealtime();
    synchronized (zzbxy)
    {
      zzcak = null;
      zzu.zzft().zzd(mContext, zzbxw.zzcbu);
      try
      {
        if ((zzbxw.errorCode != -2) && (zzbxw.errorCode != -3))
        {
          int i = zzbxw.errorCode;
          throw new zza(66 + "There was a problem getting an ad response. ErrorCode: " + i, zzbxw.errorCode);
        }
      }
      catch (zza ???)
      {
        zzd(???.getErrorCode(), ???.getMessage());
        zzkl.zzclg.removeCallbacks(zzbxx);
        return;
      }
    }
    zzqw();
    if (zzbox.zzaoy.zzaur != null) {}
    for (??? = zzb(zzbox);; ??? = null)
    {
      zzu.zzft().zzae(zzbxw.zzccm);
      if (!TextUtils.isEmpty(zzbxw.zzcck)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(zzbxw.zzcck);
          ??? = new zzjy.zza(zzbox, zzbxw, zzboi, ???, -2, l, zzbxw.zzccg, localJSONObject);
          zzcai.zza(???);
          zzkl.zzclg.removeCallbacks(zzbxx);
          return;
        }
        catch (Exception localException)
        {
          zzkh.zzb("Error parsing the JSON for Active View.", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void zzew()
  {
    zzkh.zzcw("AdLoaderBackgroundTask started.");
    zzbxx = new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          if (zzcak == null) {
            return;
          }
          onStop();
          zzb.zza(zzb.this, 2, "Timed out waiting for ad response.");
          return;
        }
      }
    };
    zzkl.zzclg.postDelayed(zzbxx, ((Long)zzdc.zzbbe.get()).longValue());
    final zzlf localzzlf = new zzlf();
    long l = zzu.zzfu().elapsedRealtime();
    zzkk.zza(new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          zzcak = zza(zzbzzaou, localzzlf);
          if (zzcak == null)
          {
            zzb.zza(zzb.this, 0, "Could not start the ad request service.");
            zzkl.zzclg.removeCallbacks(zzb.zzc(zzb.this));
          }
          return;
        }
      }
    });
    String str = zzbgh.zzax().zzb(mContext);
    zzbox = new AdRequestInfoParcel(zzcaj, str, l);
    localzzlf.zzg(zzbox);
  }
  
  protected void zzqw()
    throws zzb.zza
  {
    if (zzbxw.errorCode == -3) {
      return;
    }
    if (TextUtils.isEmpty(zzbxw.body)) {
      throw new zza("No fill from ad server.", 3);
    }
    zzu.zzft().zzc(mContext, zzbxw.zzcbd);
    if (zzbxw.zzccc) {}
    for (;;)
    {
      try
      {
        zzboi = new zzge(zzbxw.body);
        zzu.zzft().zzaf(zzboi.zzbnu);
        if ((TextUtils.isEmpty(zzbxw.zzcbv)) || (!((Boolean)zzdc.zzbdl.get()).booleanValue())) {
          break;
        }
        zzkh.zzcw("Received cookie from server. Setting webview cookie in CookieManager.");
        CookieManager localCookieManager = zzu.zzfs().zzao(mContext);
        if (localCookieManager == null) {
          break;
        }
        localCookieManager.setCookie("googleads.g.doubleclick.net", zzbxw.zzcbv);
        return;
      }
      catch (JSONException localJSONException)
      {
        zzkh.zzb("Could not parse mediation config.", localJSONException);
        str = String.valueOf(zzbxw.body);
        if (str.length() == 0) {}
      }
      for (String str = "Could not parse mediation config: ".concat(str);; str = new String("Could not parse mediation config: ")) {
        throw new zza(str, 0);
      }
      zzu.zzft().zzaf(zzbxw.zzbnu);
    }
  }
  
  @zzir
  static final class zza
    extends Exception
  {
    private final int zzbym;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzbym = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzbym;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */