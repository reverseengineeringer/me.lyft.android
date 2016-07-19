package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.util.Iterator;
import java.util.List;

@zzir
public class zze
{
  private final Context mContext;
  private final AutoClickProtectionConfigurationParcel zzakn;
  private boolean zzako;
  
  public zze(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public zze(Context paramContext, zzjy.zza paramzza)
  {
    mContext = paramContext;
    if ((paramzza != null) && (zzciu.zzccv != null))
    {
      zzakn = zzciu.zzccv;
      return;
    }
    zzakn = new AutoClickProtectionConfigurationParcel();
  }
  
  public zze(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext;
    zzakn = new AutoClickProtectionConfigurationParcel(paramBoolean);
  }
  
  public void recordClick()
  {
    zzako = true;
  }
  
  public boolean zzem()
  {
    return (!zzakn.zzccy) || (zzako);
  }
  
  public void zzt(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      zzkh.zzcx("Action was blocked because no touch was detected.");
      if ((!zzakn.zzccy) || (zzakn.zzccz == null)) {
        break;
      }
      Iterator localIterator = zzakn.zzccz.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
        {
          str = str.replace("{NAVIGATION_URL}", Uri.encode(paramString));
          zzu.zzfq().zzc(mContext, "", str);
        }
      }
      paramString = "";
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */