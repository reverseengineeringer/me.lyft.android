package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpr.zza;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzvx;
import com.google.android.gms.internal.zzvy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  private static final Set<GoogleApiClient> rM = Collections.newSetFromMap(new WeakHashMap());
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <C extends Api.zze> C zza(Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(zzrc paramzzrc)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzrc paramzzrc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private Account aP;
    private String cb;
    private final Context mContext;
    private final Set<Scope> rN = new HashSet();
    private final Set<Scope> rO = new HashSet();
    private int rP;
    private View rQ;
    private String rR;
    private final Map<Api<?>, zzg.zza> rS = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> rT = new ArrayMap();
    private zzqn rU;
    private int rV = -1;
    private GoogleApiClient.OnConnectionFailedListener rW;
    private GoogleApiAvailability rX = GoogleApiAvailability.getInstance();
    private Api.zza<? extends zzvx, zzvy> rY = zzvw.bO;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> rZ = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> sa = new ArrayList();
    private Looper zzahv;
    
    public Builder(Context paramContext)
    {
      mContext = paramContext;
      zzahv = paramContext.getMainLooper();
      cb = paramContext.getPackageName();
      rR = paramContext.getClass().getName();
    }
    
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      zzab.zzb(paramConnectionCallbacks, "Must provide a connected listener");
      rZ.add(paramConnectionCallbacks);
      zzab.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      sa.add(paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zze, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return paramzza.zza(paramContext, paramLooper, paramzzg, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zzg, O> zzah zza(Api.zzh<C, O> paramzzh, Object paramObject, Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzah(paramContext, paramLooper, paramzzh.zzant(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg, paramzzh.zzs(paramObject));
    }
    
    private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, int paramInt, Scope... paramVarArgs)
    {
      boolean bool = true;
      int i = 0;
      if (paramInt == 1) {}
      for (;;)
      {
        paramO = new HashSet(paramApi.zzanm().zzq(paramO));
        int j = paramVarArgs.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramO.add(paramVarArgs[paramInt]);
          paramInt += 1;
        }
        if (paramInt != 2) {
          break;
        }
        bool = false;
      }
      throw new IllegalArgumentException(90 + "Invalid resolution mode: '" + paramInt + "', use a constant from GoogleApiClient.ResolutionMode");
      rS.put(paramApi, new zzg.zza(paramO, bool));
    }
    
    private GoogleApiClient zzaof()
    {
      zzg localzzg = zzaoe();
      Object localObject2 = null;
      Map localMap = localzzg.zzash();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = rT.keySet().iterator();
      Object localObject1 = null;
      Api localApi;
      Object localObject3;
      int i;
      label130:
      zzpu localzzpu;
      Object localObject4;
      if (localIterator.hasNext())
      {
        localApi = (Api)localIterator.next();
        localObject3 = rT.get(localApi);
        i = 0;
        if (localMap.get(localApi) != null)
        {
          if (getyc) {
            i = 1;
          }
        }
        else
        {
          localArrayMap1.put(localApi, Integer.valueOf(i));
          localzzpu = new zzpu(localApi, i);
          localArrayList.add(localzzpu);
          if (!localApi.zzanq()) {
            break label324;
          }
          localObject4 = localApi.zzano();
          if (((Api.zzh)localObject4).getPriority() != 1) {
            break label590;
          }
          localObject1 = localApi;
        }
      }
      label214:
      label324:
      label373:
      label582:
      label587:
      label590:
      for (;;)
      {
        localObject3 = zza((Api.zzh)localObject4, localObject3, mContext, zzahv, localzzg, localzzpu, localzzpu);
        localArrayMap2.put(localApi.zzanp(), localObject3);
        if (((Api.zze)localObject3).zzafz())
        {
          localObject3 = localApi;
          if (localObject2 == null) {
            break label373;
          }
          localObject1 = String.valueOf(localApi.getName());
          localObject2 = String.valueOf(((Api)localObject2).getName());
          throw new IllegalStateException(String.valueOf(localObject1).length() + 21 + String.valueOf(localObject2).length() + (String)localObject1 + " cannot be used with " + (String)localObject2);
          i = 2;
          break label130;
          localObject4 = localApi.zzann();
          if (((Api.zza)localObject4).getPriority() != 1) {
            break label587;
          }
          localObject1 = localApi;
        }
        for (;;)
        {
          localObject3 = zza((Api.zza)localObject4, localObject3, mContext, zzahv, localzzg, localzzpu, localzzpu);
          break label214;
          localObject3 = localObject2;
          localObject2 = localObject3;
          break;
          if (localObject2 != null)
          {
            if (localObject1 != null)
            {
              localObject2 = String.valueOf(((Api)localObject2).getName());
              localObject1 = String.valueOf(((Api)localObject1).getName());
              throw new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length() + (String)localObject2 + " cannot be used with " + (String)localObject1);
            }
            if (aP != null) {
              break label582;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            zzab.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)localObject2).getName() });
            zzab.zza(rN.equals(rO), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)localObject2).getName() });
            i = zzqd.zza(localArrayMap2.values(), true);
            return new zzqd(mContext, new ReentrantLock(), zzahv, localzzg, rX, rY, localArrayMap1, rZ, sa, localArrayMap2, rV, i, localArrayList);
          }
        }
      }
    }
    
    private void zzf(GoogleApiClient paramGoogleApiClient)
    {
      zzpp.zza(rU).zza(rV, paramGoogleApiClient, rW);
    }
    
    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzab.zzb(paramApi, "Api must not be null");
      rT.put(paramApi, null);
      paramApi = paramApi.zzanm().zzq(null);
      rO.addAll(paramApi);
      rN.addAll(paramApi);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      zzab.zzb(paramApi, "Api must not be null");
      zzab.zzb(paramO, "Null options are not permitted for this Api");
      rT.put(paramApi, paramO);
      paramApi = paramApi.zzanm().zzq(paramO);
      rO.addAll(paramApi);
      rN.addAll(paramApi);
      return this;
    }
    
    public Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      zzab.zzb(paramApi, "Api must not be null");
      rT.put(paramApi, null);
      zza(paramApi, null, 1, paramVarArgs);
      return this;
    }
    
    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzab.zzb(paramConnectionCallbacks, "Listener must not be null");
      rZ.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzab.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      sa.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public GoogleApiClient build()
    {
      boolean bool;
      if (!rT.isEmpty()) {
        bool = true;
      }
      for (;;)
      {
        zzab.zzb(bool, "must call addApi() to add at least one API");
        GoogleApiClient localGoogleApiClient = zzaof();
        synchronized (GoogleApiClient.zzaod())
        {
          GoogleApiClient.zzaod().add(localGoogleApiClient);
          if (rV >= 0) {
            zzf(localGoogleApiClient);
          }
          return localGoogleApiClient;
          bool = false;
        }
      }
    }
    
    public zzg zzaoe()
    {
      zzvy localzzvy = zzvy.aul;
      if (rT.containsKey(zzvw.API)) {
        localzzvy = (zzvy)rT.get(zzvw.API);
      }
      return new zzg(aP, rN, rS, rP, rQ, cb, rR, localzzvy);
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */