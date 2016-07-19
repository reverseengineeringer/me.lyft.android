package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzw.zza;
import java.util.List;

class zzfm$2
  extends zzw.zza
{
  zzfm$2(zzfm paramzzfm) {}
  
  public void onAppEvent(final String paramString1, final String paramString2)
    throws RemoteException
  {
    zzfm.zza(zzbjx).add(new zzfm.zza()
    {
      public void zzb(zzfn paramAnonymouszzfn)
        throws RemoteException
      {
        if (zzbkl != null) {
          zzbkl.onAppEvent(paramString1, paramString2);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfm.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */