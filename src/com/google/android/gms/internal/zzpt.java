package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class zzpt<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> sI = new ThreadLocal()
  {
    protected Boolean zzaov()
    {
      return Boolean.valueOf(false);
    }
  };
  private final Object sJ = new Object();
  protected final zza<R> sK;
  protected final WeakReference<GoogleApiClient> sL;
  private final ArrayList<PendingResult.zza> sM = new ArrayList();
  private ResultCallback<? super R> sN;
  private zzb sO;
  private volatile boolean sP;
  private boolean sQ;
  private zzr sR;
  private volatile zzrc<R> sS;
  private boolean sT = false;
  private R sc;
  private boolean zzak;
  private final CountDownLatch zzalc = new CountDownLatch(1);
  
  @Deprecated
  zzpt()
  {
    sK = new zza(Looper.getMainLooper());
    sL = new WeakReference(null);
  }
  
  @Deprecated
  protected zzpt(Looper paramLooper)
  {
    sK = new zza(paramLooper);
    sL = new WeakReference(null);
  }
  
  protected zzpt(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      sK = new zza(localLooper);
      sL = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (sJ)
    {
      if (!sP)
      {
        zzab.zza(bool, "Result has already been consumed.");
        zzab.zza(isReady(), "Result is not ready.");
        Result localResult = sc;
        sc = null;
        sN = null;
        sP = true;
        zzaop();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzd(R paramR)
  {
    sc = paramR;
    sR = null;
    zzalc.countDown();
    paramR = sc.getStatus();
    if (zzak) {
      sN = null;
    }
    for (;;)
    {
      Iterator localIterator = sM.iterator();
      while (localIterator.hasNext()) {
        ((PendingResult.zza)localIterator.next()).zzv(paramR);
      }
      if (sN == null)
      {
        if ((sc instanceof Releasable)) {
          sO = new zzb(null);
        }
      }
      else
      {
        sK.zzaow();
        sK.zza(sN, get());
      }
    }
    sM.clear();
  }
  
  public static void zze(Result paramResult)
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
      Log.w("BasePendingResult", String.valueOf(paramResult).length() + 18 + "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzab.zza(bool1, "await must not be called on the UI thread");
      if (!sP)
      {
        bool1 = true;
        label28:
        zzab.zza(bool1, "Result has already been consumed");
        if (sS != null) {
          break label80;
        }
        bool1 = bool2;
        zzab.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        zzalc.await();
        zzab.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzaa(Status.sh);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (sJ)
    {
      if ((zzak) || (sP)) {
        return;
      }
      zzr localzzr = sR;
      if (localzzr == null) {}
    }
    try
    {
      sR.cancel();
      zze(sc);
      zzak = true;
      zzd(zzc(Status.sk));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (sJ)
    {
      boolean bool = zzak;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return zzalc.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    Object localObject = sJ;
    if (paramResultCallback == null) {}
    try
    {
      sN = null;
      return;
    }
    finally {}
    if (!sP)
    {
      bool1 = true;
      zzab.zza(bool1, "Result has already been consumed.");
      if (sS != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzab.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (isReady()) {
      sK.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      sN = paramResultCallback;
    }
  }
  
  public final void zza(PendingResult.zza paramzza)
  {
    boolean bool2 = true;
    if (!sP)
    {
      bool1 = true;
      zzab.zza(bool1, "Result has already been consumed.");
      if (paramzza == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzab.zzb(bool1, "Callback cannot be null.");
      synchronized (sJ)
      {
        if (isReady())
        {
          paramzza.zzv(sc.getStatus());
          return;
        }
        sM.add(paramzza);
      }
      bool1 = false;
      break;
    }
  }
  
  public final void zzaa(Status paramStatus)
  {
    synchronized (sJ)
    {
      if (!isReady())
      {
        zzc(zzc(paramStatus));
        sQ = true;
      }
      return;
    }
  }
  
  public Integer zzaog()
  {
    return null;
  }
  
  protected void zzaop() {}
  
  public boolean zzaos()
  {
    synchronized (sJ)
    {
      if (((GoogleApiClient)sL.get() == null) || (!sT)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public void zzaot()
  {
    if ((sT) || (((Boolean)sI.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      sT = bool;
      return;
    }
  }
  
  boolean zzaou()
  {
    return false;
  }
  
  protected abstract R zzc(Status paramStatus);
  
  public final void zzc(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (sJ)
      {
        if ((sQ) || (zzak) || ((isReady()) && (zzaou())))
        {
          zze(paramR);
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          zzab.zza(bool1, "Results have already been set");
          if (sP) {
            break label98;
          }
          bool1 = bool2;
          zzab.zza(bool1, "Result has already been consumed");
          zzd(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label98:
      bool1 = false;
    }
  }
  
  public static class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        int i = what;
        Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
        return;
      case 1: 
        paramMessage = (Pair)obj;
        zzb((ResultCallback)first, (Result)second);
        return;
      }
      ((zzpt)obj).zzaa(Status.sj);
    }
    
    public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void zzaow()
    {
      removeMessages(2);
    }
    
    protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        zzpt.zze(paramR);
        throw paramResultCallback;
      }
    }
  }
  
  private final class zzb
  {
    private zzb() {}
    
    protected void finalize()
      throws Throwable
    {
      zzpt.zze(zzpt.zza(zzpt.this));
      super.finalize();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */