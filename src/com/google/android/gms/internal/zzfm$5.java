package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzp.zza;
import java.util.List;

class zzfm$5
  extends zzp.zza
{
  zzfm$5(zzfm paramzzfm) {}
  
  public void onAdClicked()
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbko != null) {
          zzbko.onAdClicked();
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */