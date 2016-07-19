package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzir
public class zzdk
{
  private final Object zzail = new Object();
  boolean zzbdm;
  private final List<zzdi> zzbed = new LinkedList();
  private final Map<String, String> zzbee = new LinkedHashMap();
  private String zzbef;
  private zzdi zzbeg;
  private zzdk zzbeh;
  
  public zzdk(boolean paramBoolean, String paramString1, String paramString2)
  {
    zzbdm = paramBoolean;
    zzbee.put("action", paramString1);
    zzbee.put("ad_format", paramString2);
  }
  
  public boolean zza(zzdi paramzzdi, long paramLong, String... paramVarArgs)
  {
    synchronized (zzail)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        zzdi localzzdi = new zzdi(paramLong, paramVarArgs[i], paramzzdi);
        zzbed.add(localzzdi);
        i += 1;
      }
      return true;
    }
  }
  
  public boolean zza(zzdi paramzzdi, String... paramVarArgs)
  {
    if ((!zzbdm) || (paramzzdi == null)) {
      return false;
    }
    return zza(paramzzdi, zzu.zzfu().elapsedRealtime(), paramVarArgs);
  }
  
  public void zzas(String paramString)
  {
    if (!zzbdm) {
      return;
    }
    synchronized (zzail)
    {
      zzbef = paramString;
      return;
    }
  }
  
  public zzdi zzc(long paramLong)
  {
    if (!zzbdm) {
      return null;
    }
    return new zzdi(paramLong, null, null);
  }
  
  public void zzc(zzdk paramzzdk)
  {
    synchronized (zzail)
    {
      zzbeh = paramzzdk;
      return;
    }
  }
  
  public void zzh(String paramString1, String paramString2)
  {
    if ((!zzbdm) || (TextUtils.isEmpty(paramString2))) {}
    zzde localzzde;
    do
    {
      return;
      localzzde = zzu.zzft().zzsm();
    } while (localzzde == null);
    synchronized (zzail)
    {
      localzzde.zzaq(paramString1).zza(zzbee, paramString1, paramString2);
      return;
    }
  }
  
  public zzdi zzkg()
  {
    return zzc(zzu.zzfu().elapsedRealtime());
  }
  
  public void zzkh()
  {
    synchronized (zzail)
    {
      zzbeg = zzkg();
      return;
    }
  }
  
  public String zzki()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (zzail)
    {
      Iterator localIterator = zzbed.iterator();
      while (localIterator.hasNext())
      {
        zzdi localzzdi = (zzdi)localIterator.next();
        long l1 = localzzdi.getTime();
        String str2 = localzzdi.zzkd();
        localzzdi = localzzdi.zzke();
        if ((localzzdi != null) && (l1 > 0L))
        {
          long l2 = localzzdi.getTime();
          localStringBuilder.append(str2).append('.').append(l1 - l2).append(',');
        }
      }
    }
    zzbed.clear();
    if (!TextUtils.isEmpty(zzbef)) {
      ((StringBuilder)localObject2).append(zzbef);
    }
    for (;;)
    {
      String str1 = ((StringBuilder)localObject2).toString();
      return str1;
      if (str1.length() > 0) {
        str1.setLength(str1.length() - 1);
      }
    }
  }
  
  public zzdi zzkj()
  {
    synchronized (zzail)
    {
      zzdi localzzdi = zzbeg;
      return localzzdi;
    }
  }
  
  Map<String, String> zzm()
  {
    synchronized (zzail)
    {
      Object localObject2 = zzu.zzft().zzsm();
      if ((localObject2 == null) || (zzbeh == null))
      {
        localObject2 = zzbee;
        return (Map<String, String>)localObject2;
      }
      localObject2 = ((zzde)localObject2).zza(zzbee, zzbeh.zzm());
      return (Map<String, String>)localObject2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */