package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.Map;

@zzir
public class zzdd
{
  private Context mContext = null;
  private String zzarh = null;
  private boolean zzbdm;
  private String zzbdn;
  private Map<String, String> zzbdo;
  
  public zzdd(Context paramContext, String paramString)
  {
    mContext = paramContext;
    zzarh = paramString;
    zzbdm = ((Boolean)zzdc.zzazc.get()).booleanValue();
    zzbdn = ((String)zzdc.zzazd.get());
    zzbdo = new LinkedHashMap();
    zzbdo.put("s", "gmob_sdk");
    zzbdo.put("v", "3");
    zzbdo.put("os", Build.VERSION.RELEASE);
    zzbdo.put("sdk", Build.VERSION.SDK);
    zzbdo.put("device", zzu.zzfq().zzth());
    Map localMap = zzbdo;
    if (paramContext.getApplicationContext() != null)
    {
      paramString = paramContext.getApplicationContext().getPackageName();
      localMap.put("app", paramString);
      paramString = zzbdo;
      if (!zzu.zzfq().zzan(paramContext)) {
        break label256;
      }
    }
    label256:
    for (paramContext = "1";; paramContext = "0")
    {
      paramString.put("is_lite_sdk", paramContext);
      paramContext = zzu.zzfw().zzy(mContext);
      zzbdo.put("network_coarse", Integer.toString(zzcgt));
      zzbdo.put("network_fine", Integer.toString(zzcgu));
      return;
      paramString = paramContext.getPackageName();
      break;
    }
  }
  
  Context getContext()
  {
    return mContext;
  }
  
  String zzhl()
  {
    return zzarh;
  }
  
  boolean zzjz()
  {
    return zzbdm;
  }
  
  String zzka()
  {
    return zzbdn;
  }
  
  Map<String, String> zzkb()
  {
    return zzbdo;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */