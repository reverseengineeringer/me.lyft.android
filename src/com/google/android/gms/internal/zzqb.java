package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzc;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzqb
  implements zzqe
{
  private final Context mContext;
  private final Api.zza<? extends zzvx, zzvy> rY;
  private zzq tA;
  private boolean tB;
  private boolean tC;
  private final zzg tD;
  private final Map<Api<?>, Integer> tE;
  private ArrayList<Future<?>> tF = new ArrayList();
  private final Lock th;
  private final zzqf tm;
  private final zzc tp;
  private ConnectionResult tq;
  private int tr;
  private int ts = 0;
  private int tt;
  private final Bundle tu = new Bundle();
  private final Set<Api.zzc> tv = new HashSet();
  private zzvx tw;
  private int tx;
  private boolean ty;
  private boolean tz;
  
  public zzqb(zzqf paramzzqf, zzg paramzzg, Map<Api<?>, Integer> paramMap, zzc paramzzc, Api.zza<? extends zzvx, zzvy> paramzza, Lock paramLock, Context paramContext)
  {
    tm = paramzzqf;
    tD = paramzzg;
    tE = paramMap;
    tp = paramzzc;
    rY = paramzza;
    th = paramLock;
    mContext = paramContext;
  }
  
  private void zza(SignInResponse paramSignInResponse)
  {
    if (!zzfg(0)) {
      return;
    }
    Object localObject = paramSignInResponse.zzatd();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramSignInResponse.zzbzv();
      paramSignInResponse = ((ResolveAccountResponse)localObject).zzatd();
      if (!paramSignInResponse.isSuccess())
      {
        localObject = String.valueOf(paramSignInResponse);
        Log.wtf("GoogleApiClientConnecting", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zzg(paramSignInResponse);
        return;
      }
      tz = true;
      tA = ((ResolveAccountResponse)localObject).zzatc();
      tB = ((ResolveAccountResponse)localObject).zzate();
      tC = ((ResolveAccountResponse)localObject).zzatf();
      zzapk();
      return;
    }
    if (zzf((ConnectionResult)localObject))
    {
      zzapn();
      zzapk();
      return;
    }
    zzg((ConnectionResult)localObject);
  }
  
  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zze(paramConnectionResult))) {}
    while ((tq != null) && (paramInt1 >= tr)) {
      return false;
    }
    return true;
  }
  
  private boolean zzapj()
  {
    tt -= 1;
    if (tt > 0) {
      return false;
    }
    if (tt < 0)
    {
      Log.i("GoogleApiClientConnecting", tm.sX.zzapv());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzg(new ConnectionResult(8, null));
      return false;
    }
    if (tq != null)
    {
      tm.uq = tr;
      zzg(tq);
      return false;
    }
    return true;
  }
  
  private void zzapk()
  {
    if (tt != 0) {}
    while ((ty) && (!tz)) {
      return;
    }
    zzapl();
  }
  
  private void zzapl()
  {
    ArrayList localArrayList = new ArrayList();
    ts = 1;
    tt = tm.tY.size();
    Iterator localIterator = tm.tY.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (tm.un.containsKey(localzzc))
      {
        if (zzapj()) {
          zzapm();
        }
      }
      else {
        localArrayList.add((Api.zze)tm.tY.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      tF.add(zzqg.zzapz().submit(new zzc(localArrayList)));
    }
  }
  
  private void zzapm()
  {
    tm.zzapx();
    zzqg.zzapz().execute(new Runnable()
    {
      public void run()
      {
        zzqb.zzb(zzqb.this).zzbp(zzqb.zza(zzqb.this));
      }
    });
    if (tw != null)
    {
      if (tB) {
        tw.zza(tA, tC);
      }
      zzbl(false);
    }
    Object localObject = tm.un.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localzzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zze)tm.tY.get(localzzc)).disconnect();
    }
    if (tu.isEmpty()) {}
    for (localObject = null;; localObject = tu)
    {
      tm.ur.zzm((Bundle)localObject);
      return;
    }
  }
  
  private void zzapn()
  {
    ty = false;
    tm.sX.tZ = Collections.emptySet();
    Iterator localIterator = tv.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (!tm.un.containsKey(localzzc)) {
        tm.un.put(localzzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private void zzapo()
  {
    Iterator localIterator = tF.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    tF.clear();
  }
  
  private Set<Scope> zzapp()
  {
    if (tD == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(tD.zzasf());
    Map localMap = tD.zzash();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!tm.un.containsKey(localApi.zzanp())) {
        localHashSet.addAll(getdY);
      }
    }
    return localHashSet;
  }
  
  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zzanm().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        tq = paramConnectionResult;
        tr = i;
      }
    }
    tm.un.put(paramApi.zzanp(), paramConnectionResult);
  }
  
  private void zzbl(boolean paramBoolean)
  {
    if (tw != null)
    {
      if ((tw.isConnected()) && (paramBoolean)) {
        tw.zzbzk();
      }
      tw.disconnect();
      tA = null;
    }
  }
  
  private boolean zze(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {}
    while (tp.zzfa(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean zzf(ConnectionResult paramConnectionResult)
  {
    return (tx == 2) || ((tx == 1) && (!paramConnectionResult.hasResolution()));
  }
  
  private boolean zzfg(int paramInt)
  {
    if (ts != paramInt)
    {
      Log.i("GoogleApiClientConnecting", tm.sX.zzapv());
      String str1 = String.valueOf(this);
      Log.i("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = tt;
      Log.i("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(zzfh(ts));
      String str2 = String.valueOf(zzfh(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      zzg(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private String zzfh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private void zzg(ConnectionResult paramConnectionResult)
  {
    zzapo();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzbl(bool);
      tm.zzi(paramConnectionResult);
      tm.ur.zzd(paramConnectionResult);
      return;
    }
  }
  
  public void begin()
  {
    tm.un.clear();
    ty = false;
    tq = null;
    ts = 0;
    tx = 2;
    tz = false;
    tB = false;
    HashMap localHashMap = new HashMap();
    Object localObject = tE.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zze localzze = (Api.zze)tm.tY.get(localApi.zzanp());
      int k = ((Integer)tE.get(localApi)).intValue();
      if (localApi.zzanm().getPriority() == 1) {}
      for (int j = 1;; j = 0)
      {
        if (localzze.zzafk())
        {
          ty = true;
          if (k < tx) {
            tx = k;
          }
          if (k != 0) {
            tv.add(localApi.zzanp());
          }
        }
        localHashMap.put(localzze, new zza(this, localApi, k));
        i = j | i;
        break;
      }
    }
    if (i != 0) {
      ty = false;
    }
    if (ty)
    {
      tD.zzc(Integer.valueOf(tm.sX.getSessionId()));
      localObject = new zze(null);
      tw = ((zzvx)rY.zza(mContext, tm.sX.getLooper(), tD, tD.zzasl(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    tt = tm.tY.size();
    tF.add(zzqg.zzapz().submit(new zzb(localHashMap)));
  }
  
  public void connect() {}
  
  public boolean disconnect()
  {
    zzapo();
    zzbl(true);
    tm.zzi(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (!zzfg(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        tu.putAll(paramBundle);
      }
    } while (!zzapj());
    zzapm();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzg(new ConnectionResult(8, null));
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzfg(1)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    } while (!zzapj());
    zzapm();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    tm.sX.tS.add(paramT);
    return paramT;
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  private static class zza
    implements zzd.zzf
  {
    private final Api<?> pD;
    private final int sV;
    private final WeakReference<zzqb> tH;
    
    public zza(zzqb paramzzqb, Api<?> paramApi, int paramInt)
    {
      tH = new WeakReference(paramzzqb);
      pD = paramApi;
      sV = paramInt;
    }
    
    public void zzh(ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzqb localzzqb = (zzqb)tH.get();
      if (localzzqb == null) {
        return;
      }
      if (Looper.myLooper() == zzdsX.getLooper()) {
        bool = true;
      }
      zzab.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzqb.zzc(localzzqb).lock();
      try
      {
        bool = zzqb.zza(localzzqb, 0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzqb.zza(localzzqb, paramConnectionResult, pD, sV);
        }
        if (zzqb.zzk(localzzqb)) {
          zzqb.zzj(localzzqb);
        }
        return;
      }
      finally
      {
        zzqb.zzc(localzzqb).unlock();
      }
    }
  }
  
  private class zzb
    extends zzqb.zzf
  {
    private final Map<Api.zze, zzqb.zza> tI;
    
    public zzb()
    {
      super(null);
      Map localMap;
      tI = localMap;
    }
    
    public void zzapi()
    {
      int n = 1;
      int m = 0;
      final Object localObject = tI.keySet().iterator();
      int j = 1;
      int i = 0;
      Api.zze localzze;
      int k;
      if (((Iterator)localObject).hasNext())
      {
        localzze = (Api.zze)((Iterator)localObject).next();
        if (localzze.zzanr())
        {
          if (zzqb.zza.zza((zzqb.zza)tI.get(localzze)) != 0) {
            break label301;
          }
          i = 1;
          k = n;
        }
      }
      for (;;)
      {
        if (k != 0) {
          m = zzqb.zzb(zzqb.this).isGooglePlayServicesAvailable(zzqb.zza(zzqb.this));
        }
        if ((m != 0) && ((i != 0) || (j != 0)))
        {
          localObject = new ConnectionResult(m, null);
          zzqb.zzd(zzqb.this).zza(new zzqf.zza(zzqb.this)
          {
            public void zzapi()
            {
              zzqb.zza(zzqb.this, localObject);
            }
          });
          label155:
          return;
          k = 0;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (zzqb.zze(zzqb.this)) {
            zzqb.zzf(zzqb.this).connect();
          }
          localObject = tI.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localzze = (Api.zze)((Iterator)localObject).next();
            final zzd.zzf localzzf = (zzd.zzf)tI.get(localzze);
            if ((localzze.zzanr()) && (m != 0)) {
              zzqb.zzd(zzqb.this).zza(new zzqf.zza(zzqb.this)
              {
                public void zzapi()
                {
                  localzzf.zzh(new ConnectionResult(16, null));
                }
              });
            } else {
              localzze.zza(localzzf);
            }
          }
          break label155;
          label301:
          i = j;
          j = 1;
        }
        k = i;
        i = 0;
      }
    }
  }
  
  private class zzc
    extends zzqb.zzf
  {
    private final ArrayList<Api.zze> tM;
    
    public zzc()
    {
      super(null);
      ArrayList localArrayList;
      tM = localArrayList;
    }
    
    public void zzapi()
    {
      zzdsX.tZ = zzqb.zzg(zzqb.this);
      Iterator localIterator = tM.iterator();
      while (localIterator.hasNext()) {
        ((Api.zze)localIterator.next()).zza(zzqb.zzh(zzqb.this), zzdsX.tZ);
      }
    }
  }
  
  private static class zzd
    extends zzb
  {
    private final WeakReference<zzqb> tH;
    
    zzd(zzqb paramzzqb)
    {
      tH = new WeakReference(paramzzqb);
    }
    
    public void zzb(final SignInResponse paramSignInResponse)
    {
      final zzqb localzzqb = (zzqb)tH.get();
      if (localzzqb == null) {
        return;
      }
      zzqb.zzd(localzzqb).zza(new zzqf.zza(localzzqb)
      {
        public void zzapi()
        {
          zzqb.zza(localzzqb, paramSignInResponse);
        }
      });
    }
  }
  
  private class zze
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zze() {}
    
    public void onConnected(Bundle paramBundle)
    {
      zzqb.zzf(zzqb.this).zza(new zzqb.zzd(zzqb.this));
    }
    
    /* Error */
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   4: invokestatic 45	com/google/android/gms/internal/zzqb:zzc	(Lcom/google/android/gms/internal/zzqb;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 50 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   16: aload_1
      //   17: invokestatic 54	com/google/android/gms/internal/zzqb:zzb	(Lcom/google/android/gms/internal/zzqb;Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   27: invokestatic 57	com/google/android/gms/internal/zzqb:zzi	(Lcom/google/android/gms/internal/zzqb;)V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   34: invokestatic 60	com/google/android/gms/internal/zzqb:zzj	(Lcom/google/android/gms/internal/zzqb;)V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   41: invokestatic 45	com/google/android/gms/internal/zzqb:zzc	(Lcom/google/android/gms/internal/zzqb;)Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 63 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   54: aload_1
      //   55: invokestatic 66	com/google/android/gms/internal/zzqb:zza	(Lcom/google/android/gms/internal/zzqb;Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/internal/zzqb$zze:tG	Lcom/google/android/gms/internal/zzqb;
      //   66: invokestatic 45	com/google/android/gms/internal/zzqb:zzc	(Lcom/google/android/gms/internal/zzqb;)Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 63 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zze
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public void onConnectionSuspended(int paramInt) {}
  }
  
  private abstract class zzf
    implements Runnable
  {
    private zzf() {}
    
    public void run()
    {
      zzqb.zzc(zzqb.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zzapi();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzqb.zzd(zzqb.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzqb.zzc(zzqb.this).unlock();
      }
    }
    
    protected abstract void zzapi();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */