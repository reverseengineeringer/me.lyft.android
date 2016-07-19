package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkq.zza;
import com.google.android.gms.internal.zzkq.zzb;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@zzir
public class zzx
{
  private final Context mContext;
  private final VersionInfoParcel zzamu;
  private final String zzbvu;
  private final zzdi zzbvv;
  private final zzdk zzbvw;
  private final zzkq zzbvx = new zzkq.zzb().zza("min_1", Double.MIN_VALUE, 1.0D).zza("1_5", 1.0D, 5.0D).zza("5_10", 5.0D, 10.0D).zza("10_20", 10.0D, 20.0D).zza("20_30", 20.0D, 30.0D).zza("30_max", 30.0D, Double.MAX_VALUE).zztp();
  private final long[] zzbvy;
  private final String[] zzbvz;
  private zzdi zzbwa;
  private zzdi zzbwb;
  private zzdi zzbwc;
  private zzdi zzbwd;
  private boolean zzbwe;
  private zzi zzbwf;
  private boolean zzbwg;
  private boolean zzbwh;
  private long zzbwi = -1L;
  
  public zzx(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzdk paramzzdk, zzdi paramzzdi)
  {
    mContext = paramContext;
    zzamu = paramVersionInfoParcel;
    zzbvu = paramString;
    zzbvw = paramzzdk;
    zzbvv = paramzzdi;
    paramContext = (String)zzdc.zzayr.get();
    if (paramContext == null)
    {
      zzbvz = new String[0];
      zzbvy = new long[0];
      return;
    }
    paramContext = TextUtils.split(paramContext, ",");
    zzbvz = new String[paramContext.length];
    zzbvy = new long[paramContext.length];
    int i = 0;
    while (i < paramContext.length) {
      try
      {
        zzbvy[i] = Long.parseLong(paramContext[i]);
        i += 1;
      }
      catch (NumberFormatException paramVersionInfoParcel)
      {
        for (;;)
        {
          zzkh.zzd("Unable to parse frame hash target time number.", paramVersionInfoParcel);
          zzbvy[i] = -1L;
        }
      }
    }
  }
  
  private void zzc(zzi paramzzi)
  {
    long l1 = ((Long)zzdc.zzays.get()).longValue();
    long l2 = paramzzi.getCurrentPosition();
    int i = 0;
    if (i < zzbvz.length)
    {
      if (zzbvz[i] != null) {}
      while (l1 <= Math.abs(l2 - zzbvy[i]))
      {
        i += 1;
        break;
      }
      zzbvz[i] = zza(paramzzi);
    }
  }
  
  private void zzpj()
  {
    if ((zzbwc != null) && (zzbwd == null))
    {
      zzdg.zza(zzbvw, zzbwc, new String[] { "vff" });
      zzdg.zza(zzbvw, zzbvv, new String[] { "vtt" });
      zzbwd = zzdg.zzb(zzbvw);
    }
    long l = zzu.zzfu().nanoTime();
    if ((zzbwe) && (zzbwh) && (zzbwi != -1L))
    {
      double d = TimeUnit.SECONDS.toNanos(1L) / (l - zzbwi);
      zzbvx.zza(d);
    }
    zzbwh = zzbwe;
    zzbwi = l;
  }
  
  public void onStop()
  {
    if ((((Boolean)zzdc.zzayq.get()).booleanValue()) && (!zzbwg))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", zzbvu);
      localBundle.putString("player", zzbwf.zznk());
      Object localObject1 = zzbvx.getBuckets().iterator();
      Object localObject2;
      String str1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzkq.zza)((Iterator)localObject1).next();
        str1 = String.valueOf("fps_c_");
        String str2 = String.valueOf(name);
        if (str2.length() != 0)
        {
          str1 = str1.concat(str2);
          label129:
          localBundle.putString(str1, Integer.toString(count));
          str1 = String.valueOf("fps_p_");
          str2 = String.valueOf(name);
          if (str2.length() == 0) {
            break label202;
          }
        }
        label202:
        for (str1 = str1.concat(str2);; str1 = new String(str1))
        {
          localBundle.putString(str1, Double.toString(zzcmc));
          break;
          str1 = new String(str1);
          break label129;
        }
      }
      int i = 0;
      if (i < zzbvy.length)
      {
        str1 = zzbvz[i];
        if (str1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject1 = String.valueOf("fh_");
          localObject2 = String.valueOf(Long.valueOf(zzbvy[i]));
          localBundle.putString(String.valueOf(localObject1).length() + 0 + String.valueOf(localObject2).length() + (String)localObject1 + (String)localObject2, str1);
        }
      }
      zzu.zzfq().zza(mContext, zzamu.zzcs, "gmob-apps", localBundle, true);
      zzbwg = true;
    }
  }
  
  String zza(TextureView paramTextureView)
  {
    paramTextureView = paramTextureView.getBitmap(8, 8);
    long l2 = 0L;
    long l1 = 63L;
    int i = 0;
    while (i < 8)
    {
      long l3 = l1;
      int j = 0;
      l1 = l2;
      l2 = l3;
      if (j < 8)
      {
        int k = paramTextureView.getPixel(j, i);
        int m = Color.blue(k);
        int n = Color.red(k);
        if (Color.green(k) + (m + n) > 128) {}
        for (l3 = 1L;; l3 = 0L)
        {
          l1 |= l3 << (int)l2;
          l2 -= 1L;
          j += 1;
          break;
        }
      }
      i += 1;
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
    return String.format("%016X", new Object[] { Long.valueOf(l2) });
  }
  
  public void zza(zzi paramzzi)
  {
    zzdg.zza(zzbvw, zzbvv, new String[] { "vpc" });
    zzbwa = zzdg.zzb(zzbvw);
    if (zzbvw != null) {
      zzbvw.zzh("vpn", paramzzi.zznk());
    }
    zzbwf = paramzzi;
  }
  
  public void zzb(zzi paramzzi)
  {
    zzpj();
    zzc(paramzzi);
  }
  
  public void zzol()
  {
    if ((zzbwa == null) || (zzbwb != null)) {
      return;
    }
    zzdg.zza(zzbvw, zzbwa, new String[] { "vfr" });
    zzbwb = zzdg.zzb(zzbvw);
  }
  
  public void zzpk()
  {
    zzbwe = true;
    if ((zzbwb != null) && (zzbwc == null))
    {
      zzdg.zza(zzbvw, zzbwb, new String[] { "vfp" });
      zzbwc = zzdg.zzb(zzbvw);
    }
  }
  
  public void zzpl()
  {
    zzbwe = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */