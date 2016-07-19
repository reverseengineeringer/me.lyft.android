package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzc;
import com.google.android.gms.ads.internal.zzu;

@zzir
public final class zzku
  extends zzkg
{
  private final String zzae;
  private final zzc zzcmv;
  
  public zzku(Context paramContext, String paramString1, String paramString2)
  {
    this(paramString2, zzu.zzfq().zzh(paramContext, paramString1));
  }
  
  public zzku(String paramString1, String paramString2)
  {
    zzcmv = new zzc(paramString2);
    zzae = paramString1;
  }
  
  public void onStop() {}
  
  public void zzew()
  {
    zzcmv.zzcs(zzae);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzku
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */