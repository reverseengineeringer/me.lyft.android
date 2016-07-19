package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public class AdSizeParcel
  extends AbstractSafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  public final String zzaup;
  public final boolean zzauq;
  public final AdSizeParcel[] zzaur;
  public final boolean zzaus;
  public final boolean zzaut;
  public boolean zzauu;
  
  public AdSizeParcel()
  {
    this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  AdSizeParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    versionCode = paramInt1;
    zzaup = paramString;
    height = paramInt2;
    heightPixels = paramInt3;
    zzauq = paramBoolean1;
    width = paramInt4;
    widthPixels = paramInt5;
    zzaur = paramArrayOfAdSizeParcel;
    zzaus = paramBoolean2;
    zzaut = paramBoolean3;
    zzauu = paramBoolean4;
  }
  
  public AdSizeParcel(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public AdSizeParcel(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    versionCode = 5;
    zzauq = false;
    zzaut = localAdSize.isFluid();
    int j;
    label66:
    int k;
    label78:
    DisplayMetrics localDisplayMetrics;
    label129:
    int m;
    int i;
    if (zzaut)
    {
      width = AdSize.BANNER.getWidth();
      height = AdSize.BANNER.getHeight();
      if (width != -1) {
        break label314;
      }
      j = 1;
      if (height != -2) {
        break label320;
      }
      k = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (j == 0) {
        break label338;
      }
      if ((!zzm.zziw().zzas(paramContext)) || (!zzm.zziw().zzat(paramContext))) {
        break label326;
      }
      widthPixels = (zza(localDisplayMetrics) - zzm.zziw().zzau(paramContext));
      double d = widthPixels / density;
      m = (int)d;
      i = m;
      if (d - (int)d >= 0.01D) {
        i = m + 1;
      }
      label168:
      if (k == 0) {
        break label363;
      }
      m = zzc(localDisplayMetrics);
      label180:
      heightPixels = zzm.zziw().zza(localDisplayMetrics, m);
      if ((j == 0) && (k == 0)) {
        break label372;
      }
      zzaup = (26 + i + "x" + m + "_as");
    }
    for (;;)
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label400;
      }
      zzaur = new AdSizeParcel[paramArrayOfAdSize.length];
      i = 0;
      while (i < paramArrayOfAdSize.length)
      {
        zzaur[i] = new AdSizeParcel(paramContext, paramArrayOfAdSize[i]);
        i += 1;
      }
      width = localAdSize.getWidth();
      height = localAdSize.getHeight();
      break;
      label314:
      j = 0;
      break label66;
      label320:
      k = 0;
      break label78;
      label326:
      widthPixels = zza(localDisplayMetrics);
      break label129;
      label338:
      i = width;
      widthPixels = zzm.zziw().zza(localDisplayMetrics, width);
      break label168;
      label363:
      m = height;
      break label180;
      label372:
      if (zzaut) {
        zzaup = "320x50_mb";
      } else {
        zzaup = localAdSize.toString();
      }
    }
    label400:
    zzaur = null;
    zzaus = false;
    zzauu = false;
  }
  
  public AdSizeParcel(AdSizeParcel paramAdSizeParcel, AdSizeParcel[] paramArrayOfAdSizeParcel)
  {
    this(5, zzaup, height, heightPixels, zzauq, width, widthPixels, paramArrayOfAdSizeParcel, zzaus, zzaut, zzauu);
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics)
  {
    return widthPixels;
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzc(paramDisplayMetrics) * density);
  }
  
  private static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(heightPixels / density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public static AdSizeParcel zzii()
  {
    return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  public static AdSizeParcel zzk(Context paramContext)
  {
    return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public AdSize zzij()
  {
    return com.google.android.gms.ads.zza.zza(width, height, zzaup);
  }
  
  public void zzk(boolean paramBoolean)
  {
    zzauu = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdSizeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */