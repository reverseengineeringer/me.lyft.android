package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

@zzir
public abstract class zzj
{
  public abstract zzi zza(Context paramContext, zzll paramzzll, int paramInt, boolean paramBoolean, zzdk paramzzdk, zzdi paramzzdi);
  
  protected boolean zzh(zzll paramzzll)
  {
    return zzdozzauq;
  }
  
  protected boolean zzq(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    return (zzs.zzavm()) && ((paramContext == null) || (targetSdkVersion >= 11));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */