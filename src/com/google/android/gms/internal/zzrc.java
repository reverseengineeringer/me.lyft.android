package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class zzrc<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object sJ;
  private final WeakReference<GoogleApiClient> sL;
  private ResultTransform<? super R, ? extends Result> vk;
  private zzrc<? extends Result> vl;
  private volatile ResultCallbacks<? super R> vm;
  private PendingResult<R> vn;
  private Status vo;
  private final zza vp;
  private boolean vq;
  
  private void zzac(Status paramStatus)
  {
    synchronized (sJ)
    {
      vo = paramStatus;
      zzad(vo);
      return;
    }
  }
  
  private void zzad(Status paramStatus)
  {
    synchronized (sJ)
    {
      if (vk != null)
      {
        paramStatus = vk.onFailure(paramStatus);
        zzab.zzb(paramStatus, "onFailure must not return null");
        vl.zzac(paramStatus);
      }
      while (!zzaqu()) {
        return;
      }
      vm.onFailure(paramStatus);
    }
  }
  
  private void zzaqs()
  {
    if ((vk == null) && (vm == null)) {}
    do
    {
      return;
      GoogleApiClient localGoogleApiClient = (GoogleApiClient)sL.get();
      if ((!vq) && (vk != null) && (localGoogleApiClient != null))
      {
        localGoogleApiClient.zza(this);
        vq = true;
      }
      if (vo != null)
      {
        zzad(vo);
        return;
      }
    } while (vn == null);
    vn.setResultCallback(this);
  }
  
  private boolean zzaqu()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)sL.get();
    return (vm != null) && (localGoogleApiClient != null);
  }
  
  private void zze(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResult = String.valueOf(paramResult);
      Log.w("TransformedResultImpl", String.valueOf(paramResult).length() + 18 + "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public void onResult(final R paramR)
  {
    for (;;)
    {
      synchronized (sJ)
      {
        if (paramR.getStatus().isSuccess())
        {
          if (vk != null)
          {
            zzqw.zzapz().submit(new Runnable()
            {
              public void run()
              {
                try
                {
                  zzpt.sI.set(Boolean.valueOf(true));
                  Object localObject1 = zzrc.zzc(zzrc.this).onSuccess(paramR);
                  zzrc.zzd(zzrc.this).sendMessage(zzrc.zzd(zzrc.this).obtainMessage(0, localObject1));
                  zzpt.sI.set(Boolean.valueOf(false));
                  zzrc.zza(zzrc.this, paramR);
                  localObject1 = (GoogleApiClient)zzrc.zze(zzrc.this).get();
                  if (localObject1 != null) {
                    ((GoogleApiClient)localObject1).zzb(zzrc.this);
                  }
                  return;
                }
                catch (RuntimeException localRuntimeException)
                {
                  zzrc.zzd(zzrc.this).sendMessage(zzrc.zzd(zzrc.this).obtainMessage(1, localRuntimeException));
                  GoogleApiClient localGoogleApiClient1;
                  return;
                }
                finally
                {
                  zzpt.sI.set(Boolean.valueOf(false));
                  zzrc.zza(zzrc.this, paramR);
                  GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzrc.zze(zzrc.this).get();
                  if (localGoogleApiClient2 != null) {
                    localGoogleApiClient2.zzb(zzrc.this);
                  }
                }
              }
            });
            return;
          }
          if (!zzaqu()) {
            continue;
          }
          vm.onSuccess(paramR);
        }
      }
      zzac(paramR.getStatus());
      zze(paramR);
    }
  }
  
  public void zza(PendingResult<?> paramPendingResult)
  {
    synchronized (sJ)
    {
      vn = paramPendingResult;
      zzaqs();
      return;
    }
  }
  
  void zzaqt()
  {
    vm = null;
  }
  
  private final class zza
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */