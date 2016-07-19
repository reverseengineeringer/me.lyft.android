package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

@zzir
public class zzie
  extends zzic
{
  private zzid zzbyk;
  
  zzie(Context paramContext, zzjy.zza paramzza, zzll paramzzll, zzig.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzll, paramzza1);
  }
  
  protected void zzpx()
  {
    Object localObject = zzbgj.zzdo();
    int j;
    if (zzauq)
    {
      localObject = mContext.getResources().getDisplayMetrics();
      j = widthPixels;
    }
    for (int i = heightPixels;; i = heightPixels)
    {
      zzbyk = new zzid(this, zzbgj, j, i);
      zzbgj.zzuk().zza(this);
      zzbyk.zza(zzbxw);
      return;
      j = widthPixels;
    }
  }
  
  protected int zzpy()
  {
    if (zzbyk.zzqc())
    {
      zzkh.zzcw("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!zzbyk.zzqd()) {
      return 2;
    }
    return -2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */