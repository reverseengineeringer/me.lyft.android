package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqf
  implements zzqm
{
  private final Context mContext;
  final Api.zza<? extends zzvx, zzvy> rY;
  final zzqd sX;
  final zzg tD;
  final Map<Api<?>, Integer> tE;
  final Map<Api.zzc<?>, Api.zze> tY;
  private final Lock th;
  private final zzc tp;
  private final Condition ul;
  private final zzb um;
  final Map<Api.zzc<?>, ConnectionResult> un = new HashMap();
  private volatile zzqe uo;
  private ConnectionResult up = null;
  int uq;
  final zzqm.zza ur;
  
  public zzqf(Context paramContext, zzqd paramzzqd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzvx, zzvy> paramzza, ArrayList<zzpu> paramArrayList, zzqm.zza paramzza1)
  {
    mContext = paramContext;
    th = paramLock;
    tp = paramzzc;
    tY = paramMap;
    tD = paramzzg;
    tE = paramMap1;
    rY = paramzza;
    sX = paramzzqd;
    ur = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzpu)paramContext.next()).zza(this);
    }
    um = new zzb(paramLooper);
    ul = paramLock.newCondition();
    uo = new zzqc(this);
  }
  
  public void connect()
  {
    uo.connect();
  }
  
  public void disconnect()
  {
    if (uo.disconnect()) {
      un.clear();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(uo);
    Iterator localIterator = tE.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zze)tY.get(localApi.zzanp())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public boolean isConnected()
  {
    return uo instanceof zzqa;
  }
  
  public boolean isConnecting()
  {
    return uo instanceof zzqb;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    th.lock();
    try
    {
      uo.onConnected(paramBundle);
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    th.lock();
    try
    {
      uo.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    th.lock();
    try
    {
      uo.zza(paramConnectionResult, paramApi, paramInt);
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  void zza(zza paramzza)
  {
    paramzza = um.obtainMessage(1, paramzza);
    um.sendMessage(paramzza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = um.obtainMessage(2, paramRuntimeException);
    um.sendMessage(paramRuntimeException);
  }
  
  public void zzaoy()
  {
    if (isConnected()) {
      ((zzqa)uo).zzaph();
    }
  }
  
  void zzapw()
  {
    th.lock();
    try
    {
      uo = new zzqb(this, tD, tE, tp, rY, th, mContext);
      uo.begin();
      ul.signalAll();
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  void zzapx()
  {
    th.lock();
    try
    {
      sX.zzapt();
      uo = new zzqa(this);
      uo.begin();
      ul.signalAll();
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  void zzapy()
  {
    Iterator localIterator = tY.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    paramT.zzaot();
    return uo.zzc(paramT);
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    paramT.zzaot();
    return uo.zzd(paramT);
  }
  
  void zzi(ConnectionResult paramConnectionResult)
  {
    th.lock();
    try
    {
      up = paramConnectionResult;
      uo = new zzqc(this);
      uo.begin();
      ul.signalAll();
      return;
    }
    finally
    {
      th.unlock();
    }
  }
  
  static abstract class zza
  {
    private final zzqe us;
    
    protected zza(zzqe paramzzqe)
    {
      us = paramzzqe;
    }
    
    protected abstract void zzapi();
    
    public final void zzd(zzqf paramzzqf)
    {
      zzqf.zzb(paramzzqf).lock();
      try
      {
        zzqe localzzqe1 = zzqf.zzc(paramzzqf);
        zzqe localzzqe2 = us;
        if (localzzqe1 != localzzqe2) {
          return;
        }
        zzapi();
        return;
      }
      finally
      {
        zzqf.zzb(paramzzqf).unlock();
      }
    }
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        int i = what;
        Log.w("GACStateManager", 31 + "Unknown message id: " + i);
        return;
      case 1: 
        ((zzqf.zza)obj).zzd(zzqf.this);
        return;
      }
      throw ((RuntimeException)obj);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */