package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzcj
  extends zzcd
{
  private zzfw.zzc zzaro;
  private boolean zzarp;
  
  public zzcj(final Context paramContext, AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, VersionInfoParcel paramVersionInfoParcel, zzck paramzzck, zzfw paramzzfw)
  {
    super(paramContext, paramAdSizeParcel, paramzzjy, paramVersionInfoParcel, paramzzck);
    zzaro = paramzzfw.zzmc();
    try
    {
      paramContext = zzd(paramzzck.zzhj().zzhh());
      zzaro.zza(new zzle.zzc()new zzle.zza
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          zza(paramContext);
        }
      }, new zzle.zza()
      {
        public void run() {}
      });
      zzaro.zza(new zzle.zzc()new zzle.zza
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          zzcj.zza(zzcj.this, true);
          zzc(paramAnonymouszzfx);
          zzgw();
          zzk(3);
        }
      }, new zzle.zza()
      {
        public void run()
        {
          destroy();
        }
      });
      paramContext = String.valueOf(zzaqi.zzhn());
      if (paramContext.length() != 0)
      {
        paramContext = "Tracking ad unit: ".concat(paramContext);
        zzkh.zzcw(paramContext);
        return;
      }
    }
    catch (RuntimeException paramContext)
    {
      for (;;)
      {
        zzkh.zzb("Failure while processing active view data.", paramContext);
        continue;
        paramContext = new String("Tracking ad unit: ");
      }
    }
    catch (JSONException paramContext)
    {
      for (;;) {}
    }
  }
  
  protected void destroy()
  {
    synchronized (zzail)
    {
      super.destroy();
      zzaro.zza(new zzle.zzc()new zzle.zzb
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          zzd(paramAnonymouszzfx);
        }
      }, new zzle.zzb());
      zzaro.release();
      return;
    }
  }
  
  protected void zzb(final JSONObject paramJSONObject)
  {
    zzaro.zza(new zzle.zzc()new zzle.zzb
    {
      public void zzb(zzfx paramAnonymouszzfx)
      {
        paramAnonymouszzfx.zza("AFMA_updateActiveView", paramJSONObject);
      }
    }, new zzle.zzb());
  }
  
  protected boolean zzhe()
  {
    return zzarp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */