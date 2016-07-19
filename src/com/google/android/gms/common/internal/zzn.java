package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzn
  extends zzm
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> yB = new HashMap();
  private final zzb yC;
  private final long yD;
  private final Context zzaqj;
  
  zzn(Context paramContext)
  {
    zzaqj = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    yC = zzb.zzaut();
    yD = 5000L;
  }
  
  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzab.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localzzb;
      synchronized (yB)
      {
        localzzb = (zzb)yB.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new zzb(paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzhn(paramString);
          yB.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = paramzza.isBound();
          return bool;
        }
        mHandler.removeMessages(0, localzzb);
        if (localzzb.zza(paramServiceConnection))
        {
          paramzza = String.valueOf(paramzza);
          throw new IllegalStateException(String.valueOf(paramzza).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2: 
        localzzb.zzhn(paramString);
        paramzza = localzzb;
        break;
      default: 
        paramzza = localzzb;
      }
    }
  }
  
  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzab.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (yB)
    {
      localzzb = (zzb)yB.get(paramzza);
      if (localzzb == null)
      {
        paramzza = String.valueOf(paramzza);
        throw new IllegalStateException(String.valueOf(paramzza).length() + 50 + "Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzzb.zza(paramServiceConnection))
    {
      paramzza = String.valueOf(paramzza);
      throw new IllegalStateException(String.valueOf(paramzza).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzasv())
    {
      paramzza = mHandler.obtainMessage(0, localzzb);
      mHandler.sendMessageDelayed(paramzza, yD);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    zzb localzzb = (zzb)obj;
    synchronized (yB)
    {
      if (localzzb.zzasv())
      {
        if (localzzb.isBound()) {
          localzzb.zzho("GmsClientSupervisor");
        }
        yB.remove(zzb.zza(localzzb));
      }
      return true;
    }
  }
  
  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  private static final class zza
  {
    private final String yE;
    private final ComponentName yF;
    private final String zzcvf;
    
    public zza(String paramString1, String paramString2)
    {
      zzcvf = zzab.zzhs(paramString1);
      yE = zzab.zzhs(paramString2);
      yF = null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzaa.equal(zzcvf, zzcvf)) && (zzaa.equal(yF, yF)));
      return false;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { zzcvf, yF });
    }
    
    public String toString()
    {
      if (zzcvf == null) {
        return yF.flattenToString();
      }
      return zzcvf;
    }
    
    public Intent zzasu()
    {
      if (zzcvf != null) {
        return new Intent(zzcvf).setPackage(yE);
      }
      return new Intent().setComponent(yF);
    }
  }
  
  private final class zzb
  {
    private int mState;
    private IBinder xA;
    private ComponentName yF;
    private final zza yG;
    private final Set<ServiceConnection> yH;
    private boolean yI;
    private final zzn.zza yJ;
    
    public zzb(zzn.zza paramzza)
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
      zzn.zzc(zzn.this).zza(zzn.zzb(zzn.this), paramServiceConnection, paramString, yJ.zzasu());
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
      zzn.zzc(zzn.this).zzb(zzn.zzb(zzn.this), paramServiceConnection);
      yH.remove(paramServiceConnection);
    }
    
    @TargetApi(14)
    public void zzhn(String paramString)
    {
      mState = 3;
      yI = zzn.zzc(zzn.this).zza(zzn.zzb(zzn.this), paramString, yJ.zzasu(), yG, 129);
      if (!yI) {
        mState = 2;
      }
      try
      {
        zzn.zzc(zzn.this).zza(zzn.zzb(zzn.this), yG);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public void zzho(String paramString)
    {
      zzn.zzc(zzn.this).zza(zzn.zzb(zzn.this), yG);
      yI = false;
      mState = 2;
    }
    
    public class zza
      implements ServiceConnection
    {
      public zza() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzn.zza(zzn.this))
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
        synchronized (zzn.zza(zzn.this))
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */