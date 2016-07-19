package com.google.android.gms.internal;

import android.os.RemoteException;

class zzgl$1
  implements Runnable
{
  zzgl$1(zzgl paramzzgl, zzgi paramzzgi) {}
  
  public void run()
  {
    try
    {
      zzbpi.zzbos.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not destroy mediation adapter.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */