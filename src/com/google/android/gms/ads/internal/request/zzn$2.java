package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfw.zzc;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzle.zza;
import com.google.android.gms.internal.zzle.zzc;
import org.json.JSONObject;

class zzn$2
  implements Runnable
{
  zzn$2(zzn paramzzn, JSONObject paramJSONObject, String paramString) {}
  
  public void run()
  {
    zzn.zza(zzcdp, zzn.zzre().zzmc());
    zzn.zzb(zzcdp).zza(new zzle.zzc()new zzle.zza
    {
      public void zzb(zzfx paramAnonymouszzfx)
      {
        try
        {
          paramAnonymouszzfx.zza("AFMA_getAdapterLessMediationAd", zzcdq);
          return;
        }
        catch (Exception paramAnonymouszzfx)
        {
          zzkh.zzb("Error requesting an ad url", paramAnonymouszzfx);
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */