package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class zzd$zzj
  extends zzd.zza
{
  public final IBinder xz;
  
  public zzd$zzj(zzd paramzzd, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramzzd, paramInt, paramBundle);
    xz = paramIBinder;
  }
  
  protected boolean zzarz()
  {
    do
    {
      try
      {
        String str1 = xz.getInterfaceDescriptor();
        if (!xv.zzrb().equals(str1))
        {
          String str2 = String.valueOf(xv.zzrb());
          Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localObject = xv.zzbb(xz);
    } while ((localObject == null) || (!zzd.zza(xv, 2, 3, (IInterface)localObject)));
    Object localObject = xv.zzamc();
    if (zzd.zzc(xv) != null) {
      zzd.zzc(xv).onConnected((Bundle)localObject);
    }
    return true;
  }
  
  protected void zzl(ConnectionResult paramConnectionResult)
  {
    if (zzd.zze(xv) != null) {
      zzd.zze(xv).onConnectionFailed(paramConnectionResult);
    }
    xv.onConnectionFailed(paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */