package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.Iterator;
import java.util.List;

class zzkl$1
  implements zzdq.zza
{
  zzkl$1(zzkl paramzzkl, List paramList, zzdq paramzzdq, Context paramContext) {}
  
  public void zzkn()
  {
    Iterator localIterator = zzclj.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = String.valueOf(str);
      if (((String)localObject).length() != 0) {}
      for (localObject = "Pinging url: ".concat((String)localObject);; localObject = new String("Pinging url: "))
      {
        zzkh.zzcx((String)localObject);
        localObject = Uri.parse(str);
        zzclk.mayLaunchUrl((Uri)localObject, null, null);
        break;
      }
    }
    zzclk.zzd((Activity)zzaky);
  }
  
  public void zzko() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */