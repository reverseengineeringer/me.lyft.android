package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zzd$zza
  extends zzd.zze<Boolean>
{
  public final int statusCode;
  public final Bundle xu;
  
  protected zzd$zza(zzd paramzzd, int paramInt, Bundle paramBundle)
  {
    super(paramzzd, Boolean.valueOf(true));
    statusCode = paramInt;
    xu = paramBundle;
  }
  
  protected abstract boolean zzarz();
  
  protected void zzasa() {}
  
  protected void zzc(Boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean == null) {
      zzd.zza(xv, 1, null);
    }
    do
    {
      return;
      switch (statusCode)
      {
      default: 
        zzd.zza(xv, 1, null);
        paramBoolean = (Boolean)localObject;
        if (xu != null) {
          paramBoolean = (PendingIntent)xu.getParcelable("pendingIntent");
        }
        zzl(new ConnectionResult(statusCode, paramBoolean));
        return;
      }
    } while (zzarz());
    zzd.zza(xv, 1, null);
    zzl(new ConnectionResult(8, null));
    return;
    zzd.zza(xv, 1, null);
    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
  }
  
  protected abstract void zzl(ConnectionResult paramConnectionResult);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */