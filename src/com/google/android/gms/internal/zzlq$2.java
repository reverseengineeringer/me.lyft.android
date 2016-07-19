package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzac;

class zzlq$2
  implements Runnable
{
  zzlq$2(zzlq paramzzlq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    label48:
    label62:
    label77:
    label141:
    label146:
    label151:
    label157:
    label162:
    label287:
    for (boolean bool = false;; bool = true)
    {
      int j;
      int k;
      int m;
      synchronized (zzlq.zzc(zzcqi))
      {
        int i;
        if (zzcqj != zzcqk)
        {
          j = 1;
          if ((zzlq.zzd(zzcqi)) || (zzcqk != 1)) {
            break label141;
          }
          i = 1;
          if ((j == 0) || (zzcqk != 1)) {
            break label146;
          }
          k = 1;
          if ((j == 0) || (zzcqk != 2)) {
            break label151;
          }
          m = 1;
          if ((j == 0) || (zzcqk != 3)) {
            break label157;
          }
        }
        for (j = 1;; j = 0)
        {
          zzlq localzzlq = zzcqi;
          if ((zzlq.zzd(zzcqi)) || (i != 0)) {
            break label287;
          }
          zzlq.zza(localzzlq, bool);
          if (zzlq.zze(zzcqi) != null) {
            break label162;
          }
          return;
          j = 0;
          break;
          i = 0;
          break label48;
          k = 0;
          break label62;
          m = 0;
          break label77;
        }
        if (i == 0) {}
      }
      try
      {
        zzlq.zze(zzcqi).zzjb();
        if (k == 0) {}
      }
      catch (RemoteException localRemoteException3)
      {
        try
        {
          zzlq.zze(zzcqi).zzjc();
          if (m == 0) {}
        }
        catch (RemoteException localRemoteException3)
        {
          try
          {
            zzlq.zze(zzcqi).zzjd();
            if (j == 0) {}
          }
          catch (RemoteException localRemoteException3)
          {
            try
            {
              for (;;)
              {
                zzlq.zze(zzcqi).onVideoEnd();
                return;
                localObject2 = finally;
                throw ((Throwable)localObject2);
                localRemoteException1 = localRemoteException1;
                zzkh.zzd("Unable to call onVideoStart()", localRemoteException1);
                continue;
                localRemoteException2 = localRemoteException2;
                zzkh.zzd("Unable to call onVideoPlay()", localRemoteException2);
              }
              localRemoteException3 = localRemoteException3;
              zzkh.zzd("Unable to call onVideoPause()", localRemoteException3);
            }
            catch (RemoteException localRemoteException4)
            {
              for (;;)
              {
                zzkh.zzd("Unable to call onVideoEnd()", localRemoteException4);
              }
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlq.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */