package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzir
public class zzci
  extends zzcd
{
  private final zzfx zzarn;
  
  public zzci(Context paramContext, AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, VersionInfoParcel paramVersionInfoParcel, zzck paramzzck, zzfx paramzzfx)
  {
    super(paramContext, paramAdSizeParcel, paramzzjy, paramVersionInfoParcel, paramzzck);
    zzarn = paramzzfx;
    zzc(zzarn);
    zzgw();
    zzk(3);
    paramContext = String.valueOf(zzaqi.zzhn());
    if (paramContext.length() != 0) {}
    for (paramContext = "Tracking ad unit: ".concat(paramContext);; paramContext = new String("Tracking ad unit: "))
    {
      zzkh.zzcw(paramContext);
      return;
    }
  }
  
  protected void destroy()
  {
    synchronized (zzail)
    {
      super.destroy();
      zzd(zzarn);
      return;
    }
  }
  
  protected void zzb(JSONObject paramJSONObject)
  {
    zzarn.zza("AFMA_updateActiveView", paramJSONObject);
  }
  
  public void zzgy()
  {
    destroy();
  }
  
  protected boolean zzhe()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */