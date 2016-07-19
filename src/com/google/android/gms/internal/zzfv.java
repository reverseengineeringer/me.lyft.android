package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONObject;

@zzir
public class zzfv
  implements zzft
{
  private final zzll zzbgj;
  
  public zzfv(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzas paramzzas)
  {
    zzbgj = zzu.zzfr().zza(paramContext, new AdSizeParcel(), false, false, paramzzas, paramVersionInfoParcel);
    zzbgj.getWebView().setWillNotDraw(true);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    if (zzm.zziw().zzty())
    {
      paramRunnable.run();
      return;
    }
    zzkl.zzclg.post(paramRunnable);
  }
  
  public void destroy()
  {
    zzbgj.destroy();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zza paramzza, zzg paramzzg, zzeo paramzzeo, zzp paramzzp, boolean paramBoolean, zzev paramzzev, zzex paramzzex, zze paramzze, zzhk paramzzhk)
  {
    zzbgj.zzuk().zza(paramzza, paramzzg, paramzzeo, paramzzp, paramBoolean, paramzzev, paramzzex, new zze(zzbgj.getContext(), false), paramzzhk, null);
  }
  
  public void zza(final zzft.zza paramzza)
  {
    zzbgj.zzuk().zza(new zzlm.zza()
    {
      public void zza(zzll paramAnonymouszzll, boolean paramAnonymousBoolean)
      {
        paramzza.zzmb();
      }
    });
  }
  
  public void zza(String paramString, zzet paramzzet)
  {
    zzbgj.zzuk().zza(paramString, paramzzet);
  }
  
  public void zza(final String paramString, final JSONObject paramJSONObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfv.zza(zzfv.this).zza(paramString, paramJSONObject);
      }
    });
  }
  
  public void zzb(String paramString, zzet paramzzet)
  {
    zzbgj.zzuk().zzb(paramString, paramzzet);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzbgj.zzb(paramString, paramJSONObject);
  }
  
  public void zzbh(String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfv.zza(zzfv.this).loadData(zzblt, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzbi(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfv.zza(zzfv.this).loadUrl(paramString);
      }
    });
  }
  
  public void zzbj(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfv.zza(zzfv.this).loadData(paramString, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzj(final String paramString1, final String paramString2)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfv.zza(zzfv.this).zzj(paramString1, paramString2);
      }
    });
  }
  
  public zzfy zzma()
  {
    return new zzfz(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */