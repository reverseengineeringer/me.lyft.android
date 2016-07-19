package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzu;

class zzfm$1$1
  implements zzfm.zza
{
  zzfm$1$1(zzfm.1 param1) {}
  
  public void zzb(zzfn paramzzfn)
    throws RemoteException
  {
    if (zzald != null) {
      zzald.onAdClosed();
    }
    zzu.zzgb().zzlq();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */