package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqs.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public class zzbq<T>
  extends zzaw.zza
{
  private final IntentFilter[] aKV;
  private zzqs<DataApi.DataListener> aLu;
  private zzqs<NodeApi.NodeListener> aLv;
  private zzqs<ChannelApi.ChannelListener> aLx;
  private zzqs<CapabilityApi.CapabilityListener> aLy;
  private final String aLz;
  private zzqs<MessageApi.MessageListener> apI;
  
  private static zzqs.zzb<CapabilityApi.CapabilityListener> zzb(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    new zzqs.zzb()
    {
      public void zza(CapabilityApi.CapabilityListener paramAnonymousCapabilityListener)
      {
        paramAnonymousCapabilityListener.onCapabilityChanged(zzbq.this);
      }
      
      public void zzapg() {}
    };
  }
  
  private static zzqs.zzb<ChannelApi.ChannelListener> zzb(ChannelEventParcelable paramChannelEventParcelable)
  {
    new zzqs.zzb()
    {
      public void zzapg() {}
      
      public void zzb(ChannelApi.ChannelListener paramAnonymousChannelListener)
      {
        zza(paramAnonymousChannelListener);
      }
    };
  }
  
  private static zzqs.zzb<MessageApi.MessageListener> zzb(MessageEventParcelable paramMessageEventParcelable)
  {
    new zzqs.zzb()
    {
      public void zza(MessageApi.MessageListener paramAnonymousMessageListener)
      {
        paramAnonymousMessageListener.onMessageReceived(zzbq.this);
      }
      
      public void zzapg() {}
    };
  }
  
  private static zzqs.zzb<DataApi.DataListener> zzbs(DataHolder paramDataHolder)
  {
    new zzqs.zzb()
    {
      public void zza(DataApi.DataListener paramAnonymousDataListener)
      {
        try
        {
          paramAnonymousDataListener.onDataChanged(new DataEventBuffer(zzbq.this));
          return;
        }
        finally
        {
          close();
        }
      }
      
      public void zzapg()
      {
        close();
      }
    };
  }
  
  private static zzqs.zzb<NodeApi.NodeListener> zzc(NodeParcelable paramNodeParcelable)
  {
    new zzqs.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerConnected(zzbq.this);
      }
      
      public void zzapg() {}
    };
  }
  
  private static zzqs.zzb<NodeApi.NodeListener> zzd(NodeParcelable paramNodeParcelable)
  {
    new zzqs.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerDisconnected(zzbq.this);
      }
      
      public void zzapg() {}
    };
  }
  
  public void onConnectedNodes(List<NodeParcelable> paramList) {}
  
  public void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable) {}
  
  public void zza(AncsNotificationParcelable paramAncsNotificationParcelable) {}
  
  public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    if (aLy != null) {
      aLy.zza(zzb(paramCapabilityInfoParcelable));
    }
  }
  
  public void zza(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (aLx != null) {
      aLx.zza(zzb(paramChannelEventParcelable));
    }
  }
  
  public void zza(MessageEventParcelable paramMessageEventParcelable)
  {
    if (apI != null) {
      apI.zza(zzb(paramMessageEventParcelable));
    }
  }
  
  public void zza(NodeParcelable paramNodeParcelable)
  {
    if (aLv != null) {
      aLv.zza(zzc(paramNodeParcelable));
    }
  }
  
  public void zzb(NodeParcelable paramNodeParcelable)
  {
    if (aLv != null) {
      aLv.zza(zzd(paramNodeParcelable));
    }
  }
  
  public void zzbq(DataHolder paramDataHolder)
  {
    if (aLu != null)
    {
      aLu.zza(zzbs(paramDataHolder));
      return;
    }
    paramDataHolder.close();
  }
  
  public IntentFilter[] zzcjd()
  {
    return aKV;
  }
  
  public String zzcje()
  {
    return aLz;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */