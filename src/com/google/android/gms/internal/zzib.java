package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@zzir
public final class zzib
  extends zzhw.zza
{
  private final PlayStorePurchaseListener zzawh;
  
  public zzib(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    zzawh = paramPlayStorePurchaseListener;
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return zzawh.isValidPurchase(paramString);
  }
  
  public void zza(zzhv paramzzhv)
  {
    zzawh.onInAppPurchaseFinished(new zzhz(paramzzhv));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzib
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */