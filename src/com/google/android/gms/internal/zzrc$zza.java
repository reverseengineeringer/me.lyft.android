package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzrc$zza
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      int i = what;
      Log.e("TransformedResultImpl", 70 + "TransformationResultHandler received unknown message type: " + i);
      return;
    case 0: 
      PendingResult localPendingResult1 = (PendingResult)obj;
      paramMessage = zzrc.zzf(vs);
      if (localPendingResult1 == null) {}
      for (;;)
      {
        try
        {
          zzrc.zza(zzrc.zzg(vs), new Status(13, "Transform returned null"));
          return;
        }
        finally {}
        if ((localPendingResult2 instanceof zzqx)) {
          zzrc.zza(zzrc.zzg(vs), ((zzqx)localPendingResult2).getStatus());
        } else {
          zzrc.zzg(vs).zza(localPendingResult2);
        }
      }
    }
    RuntimeException localRuntimeException = (RuntimeException)obj;
    paramMessage = String.valueOf(localRuntimeException.getMessage());
    if (paramMessage.length() != 0) {}
    for (paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);; paramMessage = new String("Runtime exception on the transformation worker thread: "))
    {
      Log.e("TransformedResultImpl", paramMessage);
      throw localRuntimeException;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrc.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */