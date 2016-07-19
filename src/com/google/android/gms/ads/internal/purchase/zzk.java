package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;

@zzir
public class zzk
{
  private final String zzawj;
  
  public zzk(String paramString)
  {
    zzawj = paramString;
  }
  
  public boolean zza(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = zzu.zzga().zze(paramIntent);
      paramIntent = zzu.zzga().zzf(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(zzu.zzga().zzbz(str)))
    {
      zzkh.zzcy("Developer payload not match.");
      return false;
    }
    if ((zzawj != null) && (!zzl.zzc(zzawj, str, paramIntent)))
    {
      zzkh.zzcy("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String zzpv()
  {
    return zzu.zzfq().zztg();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */