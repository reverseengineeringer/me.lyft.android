package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Future;

@zzir
public class zzik
  extends zzkg
{
  private final Object zzail = new Object();
  private final zzig.zza zzbxu;
  private final zzjy.zza zzbxv;
  private final AdResponseParcel zzbxw;
  private final zzim zzbyu;
  private Future<zzjy> zzbyv;
  
  public zzik(Context paramContext, zzq paramzzq, zzjy.zza paramzza, zzas paramzzas, zzig.zza paramzza1)
  {
    this(paramzza, paramzza1, new zzim(paramContext, paramzzq, new zzkr(paramContext), paramzzas, paramzza));
  }
  
  zzik(zzjy.zza paramzza, zzig.zza paramzza1, zzim paramzzim)
  {
    zzbxv = paramzza;
    zzbxw = zzciu;
    zzbxu = paramzza1;
    zzbyu = paramzzim;
  }
  
  private zzjy zzam(int paramInt)
  {
    return new zzjy(zzbxv.zzcit.zzcav, null, null, paramInt, null, null, zzbxw.orientation, zzbxw.zzbnw, zzbxv.zzcit.zzcay, false, null, null, null, null, null, zzbxw.zzccd, zzbxv.zzaoy, zzbxw.zzccb, zzbxv.zzcio, zzbxw.zzccg, zzbxw.zzcch, zzbxv.zzcii, null, null, null, null, zzbxv.zzciu.zzccu, zzbxv.zzciu.zzccv, null, null);
  }
  
  public void onStop()
  {
    synchronized (zzail)
    {
      if (zzbyv != null) {
        zzbyv.cancel(true);
      }
      return;
    }
  }
  
  /* Error */
  public void zzew()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/google/android/gms/internal/zzik:zzail	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 57	com/google/android/gms/internal/zzik:zzbyu	Lcom/google/android/gms/internal/zzim;
    //   12: invokestatic 144	com/google/android/gms/internal/zzkk:zza	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/internal/zzlc;
    //   15: putfield 124	com/google/android/gms/internal/zzik:zzbyv	Ljava/util/concurrent/Future;
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: getfield 124	com/google/android/gms/internal/zzik:zzbyv	Ljava/util/concurrent/Future;
    //   24: ldc2_w 145
    //   27: getstatic 152	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   30: invokeinterface 156 4 0
    //   35: checkcast 63	com/google/android/gms/internal/zzjy
    //   38: astore_2
    //   39: bipush -2
    //   41: istore_1
    //   42: aload_2
    //   43: ifnull +73 -> 116
    //   46: getstatic 162	com/google/android/gms/internal/zzkl:zzclg	Landroid/os/Handler;
    //   49: new 6	com/google/android/gms/internal/zzik$1
    //   52: dup
    //   53: aload_0
    //   54: aload_2
    //   55: invokespecial 165	com/google/android/gms/internal/zzik$1:<init>	(Lcom/google/android/gms/internal/zzik;Lcom/google/android/gms/internal/zzjy;)V
    //   58: invokevirtual 171	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: return
    //   63: astore_3
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: astore_2
    //   69: ldc -83
    //   71: invokestatic 179	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 124	com/google/android/gms/internal/zzik:zzbyv	Ljava/util/concurrent/Future;
    //   78: iconst_1
    //   79: invokeinterface 130 2 0
    //   84: pop
    //   85: iconst_2
    //   86: istore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -47 -> 42
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_2
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -55 -> 42
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_2
    //   103: iconst_0
    //   104: istore_1
    //   105: goto -63 -> 42
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_2
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -71 -> 42
    //   116: aload_0
    //   117: iload_1
    //   118: invokespecial 181	com/google/android/gms/internal/zzik:zzam	(I)Lcom/google/android/gms/internal/zzjy;
    //   121: astore_2
    //   122: goto -76 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	zzik
    //   41	77	1	i	int
    //   68	1	2	localTimeoutException	java.util.concurrent.TimeoutException
    //   88	1	2	localObject2	Object
    //   92	1	2	localExecutionException	java.util.concurrent.ExecutionException
    //   94	1	2	localObject3	Object
    //   100	1	2	localInterruptedException	InterruptedException
    //   102	1	2	localObject4	Object
    //   108	1	2	localCancellationException	java.util.concurrent.CancellationException
    //   110	12	2	localzzjy	zzjy
    //   63	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	63	finally
    //   64	66	63	finally
    //   0	7	68	java/util/concurrent/TimeoutException
    //   20	39	68	java/util/concurrent/TimeoutException
    //   66	68	68	java/util/concurrent/TimeoutException
    //   0	7	92	java/util/concurrent/ExecutionException
    //   20	39	92	java/util/concurrent/ExecutionException
    //   66	68	92	java/util/concurrent/ExecutionException
    //   0	7	100	java/lang/InterruptedException
    //   20	39	100	java/lang/InterruptedException
    //   66	68	100	java/lang/InterruptedException
    //   0	7	108	java/util/concurrent/CancellationException
    //   20	39	108	java/util/concurrent/CancellationException
    //   66	68	108	java/util/concurrent/CancellationException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzik
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */