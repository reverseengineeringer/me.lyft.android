package com.google.android.gms.wearable;

import android.os.Handler;
import android.os.Looper;

final class WearableListenerService$zzb
  extends Handler
{
  private WearableListenerService.zza aJs = new WearableListenerService.zza(aJr, null);
  private boolean started;
  
  WearableListenerService$zzb(WearableListenerService paramWearableListenerService, Looper paramLooper)
  {
    super(paramLooper);
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

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */