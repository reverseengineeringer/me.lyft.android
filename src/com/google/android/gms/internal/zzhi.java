package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzir
public class zzhi
  extends zzhj
  implements zzet
{
  private final Context mContext;
  private final WindowManager zzaqk;
  private final zzll zzbgj;
  private final zzcu zzbrg;
  DisplayMetrics zzbrh;
  private float zzbri;
  int zzbrj = -1;
  int zzbrk = -1;
  private int zzbrl;
  int zzbrm = -1;
  int zzbrn = -1;
  int zzbro = -1;
  int zzbrp = -1;
  
  public zzhi(zzll paramzzll, Context paramContext, zzcu paramzzcu)
  {
    super(paramzzll);
    zzbgj = paramzzll;
    mContext = paramContext;
    zzbrg = paramzzcu;
    zzaqk = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void zznb()
  {
    zzbrh = new DisplayMetrics();
    Display localDisplay = zzaqk.getDefaultDisplay();
    localDisplay.getMetrics(zzbrh);
    zzbri = zzbrh.density;
    zzbrl = localDisplay.getRotation();
  }
  
  private void zzng()
  {
    int[] arrayOfInt = new int[2];
    zzbgj.getLocationOnScreen(arrayOfInt);
    zze(zzm.zziw().zzb(mContext, arrayOfInt[0]), zzm.zziw().zzb(mContext, arrayOfInt[1]));
  }
  
  private zzhh zznj()
  {
    return new zzhh.zza().zzu(zzbrg.zzjp()).zzt(zzbrg.zzjq()).zzv(zzbrg.zzju()).zzw(zzbrg.zzjr()).zzx(zzbrg.zzjs()).zzna();
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzne();
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    if ((mContext instanceof Activity)) {}
    for (int i = zzu.zzfq().zzk((Activity)mContext)[0];; i = 0)
    {
      zzc(paramInt1, paramInt2 - i, zzbro, zzbrp);
      zzbgj.zzuk().zzd(paramInt1, paramInt2);
      return;
    }
  }
  
  void zznc()
  {
    zzbrj = zzm.zziw().zzb(zzbrh, zzbrh.widthPixels);
    zzbrk = zzm.zziw().zzb(zzbrh, zzbrh.heightPixels);
    Object localObject = zzbgj.zzuf();
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      zzbrm = zzbrj;
      zzbrn = zzbrk;
      return;
    }
    localObject = zzu.zzfq().zzh((Activity)localObject);
    zzbrm = zzm.zziw().zzb(zzbrh, localObject[0]);
    zzbrn = zzm.zziw().zzb(zzbrh, localObject[1]);
  }
  
  void zznd()
  {
    if (zzbgj.zzdo().zzauq)
    {
      zzbro = zzbrj;
      zzbrp = zzbrk;
      return;
    }
    zzbgj.measure(0, 0);
    zzbro = zzm.zziw().zzb(mContext, zzbgj.getMeasuredWidth());
    zzbrp = zzm.zziw().zzb(mContext, zzbgj.getMeasuredHeight());
  }
  
  public void zzne()
  {
    zznb();
    zznc();
    zznd();
    zznh();
    zzni();
    zzng();
    zznf();
  }
  
  void zznf()
  {
    if (zzkh.zzaz(2)) {
      zzkh.zzcx("Dispatching Ready Event.");
    }
    zzbv(zzbgj.zzun().zzcs);
  }
  
  void zznh()
  {
    zza(zzbrj, zzbrk, zzbrm, zzbrn, zzbri, zzbrl);
  }
  
  void zzni()
  {
    zzhh localzzhh = zznj();
    zzbgj.zzb("onDeviceFeaturesReceived", localzzhh.toJson());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */