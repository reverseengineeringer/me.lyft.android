package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
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
import com.google.android.gms.common.internal.zzg;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class zzqh$zzc<O extends Api.ApiOptions>
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
  
  public zzqh$zzc(zzc<O> paramzzc)
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
    if ((uJ.zzanr()) && (zzqh.zzk(uG) != 0))
    {
      zzqh.zza(uG, zzqh.zzi(uG).isGooglePlayServicesAvailable(zzqh.zzh(uG)));
      if (zzqh.zzk(uG) != 0)
      {
        onConnectionFailed(new ConnectionResult(zzqh.zzk(uG), null));
        return;
      }
    }
    uJ.zza(new zzqh.zzd(uG, uJ, rG));
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
      if (zzqh.zzi(uG).isGooglePlayServicesAvailable(zzqh.zzh(uG)) != 18) {
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
      zzqh.zza(uG).removeMessages(9, rG);
      zzqh.zza(uG).removeMessages(8, rG);
      tT = false;
    }
  }
  
  private void zzaqi()
  {
    zzqh.zza(uG).removeMessages(10, rG);
    zzqh.zza(uG).sendMessageDelayed(zzqh.zza(uG).obtainMessage(10, rG), zzqh.zzj(uG));
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
      return new zzah(paramzzc.getApplicationContext(), zzqh.zza(uG).getLooper(), ((Api.zzh)localObject).zzant(), this, this, zzg.zzcd(paramzzc.getApplicationContext()), ((Api.zzh)localObject).zzs(paramzzc.zzanx()));
    }
    return paramzzc.zzanw().zzann().zza(paramzzc.getApplicationContext(), zzqh.zza(uG).getLooper(), zzg.zzcd(paramzzc.getApplicationContext()), paramzzc.zzanx(), this, this);
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
    zzqh.zza(uG, -1);
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
        if ((zzqh.zzd(uG) != null) && (zzqh.zze(uG).contains(rG)))
        {
          zzqh.zzd(uG).zzb(paramConnectionResult, i);
          return;
        }
      }
    } while (uG.zzc(paramConnectionResult, i));
    if (paramConnectionResult.getErrorCode() == 18) {
      tT = true;
    }
    if (tT)
    {
      zzqh.zza(uG).sendMessageDelayed(Message.obtain(zzqh.zza(uG), 8, rG), zzqh.zzb(uG));
      return;
    }
    paramConnectionResult = String.valueOf(rG.zzaok());
    zzab(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzaqf();
    tT = true;
    zzqh.zza(uG).sendMessageDelayed(Message.obtain(zzqh.zza(uG), 8, rG), zzqh.zzb(uG));
    zzqh.zza(uG).sendMessageDelayed(Message.obtain(zzqh.zza(uG), 9, rG), zzqh.zzc(uG));
    zzqh.zza(uG, -1);
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
      zzqh.zzf(uG).remove(paramInt);
      if ((uL.size() == 0) && (uI.isEmpty()))
      {
        zzaqh();
        uJ.disconnect();
        zzqh.zzg(uG).remove(rG);
        synchronized (zzqh.zzaqc())
        {
          zzqh.zze(uG).remove(rG);
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqh.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */