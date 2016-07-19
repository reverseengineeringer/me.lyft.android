package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbh
  extends zzbp
{
  public zzbh(zzax paramzzax, String paramString1, String paramString2, zzae.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzax, paramString1, paramString2, paramzza, paramInt1, paramInt2);
  }
  
  private void zzcw()
    throws IllegalAccessException, InvocationTargetException
  {
    synchronized (zzaha)
    {
      zzaha.zzeg = ((String)zzahh.invoke(null, new Object[] { zzaey.getContext() }));
      return;
    }
  }
  
  private void zzcx()
  {
    ??? = zzaey.zzcs();
    if (??? == null)
    {
      zzp("E1");
      return;
    }
    try
    {
      AdvertisingIdClient.Info localInfo = ((AdvertisingIdClient)???).getInfo();
      String str = zzay.zzo(localInfo.getId());
      if (str != null) {
        synchronized (zzaha)
        {
          zzaha.zzeg = str;
          zzaha.zzei = Boolean.valueOf(localInfo.isLimitAdTrackingEnabled());
          zzaha.zzeh = Integer.valueOf(5);
          return;
        }
      }
      zzp("E");
    }
    catch (IOException localIOException)
    {
      zzp("E");
      return;
    }
  }
  
  private void zzp(String paramString) {}
  
  protected void zzcv()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzaey.zzcj())
    {
      zzcx();
      return;
    }
    zzcw();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */