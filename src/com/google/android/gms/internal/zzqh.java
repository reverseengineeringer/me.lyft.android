package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzqh
  implements Handler.Callback
{
  private static zzqh uw;
  private static final Object zzamp = new Object();
  private final Context mContext;
  private final Handler mHandler;
  private final GoogleApiAvailability rX;
  private long tU;
  private long tV;
  private final Map<zzpo<?>, zzc<?>> uA;
  private zzpw uB;
  private final Set<zzpo<?>> uC;
  private final ReferenceQueue<zzc<?>> uD;
  private final SparseArray<zza> uE;
  private zzb uF;
  private long uv;
  private int ux;
  private final SparseArray<zzc<?>> uz;
  
  private void zza(zzc<?> paramzzc, int paramInt)
  {
    Object localObject = paramzzc.zzany();
    if (!uA.containsKey(localObject)) {
      uA.put(localObject, new zzc(paramzzc));
    }
    localObject = (zzc)uA.get(localObject);
    ((zzc)localObject).zzfk(paramInt);
    uz.put(paramInt, localObject);
    zzc.zza((zzc)localObject);
    uE.put(paramInt, new zza(paramzzc, paramInt, uD));
    if ((uF == null) || (!zzb.zza(uF).get()))
    {
      uF = new zzb(uD, uE);
      uF.start();
    }
  }
  
  private void zza(zzpn paramzzpn)
  {
    ((zzc)uz.get(sn)).zzb(paramzzpn);
  }
  
  public static zzqh zzaqa()
  {
    synchronized (zzamp)
    {
      zzqh localzzqh = uw;
      return localzzqh;
    }
  }
  
  private void zzaqb()
  {
    Iterator localIterator = uA.values().iterator();
    while (localIterator.hasNext())
    {
      zzc localzzc = (zzc)localIterator.next();
      localzzc.zzaqf();
      zzc.zza(localzzc);
    }
  }
  
  private void zze(int paramInt, boolean paramBoolean)
  {
    zzc localzzc = (zzc)uz.get(paramInt);
    if (localzzc != null)
    {
      if (!paramBoolean) {
        uz.delete(paramInt);
      }
      localzzc.zzf(paramInt, paramBoolean);
      return;
    }
    Log.wtf("GoogleApiManager", 52 + "onRelease received for unknown instance: " + paramInt, new Exception());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    int i;
    switch (what)
    {
    default: 
      i = what;
      Log.w("GoogleApiManager", 31 + "Unknown message id: " + i);
      return false;
    case 1: 
      zza((zzpq)obj);
    }
    for (;;)
    {
      return true;
      zza((zzc)obj, arg1);
      continue;
      zzaqb();
      continue;
      i = arg1;
      if (arg2 == 1) {
        bool = true;
      }
      zze(i, bool);
      continue;
      zza((zzpn)obj);
      continue;
      if (uz.get(arg1) != null)
      {
        zzc.zza((zzc)uz.get(arg1), new Status(17, "Error resolution was canceled by the user."));
        continue;
        if (uA.containsKey(obj))
        {
          zzc.zzb((zzc)uA.get(obj));
          continue;
          if (uA.containsKey(obj))
          {
            zzc.zzc((zzc)uA.get(obj));
            continue;
            if (uA.containsKey(obj)) {
              zzc.zzd((zzc)uA.get(obj));
            }
          }
        }
      }
    }
  }
  
  public void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zzc(paramConnectionResult, paramInt)) {
      mHandler.sendMessage(mHandler.obtainMessage(5, paramInt, 0));
    }
  }
  
  public void zza(zzpq paramzzpq)
  {
    Iterator localIterator = paramzzpq.zzaon().iterator();
    for (;;)
    {
      zzpo localzzpo;
      zzc localzzc;
      if (localIterator.hasNext())
      {
        localzzpo = (zzpo)localIterator.next();
        localzzc = (zzc)uA.get(localzzpo);
        if (localzzc == null) {
          paramzzpq.cancel();
        }
      }
      else
      {
        return;
      }
      if (localzzc.isConnected()) {
        paramzzpq.zza(localzzpo, ConnectionResult.qR);
      } else if (localzzc.zzaqg() != null) {
        paramzzpq.zza(localzzpo, localzzc.zzaqg());
      } else {
        localzzc.zzb(paramzzpq);
      }
    }
  }
  
  public void zza(zzpw paramzzpw)
  {
    Object localObject = zzamp;
    if (paramzzpw == null) {}
    try
    {
      uB = null;
      uC.clear();
      return;
    }
    finally {}
  }
  
  public void zzaol()
  {
    mHandler.sendMessage(mHandler.obtainMessage(3));
  }
  
  boolean zzc(ConnectionResult paramConnectionResult, int paramInt)
  {
    if ((paramConnectionResult.hasResolution()) || (rX.isUserResolvableError(paramConnectionResult.getErrorCode())))
    {
      rX.zza(mContext, paramConnectionResult, paramInt);
      return true;
    }
    return false;
  }
  
  public void zzd(int paramInt, boolean paramBoolean)
  {
    Handler localHandler1 = mHandler;
    Handler localHandler2 = mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(7, paramInt, i));
      return;
    }
  }
  
  private final class zza
    extends PhantomReference<zzc<?>>
  {
    private final int sn;
    
    public zza(int paramInt, ReferenceQueue<zzc<?>> paramReferenceQueue)
    {
      super(localReferenceQueue);
      sn = paramReferenceQueue;
    }
    
    public void zzaqd()
    {
      zzqh.zza(zzqh.this).sendMessage(zzqh.zza(zzqh.this).obtainMessage(2, sn, 2));
    }
  }
  
  private static final class zzb
    extends Thread
  {
    private final ReferenceQueue<zzc<?>> uD;
    private final SparseArray<zzqh.zza> uE;
    private final AtomicBoolean uH = new AtomicBoolean();
    
    public zzb(ReferenceQueue<zzc<?>> paramReferenceQueue, SparseArray<zzqh.zza> paramSparseArray)
    {
      super();
      uD = paramReferenceQueue;
      uE = paramSparseArray;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   4: iconst_1
      //   5: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   8: bipush 10
      //   10: invokestatic 51	android/os/Process:setThreadPriority	(I)V
      //   13: aload_0
      //   14: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   17: invokevirtual 55	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   20: ifeq +42 -> 62
      //   23: aload_0
      //   24: getfield 31	com/google/android/gms/internal/zzqh$zzb:uD	Ljava/lang/ref/ReferenceQueue;
      //   27: invokevirtual 61	java/lang/ref/ReferenceQueue:remove	()Ljava/lang/ref/Reference;
      //   30: checkcast 63	com/google/android/gms/internal/zzqh$zza
      //   33: astore_1
      //   34: aload_0
      //   35: getfield 33	com/google/android/gms/internal/zzqh$zzb:uE	Landroid/util/SparseArray;
      //   38: aload_1
      //   39: invokestatic 66	com/google/android/gms/internal/zzqh$zza:zza	(Lcom/google/android/gms/internal/zzqh$zza;)I
      //   42: invokevirtual 70	android/util/SparseArray:remove	(I)V
      //   45: aload_1
      //   46: invokevirtual 73	com/google/android/gms/internal/zzqh$zza:zzaqd	()V
      //   49: goto -36 -> 13
      //   52: astore_1
      //   53: aload_0
      //   54: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   57: iconst_0
      //   58: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   61: return
      //   62: aload_0
      //   63: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   66: iconst_0
      //   67: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   70: return
      //   71: astore_1
      //   72: aload_0
      //   73: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   76: iconst_0
      //   77: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	zzb
      //   33	13	1	localzza	zzqh.zza
      //   52	1	1	localInterruptedException	InterruptedException
      //   71	10	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   13	49	52	java/lang/InterruptedException
      //   13	49	71	finally
    }
  }
  
  private class zzc<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private final zzpo<O> rG;
    private boolean tT;
    private final Queue<zzpn> uI = new LinkedList();
    private final Api.zze uJ;
    private final Api.zzb uK;
    private final SparseArray<zzrd> uL = new SparseArray();
    private final Set<zzpq> uM = new HashSet();
    private final SparseArray<Map<Object, zzpr.zza>> uN = new SparseArray();
    private ConnectionResult uO = null;
    
    public zzc()
    {
      zzc localzzc;
      uJ = zzb(localzzc);
      if ((uJ instanceof zzah)) {}
      for (uK = ((zzah)uJ).zzatj();; uK = uJ)
      {
        rG = localzzc.zzany();
        return;
      }
    }
    
    private void connect()
    {
      if ((uJ.isConnected()) || (uJ.isConnecting())) {
        return;
      }
      if ((uJ.zzanr()) && (zzqh.zzk(zzqh.this) != 0))
      {
        zzqh.zza(zzqh.this, zzqh.zzi(zzqh.this).isGooglePlayServicesAvailable(zzqh.zzh(zzqh.this)));
        if (zzqh.zzk(zzqh.this) != 0)
        {
          onConnectionFailed(new ConnectionResult(zzqh.zzk(zzqh.this), null));
          return;
        }
      }
      uJ.zza(new zzqh.zzd(zzqh.this, uJ, rG));
    }
    
    private void resume()
    {
      if (tT) {
        connect();
      }
    }
    
    private void zzab(Status paramStatus)
    {
      Iterator localIterator = uI.iterator();
      while (localIterator.hasNext()) {
        ((zzpn)localIterator.next()).zzx(paramStatus);
      }
      uI.clear();
    }
    
    private void zzapr()
    {
      if (tT)
      {
        zzaqh();
        if (zzqh.zzi(zzqh.this).isGooglePlayServicesAvailable(zzqh.zzh(zzqh.this)) != 18) {
          break label60;
        }
      }
      label60:
      for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
      {
        zzab(localStatus);
        uJ.disconnect();
        return;
      }
    }
    
    private void zzaqh()
    {
      if (tT)
      {
        zzqh.zza(zzqh.this).removeMessages(9, rG);
        zzqh.zza(zzqh.this).removeMessages(8, rG);
        tT = false;
      }
    }
    
    private void zzaqi()
    {
      zzqh.zza(zzqh.this).removeMessages(10, rG);
      zzqh.zza(zzqh.this).sendMessageDelayed(zzqh.zza(zzqh.this).obtainMessage(10, rG), zzqh.zzj(zzqh.this));
    }
    
    private void zzaqj()
    {
      int i;
      if ((uJ.isConnected()) && (uN.size() == 0)) {
        i = 0;
      }
      while (i < uL.size())
      {
        if (((zzrd)uL.get(uL.keyAt(i))).zzaqw())
        {
          zzaqi();
          return;
        }
        i += 1;
      }
      uJ.disconnect();
    }
    
    private Api.zze zzb(zzc paramzzc)
    {
      Object localObject = paramzzc.zzanw();
      if (((Api)localObject).zzanq())
      {
        localObject = ((Api)localObject).zzano();
        return new zzah(paramzzc.getApplicationContext(), zzqh.zza(zzqh.this).getLooper(), ((Api.zzh)localObject).zzant(), this, this, zzg.zzcd(paramzzc.getApplicationContext()), ((Api.zzh)localObject).zzs(paramzzc.zzanx()));
      }
      return paramzzc.zzanw().zzann().zza(paramzzc.getApplicationContext(), zzqh.zza(zzqh.this).getLooper(), zzg.zzcd(paramzzc.getApplicationContext()), paramzzc.zzanx(), this, this);
    }
    
    private void zzc(zzpn paramzzpn)
    {
      paramzzpn.zza(uL);
      if (it == 3) {}
      label197:
      for (;;)
      {
        try
        {
          localObject1 = (Map)uN.get(sn);
          if (localObject1 != null) {
            break label197;
          }
          localObject1 = new ArrayMap(1);
          uN.put(sn, localObject1);
          localObject2 = so;
          ((Map)localObject1).put(((zzqr)localObject2).zzaqq(), localObject2);
          if (it != 4) {
            continue;
          }
        }
        catch (ClassCastException paramzzpn)
        {
          try
          {
            paramzzpn.zzb(uK);
            return;
          }
          catch (DeadObjectException paramzzpn)
          {
            Object localObject1;
            Object localObject2;
            uJ.disconnect();
            onConnectionSuspended(1);
            return;
          }
          paramzzpn = paramzzpn;
          throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
        }
        try
        {
          localObject1 = (Map)uN.get(sn);
          localObject2 = (zzqr)so;
          if (localObject1 != null) {
            ((Map)localObject1).remove(((zzqr)localObject2).zzaqq());
          }
        }
        catch (ClassCastException paramzzpn)
        {
          throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
        }
        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
      }
    }
    
    private void zzj(ConnectionResult paramConnectionResult)
    {
      Iterator localIterator = uM.iterator();
      while (localIterator.hasNext()) {
        ((zzpq)localIterator.next()).zza(rG, paramConnectionResult);
      }
      uM.clear();
    }
    
    boolean isConnected()
    {
      return uJ.isConnected();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      zzaqf();
      zzj(ConnectionResult.qR);
      zzaqh();
      int i = 0;
      while (i < uN.size())
      {
        paramBundle = ((Map)uN.get(uN.keyAt(i))).values().iterator();
        while (paramBundle.hasNext())
        {
          zzpr.zza localzza = (zzpr.zza)paramBundle.next();
          try
          {
            localzza.zzb(uK);
          }
          catch (DeadObjectException localDeadObjectException)
          {
            uJ.disconnect();
            onConnectionSuspended(1);
          }
        }
        i += 1;
      }
      zzaqe();
      zzaqi();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzaqf();
      zzqh.zza(zzqh.this, -1);
      zzj(paramConnectionResult);
      int i = uL.keyAt(0);
      if (uI.isEmpty()) {
        uO = paramConnectionResult;
      }
      do
      {
        return;
        synchronized (zzqh.zzaqc())
        {
          if ((zzqh.zzd(zzqh.this) != null) && (zzqh.zze(zzqh.this).contains(rG)))
          {
            zzqh.zzd(zzqh.this).zzb(paramConnectionResult, i);
            return;
          }
        }
      } while (zzc(paramConnectionResult, i));
      if (paramConnectionResult.getErrorCode() == 18) {
        tT = true;
      }
      if (tT)
      {
        zzqh.zza(zzqh.this).sendMessageDelayed(Message.obtain(zzqh.zza(zzqh.this), 8, rG), zzqh.zzb(zzqh.this));
        return;
      }
      paramConnectionResult = String.valueOf(rG.zzaok());
      zzab(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzaqf();
      tT = true;
      zzqh.zza(zzqh.this).sendMessageDelayed(Message.obtain(zzqh.zza(zzqh.this), 8, rG), zzqh.zzb(zzqh.this));
      zzqh.zza(zzqh.this).sendMessageDelayed(Message.obtain(zzqh.zza(zzqh.this), 9, rG), zzqh.zzc(zzqh.this));
      zzqh.zza(zzqh.this, -1);
    }
    
    public void zzaqe()
    {
      while ((uJ.isConnected()) && (!uI.isEmpty())) {
        zzc((zzpn)uI.remove());
      }
    }
    
    public void zzaqf()
    {
      uO = null;
    }
    
    ConnectionResult zzaqg()
    {
      return uO;
    }
    
    public void zzb(zzpn paramzzpn)
    {
      if (uJ.isConnected())
      {
        zzc(paramzzpn);
        zzaqi();
        return;
      }
      uI.add(paramzzpn);
      if ((uO != null) && (uO.hasResolution()))
      {
        onConnectionFailed(uO);
        return;
      }
      connect();
    }
    
    public void zzb(zzpq paramzzpq)
    {
      uM.add(paramzzpq);
    }
    
    public void zzf(int paramInt, boolean paramBoolean)
    {
      ??? = uI.iterator();
      while (((Iterator)???).hasNext())
      {
        zzpn localzzpn = (zzpn)((Iterator)???).next();
        if ((sn == paramInt) && (it != 1) && (localzzpn.cancel())) {
          ((Iterator)???).remove();
        }
      }
      ((zzrd)uL.get(paramInt)).release();
      uN.delete(paramInt);
      if (!paramBoolean)
      {
        uL.remove(paramInt);
        zzqh.zzf(zzqh.this).remove(paramInt);
        if ((uL.size() == 0) && (uI.isEmpty()))
        {
          zzaqh();
          uJ.disconnect();
          zzqh.zzg(zzqh.this).remove(rG);
          synchronized (zzqh.zzaqc())
          {
            zzqh.zze(zzqh.this).remove(rG);
            return;
          }
        }
      }
    }
    
    public void zzfk(int paramInt)
    {
      uL.put(paramInt, new zzrd(rG.zzanp(), uJ));
    }
  }
  
  private class zzd
    implements zzd.zzf
  {
    private final zzpo<?> rG;
    private final Api.zze uJ;
    
    public zzd(zzpo<?> paramzzpo)
    {
      uJ = paramzzpo;
      zzpo localzzpo;
      rG = localzzpo;
    }
    
    public void zzh(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
      {
        uJ.zza(null, Collections.emptySet());
        return;
      }
      ((zzqh.zzc)zzqh.zzg(zzqh.this).get(rG)).onConnectionFailed(paramConnectionResult);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */