package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

final class zzn$zza
{
  private final String yE;
  private final ComponentName yF;
  private final String zzcvf;
  
  public zzn$zza(String paramString1, String paramString2)
  {
    zzcvf = zzab.zzhs(paramString1);
    yE = zzab.zzhs(paramString2);
    yF = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
    } while ((zzaa.equal(zzcvf, zzcvf)) && (zzaa.equal(yF, yF)));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { zzcvf, yF });
  }
  
  public String toString()
  {
    if (zzcvf == null) {
      return yF.flattenToString();
    }
    return zzcvf;
  }
  
  public Intent zzasu()
  {
    if (zzcvf != null) {
      return new Intent(zzcvf).setPackage(yE);
    }
    return new Intent().setComponent(yF);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzn.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */