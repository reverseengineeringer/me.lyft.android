package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zzb;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzn$zzb
{
  private int mState;
  private IBinder xA;
  private ComponentName yF;
  private final zza yG;
  private final Set<ServiceConnection> yH;
  private boolean yI;
  private final zzn.zza yJ;
  
  public zzn$zzb(zzn paramzzn, zzn.zza paramzza)
  {
    yJ = paramzza;
    yG = new zza();
    yH = new HashSet();
    mState = 2;
  }
  
  public IBinder getBinder()
  {
    return xA;
  }
  
  public ComponentName getComponentName()
  {
    return yF;
  }
  
  public int getState()
  {
    return mState;
  }
  
  public boolean isBound()
  {
    return yI;
  }
  
  public void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zzn.zzc(yK).zza(zzn.zzb(yK), paramServiceConnection, paramString, yJ.zzasu());
    yH.add(paramServiceConnection);
  }
  
  public boolean zza(ServiceConnection paramServiceConnection)
  {
    return yH.contains(paramServiceConnection);
  }
  
  public boolean zzasv()
  {
    return yH.isEmpty();
  }
  
  public void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    zzn.zzc(yK).zzb(zzn.zzb(yK), paramServiceConnection);
    yH.remove(paramServiceConnection);
  }
  
  @TargetApi(14)
  public void zzhn(String paramString)
  {
    mState = 3;
    yI = zzn.zzc(yK).zza(zzn.zzb(yK), paramString, yJ.zzasu(), yG, 129);
    if (!yI) {
      mState = 2;
    }
    try
    {
      zzn.zzc(yK).zza(zzn.zzb(yK), yG);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public void zzho(String paramString)
  {
    zzn.zzc(yK).zza(zzn.zzb(yK), yG);
    yI = false;
    mState = 2;
  }
  
  public class zza
    implements ServiceConnection
  {
    public zza() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      synchronized (zzn.zza(yK))
      {
        zzn.zzb.zza(zzn.zzb.this, paramIBinder);
        zzn.zzb.zza(zzn.zzb.this, paramComponentName);
        Iterator localIterator = zzn.zzb.zzb(zzn.zzb.this).iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
      }
      zzn.zzb.zza(zzn.zzb.this, 1);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (zzn.zza(yK))
      {
        zzn.zzb.zza(zzn.zzb.this, null);
        zzn.zzb.zza(zzn.zzb.this, paramComponentName);
        Iterator localIterator = zzn.zzb.zzb(zzn.zzb.this).iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
      }
      zzn.zzb.zza(zzn.zzb.this, 2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzn.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */