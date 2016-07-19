package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzln
{
  public zzll zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzas paramzzas, VersionInfoParcel paramVersionInfoParcel)
  {
    return zza(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzas, paramVersionInfoParcel, null, null, null);
  }
  
  public zzll zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzas paramzzas, VersionInfoParcel paramVersionInfoParcel, zzdk paramzzdk, zzs paramzzs, zzd paramzzd)
  {
    paramContext = new zzlo(zzlp.zzb(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzas, paramVersionInfoParcel, paramzzdk, paramzzs, paramzzd));
    paramContext.setWebViewClient(zzu.zzfs().zzb(paramContext, paramBoolean2));
    paramContext.setWebChromeClient(zzu.zzfs().zzl(paramContext));
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzln
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */