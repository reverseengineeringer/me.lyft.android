package com.google.android.gms.wearable;

import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.common.zzf;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzaw.zza;
import java.util.List;

final class WearableListenerService$zzc
  extends zzaw.zza
{
  private volatile int aJt = -1;
  
  private WearableListenerService$zzc(WearableListenerService paramWearableListenerService) {}
  
  private boolean zza(Runnable paramRunnable, String arg2, Object paramObject)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zza(aJr), paramObject }));
    }
    zzcin();
    synchronized (WearableListenerService.zzc(aJr))
    {
      if (WearableListenerService.zzd(aJr)) {
        return false;
      }
      WearableListenerService.zze(aJr).post(paramRunnable);
      return true;
    }
  }
  
  private void zzcin()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == aJt) {
      return;
    }
    if (GooglePlayServicesUtil.zzb(aJr, i, "com.google.android.wearable.app.cn"))
    {
      if (zzf.zzbz(aJr).zzb(aJr.getPackageManager(), "com.google.android.wearable.app.cn"))
      {
        aJt = i;
        return;
      }
      throw new SecurityException("Caller is not Android Wear.");
    }
    if (zzy.zze(aJr, i))
    {
      aJt = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  public void onConnectedNodes(final List<NodeParcelable> paramList)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onConnectedNodes(paramList);
      }
    }, "onConnectedNodes", paramList);
  }
  
  public void zza(final AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onEntityUpdate(paramAmsEntityUpdateParcelable);
      }
    }, "onEntityUpdate", paramAmsEntityUpdateParcelable);
  }
  
  public void zza(final AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onNotificationReceived(paramAncsNotificationParcelable);
      }
    }, "onNotificationReceived", paramAncsNotificationParcelable);
  }
  
  public void zza(final CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onCapabilityChanged(paramCapabilityInfoParcelable);
      }
    }, "onConnectedCapabilityChanged", paramCapabilityInfoParcelable);
  }
  
  public void zza(final ChannelEventParcelable paramChannelEventParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        paramChannelEventParcelable.zza(aJr);
      }
    }, "onChannelEvent", paramChannelEventParcelable);
  }
  
  public void zza(final MessageEventParcelable paramMessageEventParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onMessageReceived(paramMessageEventParcelable);
      }
    }, "onMessageReceived", paramMessageEventParcelable);
  }
  
  public void zza(final NodeParcelable paramNodeParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onPeerConnected(paramNodeParcelable);
      }
    }, "onPeerConnected", paramNodeParcelable);
  }
  
  public void zzb(final NodeParcelable paramNodeParcelable)
  {
    zza(new Runnable()
    {
      public void run()
      {
        aJr.onPeerDisconnected(paramNodeParcelable);
      }
    }, "onPeerDisconnected", paramNodeParcelable);
  }
  
  public void zzbq(final DataHolder paramDataHolder)
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
        try
        {
          aJr.onDataChanged(localDataEventBuffer);
          return;
        }
        finally
        {
          localDataEventBuffer.release();
        }
      }
    };
    try
    {
      String str = String.valueOf(paramDataHolder);
      int i = paramDataHolder.getCount();
      boolean bool = zza(local1, "onDataItemChanged", String.valueOf(str).length() + 18 + str + ", rows=" + i);
      if (!bool) {}
      return;
    }
    finally
    {
      paramDataHolder.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */