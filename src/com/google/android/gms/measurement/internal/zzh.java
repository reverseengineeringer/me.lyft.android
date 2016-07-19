package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.Set;

public class zzh
{
  final String ajW;
  final long ajX;
  final EventParams ajY;
  final String mName;
  final long pz;
  final String zzcjj;
  
  zzh(zzx paramzzx, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    zzab.zzhs(paramString2);
    zzab.zzhs(paramString3);
    zzcjj = paramString2;
    mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    ajW = paramString2;
    pz = paramLong1;
    ajX = paramLong2;
    if ((ajX != 0L) && (ajX > pz)) {
      paramzzx.zzbsz().zzbtt().log("Event created with reverse previous/current timestamps");
    }
    ajY = zza(paramzzx, paramBundle);
  }
  
  private zzh(zzx paramzzx, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, EventParams paramEventParams)
  {
    zzab.zzhs(paramString2);
    zzab.zzhs(paramString3);
    zzab.zzaa(paramEventParams);
    zzcjj = paramString2;
    mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    ajW = paramString2;
    pz = paramLong1;
    ajX = paramLong2;
    if ((ajX != 0L) && (ajX > pz)) {
      paramzzx.zzbsz().zzbtt().log("Event created with reverse previous/current timestamps");
    }
    ajY = paramEventParams;
  }
  
  public String toString()
  {
    String str1 = zzcjj;
    String str2 = mName;
    String str3 = String.valueOf(ajY);
    return String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Event{appId='" + str1 + "'" + ", name='" + str2 + "'" + ", params=" + str3 + "}";
  }
  
  EventParams zza(zzx paramzzx, Bundle paramBundle)
  {
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str == null)
        {
          paramzzx.zzbsz().zzbtr().log("Param name can't be null");
          localIterator.remove();
        }
        else
        {
          Object localObject = paramzzx.zzbsv().zzl(str, paramBundle.get(str));
          if (localObject == null)
          {
            paramzzx.zzbsz().zzbtt().zzj("Param value can't be null", str);
            localIterator.remove();
          }
          else
          {
            paramzzx.zzbsv().zza(paramBundle, str, localObject);
          }
        }
      }
      return new EventParams(paramBundle);
    }
    return new EventParams(new Bundle());
  }
  
  zzh zza(zzx paramzzx, long paramLong)
  {
    return new zzh(paramzzx, ajW, zzcjj, mName, pz, paramLong, ajY);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */