package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

@zzir
public class zzn
  extends zzj
{
  public zzi zza(Context paramContext, zzll paramzzll, int paramInt, boolean paramBoolean, zzdk paramzzdk, zzdi paramzzdi)
  {
    if (!zzq(paramContext)) {
      return null;
    }
    return new zzc(paramContext, paramBoolean, zzh(paramzzll), new zzx(paramContext, paramzzll.zzun(), paramzzll.getRequestId(), paramzzdk, paramzzdi));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */