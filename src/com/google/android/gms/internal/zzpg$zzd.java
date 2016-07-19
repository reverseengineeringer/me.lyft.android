package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzpg$zzd
  extends zzpg.zzc<Status>
{
  private final LogEventParcelable qI;
  
  zzpg$zzd(LogEventParcelable paramLogEventParcelable, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    qI = paramLogEventParcelable;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzd)) {
      return false;
    }
    paramObject = (zzd)paramObject;
    return qI.equals(qI);
  }
  
  public String toString()
  {
    String str = String.valueOf(qI);
    return String.valueOf(str).length() + 12 + "MethodImpl(" + str + ")";
  }
  
  protected void zza(zzph paramzzph)
    throws RemoteException
  {
    zzpj.zza local1 = new zzpj.zza()
    {
      public void zzw(Status paramAnonymousStatus)
      {
        zzc(paramAnonymousStatus);
      }
    };
    try
    {
      zzpg.zzb(qI);
      paramzzph.zza(local1, qI);
      return;
    }
    catch (RuntimeException paramzzph)
    {
      Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", paramzzph);
      zzz(new Status(10, "MessageProducer"));
    }
  }
  
  protected Status zzb(Status paramStatus)
  {
    return paramStatus;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpg.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */