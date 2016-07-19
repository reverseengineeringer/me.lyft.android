package com.google.android.gms.internal;

import android.util.SparseArray;
import com.google.android.gms.common.api.zzc;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzqh$zzb
  extends Thread
{
  private final ReferenceQueue<zzc<?>> uD;
  private final SparseArray<zzqh.zza> uE;
  private final AtomicBoolean uH = new AtomicBoolean();
  
  public zzqh$zzb(ReferenceQueue<zzc<?>> paramReferenceQueue, SparseArray<zzqh.zza> paramSparseArray)
  {
    super("GoogleApiCleanup");
    uD = paramReferenceQueue;
    uE = paramSparseArray;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_1
    //   5: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   8: bipush 10
    //   10: invokestatic 51	android/os/Process:setThreadPriority	(I)V
    //   13: aload_0
    //   14: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: invokevirtual 55	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   20: ifeq +42 -> 62
    //   23: aload_0
    //   24: getfield 31	com/google/android/gms/internal/zzqh$zzb:uD	Ljava/lang/ref/ReferenceQueue;
    //   27: invokevirtual 61	java/lang/ref/ReferenceQueue:remove	()Ljava/lang/ref/Reference;
    //   30: checkcast 63	com/google/android/gms/internal/zzqh$zza
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 33	com/google/android/gms/internal/zzqh$zzb:uE	Landroid/util/SparseArray;
    //   38: aload_1
    //   39: invokestatic 66	com/google/android/gms/internal/zzqh$zza:zza	(Lcom/google/android/gms/internal/zzqh$zza;)I
    //   42: invokevirtual 70	android/util/SparseArray:remove	(I)V
    //   45: aload_1
    //   46: invokevirtual 73	com/google/android/gms/internal/zzqh$zza:zzaqd	()V
    //   49: goto -36 -> 13
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   57: iconst_0
    //   58: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   61: return
    //   62: aload_0
    //   63: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   66: iconst_0
    //   67: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 29	com/google/android/gms/internal/zzqh$zzb:uH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_0
    //   77: invokevirtual 45	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	zzb
    //   33	13	1	localzza	zzqh.zza
    //   52	1	1	localInterruptedException	InterruptedException
    //   71	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	49	52	java/lang/InterruptedException
    //   13	49	71	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqh.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */