package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

@zzir
public final class zzhx
  extends zzhs.zza
{
  private final InAppPurchaseListener zzawf;
  
  public zzhx(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzawf = paramInAppPurchaseListener;
  }
  
  public void zza(zzhr paramzzhr)
  {
    zzawf.onInAppPurchaseRequested(new zzia(paramzzhr));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */