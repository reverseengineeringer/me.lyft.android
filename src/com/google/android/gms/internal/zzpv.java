package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class zzpv
  implements zzqm
{
  private final Context mContext;
  private final zzqd sX;
  private final zzqf sY;
  private final zzqf sZ;
  private final Map<Api.zzc<?>, zzqf> ta;
  private final Set<zzqy> tb = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zze tc;
  private Bundle td;
  private ConnectionResult te = null;
  private ConnectionResult tf = null;
  private boolean tg = false;
  private final Lock th;
  private int ti = 0;
  private final Looper zzahv;
  
  private zzpv(Context paramContext, zzqd paramzzqd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap1, Map<Api.zzc<?>, Api.zze> paramMap2, zzg paramzzg, Api.zza<? extends zzvx, zzvy> paramzza, Api.zze paramzze, ArrayList<zzpu> paramArrayList1, ArrayList<zzpu> paramArrayList2, Map<Api<?>, Integer> paramMap3, Map<Api<?>, Integer> paramMap4)
  {
    mContext = paramContext;
    sX = paramzzqd;
    th = paramLock;
    zzahv = paramLooper;
    tc = paramzze;
    sY = new zzqf(paramContext, sX, paramLock, paramLooper, paramzzc, paramMap2, null, paramMap4, null, paramArrayList2, new zza(null));
    sZ = new zzqf(paramContext, sX, paramLock, paramLooper, paramzzc, paramMap1, paramzzg, paramMap3, paramzza, paramArrayList1, new zzb(null));
    paramContext = new ArrayMap();
    paramzzqd = paramMap2.keySet().iterator();
    while (paramzzqd.hasNext()) {
      paramContext.put((Api.zzc)paramzzqd.next(), sY);
    }
    paramzzqd = paramMap1.keySet().iterator();
    while (paramzzqd.hasNext()) {
      paramContext.put((Api.zzc)paramzzqd.next(), sZ);
    }
    ta = Collections.unmodifiableMap(paramContext);
  }
  
  public static zzpv zza(Context paramContext, zzqd paramzzqd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzvx, zzvy> paramzza, ArrayList<zzpu> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzafz()) {
        paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
      }
      if (((Api.zze)localObject1).zzafk()) {
        localArrayMap1.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap2.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    boolean bool;
    if (!localArrayMap1.isEmpty())
    {
      bool = true;
      zzab.zza(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new ArrayMap();
      localObject2 = new ArrayMap();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Api)((Iterator)localObject3).next();
        Api.zzc localzzc = ((Api)localObject4).zzanp();
        if (localArrayMap1.containsKey(localzzc))
        {
          ((Map)localObject1).put(localObject4, (Integer)paramMap1.get(localObject4));
          continue;
          bool = false;
          break;
        }
        if (localArrayMap2.containsKey(localzzc)) {
          ((Map)localObject2).put(localObject4, (Integer)paramMap1.get(localObject4));
        } else {
          throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject4 = (zzpu)paramArrayList.next();
      if (((Map)localObject1).containsKey(pD)) {
        paramMap1.add(localObject4);
      } else if (((Map)localObject2).containsKey(pD)) {
        ((ArrayList)localObject3).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    return new zzpv(paramContext, paramzzqd, paramLock, paramLooper, paramzzc, localArrayMap1, localArrayMap2, paramzzg, paramzza, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  private void zzapa()
  {
    tf = null;
    te = null;
    sY.connect();
    sZ.connect();
  }
  
  private void zzapb()
  {
    if (zzc(te)) {
      if ((zzc(tf)) || (zzape())) {
        zzapc();
      }
    }
    do
    {
      do
      {
        return;
      } while (tf == null);
      if (ti == 1)
      {
        zzapd();
        return;
      }
      zzb(tf);
      sY.disconnect();
      return;
      if ((te != null) && (zzc(tf)))
      {
        sZ.disconnect();
        zzb(te);
        return;
      }
    } while ((te == null) || (tf == null));
    ConnectionResult localConnectionResult = te;
    if (sZ.uq < sY.uq) {
      localConnectionResult = tf;
    }
    zzb(localConnectionResult);
  }
  
  private void zzapc()
  {
    switch (ti)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
    }
    for (;;)
    {
      ti = 0;
      return;
      sX.zzm(td);
      zzapd();
    }
  }
  
  private void zzapd()
  {
    Iterator localIterator = tb.iterator();
    while (localIterator.hasNext()) {
      ((zzqy)localIterator.next()).zzafy();
    }
    tb.clear();
  }
  
  private boolean zzape()
  {
    return (tf != null) && (tf.getErrorCode() == 4);
  }
  
  private PendingIntent zzapf()
  {
    if (tc == null) {
      return null;
    }
    return PendingIntent.getActivity(mContext, sX.getSessionId(), tc.zzaga(), 134217728);
  }
  
  private void zzb(int paramInt, boolean paramBoolean)
  {
    sX.zzc(paramInt, paramBoolean);
    tf = null;
    te = null;
  }
  
  private void zzb(ConnectionResult paramConnectionResult)
  {
    switch (ti)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      ti = 0;
      return;
      sX.zzd(paramConnectionResult);
      zzapd();
    }
  }
  
  private static boolean zzc(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private boolean zze(zzpr.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = paramzza.zzanp();
    zzab.zzb(ta.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzqf)ta.get(paramzza)).equals(sZ);
  }
  
  private void zzl(Bundle paramBundle)
  {
    if (td == null) {
      td = paramBundle;
    }
    while (paramBundle == null) {
      return;
    }
    td.putAll(paramBundle);
  }
  
  public void connect()
  {
    ti = 2;
    tg = false;
    zzapa();
  }
  
  public void disconnect()
  {
    tf = null;
    te = null;
    ti = 0;
    sY.disconnect();
    sZ.disconnect();
    zzapd();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    sZ.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    sY.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 367 1 0
    //   11: aload_0
    //   12: getfield 86	com/google/android/gms/internal/zzpv:sY	Lcom/google/android/gms/internal/zzqf;
    //   15: invokevirtual 369	com/google/android/gms/internal/zzqf:isConnected	()Z
    //   18: ifeq +44 -> 62
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 372	com/google/android/gms/internal/zzpv:zzaoz	()Z
    //   27: ifne +24 -> 51
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: invokespecial 225	com/google/android/gms/internal/zzpv:zzape	()Z
    //   36: ifne +15 -> 51
    //   39: aload_0
    //   40: getfield 66	com/google/android/gms/internal/zzpv:ti	I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +16 -> 62
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 375 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -13 -> 51
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 375 1 0
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzpv
    //   43	4	1	i	int
    //   22	42	2	bool1	boolean
    //   1	49	3	bool2	boolean
    //   67	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	67	finally
    //   23	30	67	finally
    //   32	44	67	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 367 1 0
    //   9: aload_0
    //   10: getfield 66	com/google/android/gms/internal/zzpv:ti	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 375 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 72	com/google/android/gms/internal/zzpv:th	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 375 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zzpv
    //   13	4	1	i	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  public void zzaoy()
  {
    sY.zzaoy();
    sZ.zzaoy();
  }
  
  public boolean zzaoz()
  {
    return sZ.isConnected();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    if (zze(paramT))
    {
      if (zzape())
      {
        paramT.zzz(new Status(4, null, zzapf()));
        return paramT;
      }
      return sZ.zzc(paramT);
    }
    return sY.zzc(paramT);
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    if (zze(paramT))
    {
      if (zzape())
      {
        paramT.zzz(new Status(4, null, zzapf()));
        return paramT;
      }
      return sZ.zzd(paramT);
    }
    return sY.zzd(paramT);
  }
  
  private class zza
    implements zzqm.zza
  {
    private zza() {}
    
    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        if ((zzpv.zzc(zzpv.this)) || (zzpv.zzd(zzpv.this) == null) || (!zzpv.zzd(zzpv.this).isSuccess()))
        {
          zzpv.zza(zzpv.this, false);
          zzpv.zza(zzpv.this, paramInt, paramBoolean);
          return;
        }
        zzpv.zza(zzpv.this, true);
        zzpv.zze(zzpv.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
    
    public void zzd(ConnectionResult paramConnectionResult)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        zzpv.zza(zzpv.this, paramConnectionResult);
        zzpv.zzb(zzpv.this);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
    
    public void zzm(Bundle paramBundle)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        zzpv.zza(zzpv.this, paramBundle);
        zzpv.zza(zzpv.this, ConnectionResult.qR);
        zzpv.zzb(zzpv.this);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
  }
  
  private class zzb
    implements zzqm.zza
  {
    private zzb() {}
    
    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        if (zzpv.zzc(zzpv.this))
        {
          zzpv.zza(zzpv.this, false);
          zzpv.zza(zzpv.this, paramInt, paramBoolean);
          return;
        }
        zzpv.zza(zzpv.this, true);
        zzpv.zzf(zzpv.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
    
    public void zzd(ConnectionResult paramConnectionResult)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        zzpv.zzb(zzpv.this, paramConnectionResult);
        zzpv.zzb(zzpv.this);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
    
    public void zzm(Bundle paramBundle)
    {
      zzpv.zza(zzpv.this).lock();
      try
      {
        zzpv.zzb(zzpv.this, ConnectionResult.qR);
        zzpv.zzb(zzpv.this);
        return;
      }
      finally
      {
        zzpv.zza(zzpv.this).unlock();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */