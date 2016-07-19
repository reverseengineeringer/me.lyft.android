package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
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

public abstract class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private zzb aJn;
  private Intent aJo;
  private final Object aJp = new Object();
  private boolean aJq;
  private IBinder xA;
  
  private String zzcim()
  {
    return new ComponentName(getPackageName(), getClass().getName()).flattenToShortString();
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return xA;
    }
    return null;
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo) {}
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelOpened(Channel paramChannel) {}
  
  public void onConnectedNodes(List<Node> paramList) {}
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3))
    {
      localObject = String.valueOf(zzcim());
      if (((String)localObject).length() == 0) {
        break label108;
      }
    }
    label108:
    for (Object localObject = "onCreate: ".concat((String)localObject);; localObject = new String("onCreate: "))
    {
      Log.d("WearableLS", (String)localObject);
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      aJn = new zzb(((HandlerThread)localObject).getLooper());
      aJo = new Intent("com.google.android.gms.wearable.BIND_LISTENER", null, getApplicationContext(), getClass());
      xA = new zzc(null);
      return;
    }
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    String str1;
    if (Log.isLoggable("WearableLS", 3))
    {
      str1 = String.valueOf(zzcim());
      if (str1.length() == 0) {
        break label93;
      }
      str1 = "onDestroy: ".concat(str1);
      Log.d("WearableLS", str1);
    }
    label93:
    String str2;
    synchronized (aJp)
    {
      aJq = true;
      if (aJn == null)
      {
        str1 = String.valueOf(zzcim());
        if (str1.length() != 0)
        {
          str1 = "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=".concat(str1);
          throw new IllegalStateException(str1);
        }
      }
    }
  }
  
  public void onEntityUpdate(zzb paramzzb) {}
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onNotificationReceived(zzd paramzzd) {}
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
  
  private class zza
    implements ServiceConnection
  {
    private zza() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private final class zzb
    extends Handler
  {
    private WearableListenerService.zza aJs = new WearableListenerService.zza(WearableListenerService.this, null);
    private boolean started;
    
    zzb(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    @android.annotation.SuppressLint({"UntrackedBindService"})
    public void dispatchMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
      //   4: ifne +60 -> 64
      //   7: aload_0
      //   8: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   11: invokestatic 41	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Ljava/lang/String;
      //   14: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   17: astore_2
      //   18: aload_2
      //   19: invokevirtual 51	java/lang/String:length	()I
      //   22: ifeq +104 -> 126
      //   25: ldc 53
      //   27: aload_2
      //   28: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   31: astore_2
      //   32: ldc 59
      //   34: aload_2
      //   35: invokestatic 65	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   38: pop
      //   39: aload_0
      //   40: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   43: aload_0
      //   44: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   47: invokestatic 68	com/google/android/gms/wearable/WearableListenerService:zzb	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/Intent;
      //   50: aload_0
      //   51: getfield 27	com/google/android/gms/wearable/WearableListenerService$zzb:aJs	Lcom/google/android/gms/wearable/WearableListenerService$zza;
      //   54: iconst_1
      //   55: invokevirtual 72	com/google/android/gms/wearable/WearableListenerService:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   58: pop
      //   59: aload_0
      //   60: iconst_1
      //   61: putfield 37	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
      //   64: aload_0
      //   65: aload_1
      //   66: invokespecial 74	android/os/Handler:dispatchMessage	(Landroid/os/Message;)V
      //   69: aload_0
      //   70: iconst_0
      //   71: invokevirtual 78	com/google/android/gms/wearable/WearableListenerService$zzb:hasMessages	(I)Z
      //   74: ifne +51 -> 125
      //   77: aload_0
      //   78: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   81: invokestatic 41	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Ljava/lang/String;
      //   84: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   87: astore_1
      //   88: aload_1
      //   89: invokevirtual 51	java/lang/String:length	()I
      //   92: ifeq +47 -> 139
      //   95: ldc 80
      //   97: aload_1
      //   98: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   101: astore_1
      //   102: ldc 59
      //   104: aload_1
      //   105: invokestatic 65	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   108: pop
      //   109: aload_0
      //   110: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   113: aload_0
      //   114: getfield 27	com/google/android/gms/wearable/WearableListenerService$zzb:aJs	Lcom/google/android/gms/wearable/WearableListenerService$zza;
      //   117: invokevirtual 84	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
      //   120: aload_0
      //   121: iconst_0
      //   122: putfield 37	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
      //   125: return
      //   126: new 43	java/lang/String
      //   129: dup
      //   130: ldc 53
      //   132: invokespecial 87	java/lang/String:<init>	(Ljava/lang/String;)V
      //   135: astore_2
      //   136: goto -104 -> 32
      //   139: new 43	java/lang/String
      //   142: dup
      //   143: ldc 80
      //   145: invokespecial 87	java/lang/String:<init>	(Ljava/lang/String;)V
      //   148: astore_1
      //   149: goto -47 -> 102
      //   152: astore_1
      //   153: ldc 59
      //   155: ldc 89
      //   157: aload_1
      //   158: invokestatic 93	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   161: pop
      //   162: goto -42 -> 120
      //   165: astore_2
      //   166: aload_0
      //   167: iconst_0
      //   168: invokevirtual 78	com/google/android/gms/wearable/WearableListenerService$zzb:hasMessages	(I)Z
      //   171: ifne +51 -> 222
      //   174: aload_0
      //   175: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   178: invokestatic 41	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Ljava/lang/String;
      //   181: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   184: astore_1
      //   185: aload_1
      //   186: invokevirtual 51	java/lang/String:length	()I
      //   189: ifeq +35 -> 224
      //   192: ldc 80
      //   194: aload_1
      //   195: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   198: astore_1
      //   199: ldc 59
      //   201: aload_1
      //   202: invokestatic 65	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   205: pop
      //   206: aload_0
      //   207: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:aJr	Lcom/google/android/gms/wearable/WearableListenerService;
      //   210: aload_0
      //   211: getfield 27	com/google/android/gms/wearable/WearableListenerService$zzb:aJs	Lcom/google/android/gms/wearable/WearableListenerService$zza;
      //   214: invokevirtual 84	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
      //   217: aload_0
      //   218: iconst_0
      //   219: putfield 37	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
      //   222: aload_2
      //   223: athrow
      //   224: new 43	java/lang/String
      //   227: dup
      //   228: ldc 80
      //   230: invokespecial 87	java/lang/String:<init>	(Ljava/lang/String;)V
      //   233: astore_1
      //   234: goto -35 -> 199
      //   237: astore_1
      //   238: ldc 59
      //   240: ldc 89
      //   242: aload_1
      //   243: invokestatic 93	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   246: pop
      //   247: goto -30 -> 217
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	250	0	this	zzb
      //   0	250	1	paramMessage	android.os.Message
      //   17	119	2	str	String
      //   165	58	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   109	120	152	java/lang/RuntimeException
      //   64	69	165	finally
      //   206	217	237	java/lang/RuntimeException
    }
  }
  
  private final class zzc
    extends zzaw.zza
  {
    private volatile int aJt = -1;
    
    private zzc() {}
    
    private boolean zza(Runnable paramRunnable, String arg2, Object paramObject)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zza(WearableListenerService.this), paramObject }));
      }
      zzcin();
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return false;
        }
        WearableListenerService.zze(WearableListenerService.this).post(paramRunnable);
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
      if (GooglePlayServicesUtil.zzb(WearableListenerService.this, i, "com.google.android.wearable.app.cn"))
      {
        if (zzf.zzbz(WearableListenerService.this).zzb(getPackageManager(), "com.google.android.wearable.app.cn"))
        {
          aJt = i;
          return;
        }
        throw new SecurityException("Caller is not Android Wear.");
      }
      if (zzy.zze(WearableListenerService.this, i))
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
          WearableListenerService.this.onConnectedNodes(paramList);
        }
      }, "onConnectedNodes", paramList);
    }
    
    public void zza(final AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onEntityUpdate(paramAmsEntityUpdateParcelable);
        }
      }, "onEntityUpdate", paramAmsEntityUpdateParcelable);
    }
    
    public void zza(final AncsNotificationParcelable paramAncsNotificationParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onNotificationReceived(paramAncsNotificationParcelable);
        }
      }, "onNotificationReceived", paramAncsNotificationParcelable);
    }
    
    public void zza(final CapabilityInfoParcelable paramCapabilityInfoParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onCapabilityChanged(paramCapabilityInfoParcelable);
        }
      }, "onConnectedCapabilityChanged", paramCapabilityInfoParcelable);
    }
    
    public void zza(final ChannelEventParcelable paramChannelEventParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          paramChannelEventParcelable.zza(WearableListenerService.this);
        }
      }, "onChannelEvent", paramChannelEventParcelable);
    }
    
    public void zza(final MessageEventParcelable paramMessageEventParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onMessageReceived(paramMessageEventParcelable);
        }
      }, "onMessageReceived", paramMessageEventParcelable);
    }
    
    public void zza(final NodeParcelable paramNodeParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onPeerConnected(paramNodeParcelable);
        }
      }, "onPeerConnected", paramNodeParcelable);
    }
    
    public void zzb(final NodeParcelable paramNodeParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          onPeerDisconnected(paramNodeParcelable);
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
            onDataChanged(localDataEventBuffer);
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */