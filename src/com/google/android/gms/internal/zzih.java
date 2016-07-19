package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzih
  extends zzic
  implements zzlm.zza
{
  zzih(Context paramContext, zzjy.zza paramzza, zzll paramzzll, zzig.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzll, paramzza1);
  }
  
  protected void zzpx()
  {
    if (zzbxw.errorCode != -2) {
      return;
    }
    zzbgj.zzuk().zza(this);
    zzqe();
    zzkh.zzcw("Loading HTML in WebView.");
    zzbgj.loadDataWithBaseURL(zzu.zzfq().zzcp(zzbxw.zzbts), zzbxw.body, "text/html", "UTF-8", null);
  }
  
  protected void zzqe() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */