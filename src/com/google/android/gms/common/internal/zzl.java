package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzl
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza ys;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> yt = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> yu = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> yv = new ArrayList();
  private volatile boolean yw = false;
  private final AtomicInteger yx = new AtomicInteger(0);
  private boolean yy = false;
  private final Object zzail = new Object();
  
  public zzl(Looper paramLooper, zza paramzza)
  {
    ys = paramzza;
    mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)obj;
      synchronized (zzail)
      {
        if ((yw) && (ys.isConnected()) && (yt.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(ys.zzamc());
        }
        return true;
      }
    }
    int i = what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzab.zzaa(paramConnectionCallbacks);
    synchronized (zzail)
    {
      if (yt.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (ys.isConnected()) {
          mHandler.sendMessage(mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      yt.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzab.zzaa(paramOnConnectionFailedListener);
    synchronized (zzail)
    {
      if (yv.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 67 + "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      yv.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzab.zzaa(paramOnConnectionFailedListener);
    synchronized (zzail)
    {
      if (!yv.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 57 + "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzass()
  {
    yw = false;
    yx.incrementAndGet();
  }
  
  public void zzast()
  {
    yw = true;
  }
  
  public void zzgb(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == mHandler.getLooper()) {
      bool = true;
    }
    zzab.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    mHandler.removeMessages(1);
    synchronized (zzail)
    {
      yy = true;
      Object localObject2 = new ArrayList(yt);
      int i = yx.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((yw) && (yx.get() == i)) {}
        }
        else
        {
          yu.clear();
          yy = false;
          return;
        }
      } while (!yt.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzm(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      mHandler.removeMessages(1);
      synchronized (zzail)
      {
        Object localObject2 = new ArrayList(yv);
        int i = yx.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!yw) || (yx.get() != i)) {
            return;
          }
          if (yv.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzo(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == mHandler.getLooper())
    {
      bool1 = true;
      zzab.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (zzail)
      {
        if (yy) {
          break label206;
        }
        bool1 = true;
        zzab.zzbm(bool1);
        mHandler.removeMessages(1);
        yy = true;
        if (yu.size() != 0) {
          break label211;
        }
        bool1 = bool2;
        zzab.zzbm(bool1);
        Object localObject2 = new ArrayList(yt);
        int i = yx.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((yw) && (ys.isConnected()) && (yx.get() == i)) {}
        }
        else
        {
          yu.clear();
          yy = false;
          return;
        }
        if (yu.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206:
      bool1 = false;
      continue;
      label211:
      bool1 = false;
    }
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zzamc();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */