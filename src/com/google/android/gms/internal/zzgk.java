package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzir
public class zzgk
  implements zzgc
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzgn zzajz;
  private final boolean zzarj;
  private final boolean zzawl;
  private final zzge zzboi;
  private final AdRequestInfoParcel zzbox;
  private final long zzboy;
  private final long zzboz;
  private final int zzbpa;
  private boolean zzbpb = false;
  private final Map<zzlc<zzgi>, zzgh> zzbpc = new HashMap();
  private List<zzgi> zzbpd = new ArrayList();
  
  public zzgk(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzgn paramzzgn, zzge paramzzge, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt)
  {
    mContext = paramContext;
    zzbox = paramAdRequestInfoParcel;
    zzajz = paramzzgn;
    zzboi = paramzzge;
    zzarj = paramBoolean1;
    zzawl = paramBoolean2;
    zzboy = paramLong1;
    zzboz = paramLong2;
    zzbpa = paramInt;
  }
  
  private void zza(final zzlc<zzgi> paramzzlc)
  {
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = zzgk.zze(zzgk.this).keySet().iterator();
        while (localIterator.hasNext())
        {
          zzlc localzzlc = (zzlc)localIterator.next();
          if (localzzlc != paramzzlc) {
            ((zzgh)zzgk.zze(zzgk.this).get(localzzlc)).cancel();
          }
        }
      }
    });
  }
  
  private zzgi zze(List<zzlc<zzgi>> paramList)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzbpb)
        {
          paramList = new zzgi(-1);
          return paramList;
        }
        ??? = paramList.iterator();
        if (((Iterator)???).hasNext()) {
          paramList = (zzlc)((Iterator)???).next();
        }
      }
      try
      {
        zzgi localzzgi = (zzgi)paramList.get();
        zzbpd.add(localzzgi);
        if ((localzzgi == null) || (zzboq != 0)) {
          continue;
        }
        zza(paramList);
        return localzzgi;
      }
      catch (InterruptedException paramList)
      {
        zzkh.zzd("Exception while processing an adapter; continuing with other adapters", paramList);
        continue;
        paramList = finally;
        throw paramList;
        zza(null);
        return new zzgi(1);
      }
      catch (ExecutionException paramList)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private zzgi zzf(List<zzlc<zzgi>> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/google/android/gms/internal/zzgk:zzail	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 45	com/google/android/gms/internal/zzgk:zzbpb	Z
    //   13: ifeq +17 -> 30
    //   16: new 107	com/google/android/gms/internal/zzgi
    //   19: dup
    //   20: iconst_m1
    //   21: invokespecial 110	com/google/android/gms/internal/zzgi:<init>	(I)V
    //   24: astore_1
    //   25: aload 8
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload 8
    //   32: monitorexit
    //   33: iconst_m1
    //   34: istore_2
    //   35: aconst_null
    //   36: astore 8
    //   38: aconst_null
    //   39: astore 9
    //   41: aload_0
    //   42: getfield 63	com/google/android/gms/internal/zzgk:zzboi	Lcom/google/android/gms/internal/zzge;
    //   45: getfield 159	com/google/android/gms/internal/zzge:zzboa	J
    //   48: ldc2_w 160
    //   51: lcmp
    //   52: ifeq +170 -> 222
    //   55: aload_0
    //   56: getfield 63	com/google/android/gms/internal/zzgk:zzboi	Lcom/google/android/gms/internal/zzge;
    //   59: getfield 159	com/google/android/gms/internal/zzge:zzboa	J
    //   62: lstore 4
    //   64: aload_1
    //   65: invokeinterface 116 1 0
    //   70: astore 11
    //   72: aload 11
    //   74: invokeinterface 122 1 0
    //   79: ifeq +225 -> 304
    //   82: aload 11
    //   84: invokeinterface 126 1 0
    //   89: checkcast 128	com/google/android/gms/internal/zzlc
    //   92: astore 10
    //   94: invokestatic 167	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   97: invokeinterface 173 1 0
    //   102: lstore 6
    //   104: lload 4
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +122 -> 230
    //   111: aload 10
    //   113: invokeinterface 176 1 0
    //   118: ifeq +112 -> 230
    //   121: aload 10
    //   123: invokeinterface 131 1 0
    //   128: checkcast 107	com/google/android/gms/internal/zzgi
    //   131: astore_1
    //   132: aload_0
    //   133: getfield 55	com/google/android/gms/internal/zzgk:zzbpd	Ljava/util/List;
    //   136: aload_1
    //   137: invokeinterface 135 2 0
    //   142: pop
    //   143: aload_1
    //   144: ifnull +192 -> 336
    //   147: aload_1
    //   148: getfield 138	com/google/android/gms/internal/zzgi:zzboq	I
    //   151: ifne +185 -> 336
    //   154: aload_1
    //   155: getfield 180	com/google/android/gms/internal/zzgi:zzbov	Lcom/google/android/gms/internal/zzgq;
    //   158: astore 12
    //   160: aload 12
    //   162: ifnull +174 -> 336
    //   165: aload 12
    //   167: invokeinterface 186 1 0
    //   172: iload_2
    //   173: if_icmple +163 -> 336
    //   176: aload 12
    //   178: invokeinterface 186 1 0
    //   183: istore_3
    //   184: iload_3
    //   185: istore_2
    //   186: aload 10
    //   188: astore 8
    //   190: lload 4
    //   192: invokestatic 167	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   195: invokeinterface 173 1 0
    //   200: lload 6
    //   202: lsub
    //   203: lsub
    //   204: lconst_0
    //   205: invokestatic 192	java/lang/Math:max	(JJ)J
    //   208: lstore 4
    //   210: aload_1
    //   211: astore 9
    //   213: goto -141 -> 72
    //   216: astore_1
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: ldc2_w 193
    //   225: lstore 4
    //   227: goto -163 -> 64
    //   230: aload 10
    //   232: lload 4
    //   234: getstatic 200	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   237: invokeinterface 203 4 0
    //   242: checkcast 107	com/google/android/gms/internal/zzgi
    //   245: astore_1
    //   246: goto -114 -> 132
    //   249: astore_1
    //   250: ldc -114
    //   252: aload_1
    //   253: invokestatic 147	com/google/android/gms/internal/zzkh:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: lload 4
    //   258: invokestatic 167	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   261: invokeinterface 173 1 0
    //   266: lload 6
    //   268: lsub
    //   269: lsub
    //   270: lconst_0
    //   271: invokestatic 192	java/lang/Math:max	(JJ)J
    //   274: lstore 4
    //   276: aload 9
    //   278: astore_1
    //   279: goto -69 -> 210
    //   282: astore_1
    //   283: lload 4
    //   285: invokestatic 167	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   288: invokeinterface 173 1 0
    //   293: lload 6
    //   295: lsub
    //   296: lsub
    //   297: lconst_0
    //   298: invokestatic 192	java/lang/Math:max	(JJ)J
    //   301: pop2
    //   302: aload_1
    //   303: athrow
    //   304: aload_0
    //   305: aload 8
    //   307: invokespecial 140	com/google/android/gms/internal/zzgk:zza	(Lcom/google/android/gms/internal/zzlc;)V
    //   310: aload 9
    //   312: ifnonnull +30 -> 342
    //   315: new 107	com/google/android/gms/internal/zzgi
    //   318: dup
    //   319: iconst_1
    //   320: invokespecial 110	com/google/android/gms/internal/zzgi:<init>	(I)V
    //   323: areturn
    //   324: astore_1
    //   325: goto -75 -> 250
    //   328: astore_1
    //   329: goto -79 -> 250
    //   332: astore_1
    //   333: goto -83 -> 250
    //   336: aload 9
    //   338: astore_1
    //   339: goto -149 -> 190
    //   342: aload 9
    //   344: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	zzgk
    //   0	345	1	paramList	List<zzlc<zzgi>>
    //   34	152	2	i	int
    //   183	2	3	j	int
    //   62	222	4	l1	long
    //   102	192	6	l2	long
    //   4	302	8	localObject	Object
    //   39	304	9	localList	List<zzlc<zzgi>>
    //   92	139	10	localzzlc	zzlc
    //   70	13	11	localIterator	Iterator
    //   158	19	12	localzzgq	zzgq
    // Exception table:
    //   from	to	target	type
    //   9	28	216	finally
    //   30	33	216	finally
    //   217	220	216	finally
    //   111	132	249	java/lang/InterruptedException
    //   132	143	249	java/lang/InterruptedException
    //   147	160	249	java/lang/InterruptedException
    //   165	184	249	java/lang/InterruptedException
    //   230	246	249	java/lang/InterruptedException
    //   111	132	282	finally
    //   132	143	282	finally
    //   147	160	282	finally
    //   165	184	282	finally
    //   230	246	282	finally
    //   250	256	282	finally
    //   111	132	324	java/util/concurrent/TimeoutException
    //   132	143	324	java/util/concurrent/TimeoutException
    //   147	160	324	java/util/concurrent/TimeoutException
    //   165	184	324	java/util/concurrent/TimeoutException
    //   230	246	324	java/util/concurrent/TimeoutException
    //   111	132	328	java/util/concurrent/ExecutionException
    //   132	143	328	java/util/concurrent/ExecutionException
    //   147	160	328	java/util/concurrent/ExecutionException
    //   165	184	328	java/util/concurrent/ExecutionException
    //   230	246	328	java/util/concurrent/ExecutionException
    //   111	132	332	android/os/RemoteException
    //   132	143	332	android/os/RemoteException
    //   147	160	332	android/os/RemoteException
    //   165	184	332	android/os/RemoteException
    //   230	246	332	android/os/RemoteException
  }
  
  public void cancel()
  {
    synchronized (zzail)
    {
      zzbpb = true;
      Iterator localIterator = zzbpc.values().iterator();
      if (localIterator.hasNext()) {
        ((zzgh)localIterator.next()).cancel();
      }
    }
  }
  
  public zzgi zzd(List<zzgd> paramList)
  {
    zzkh.zzcw("Starting mediation.");
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      zzgd localzzgd = (zzgd)localIterator.next();
      paramList = String.valueOf(zzbmz);
      if (paramList.length() != 0) {}
      for (paramList = "Trying mediation network: ".concat(paramList);; paramList = new String("Trying mediation network: "))
      {
        zzkh.zzcx(paramList);
        paramList = zzbna.iterator();
        while (paramList.hasNext())
        {
          final Object localObject = (String)paramList.next();
          localObject = new zzgh(mContext, (String)localObject, zzajz, zzboi, localzzgd, zzbox.zzcav, zzbox.zzaoy, zzbox.zzaou, zzarj, zzawl, zzbox.zzapm, zzbox.zzapq);
          zzlc localzzlc = zzkk.zza(localExecutorService, new Callable()
          {
            public zzgi zzmp()
              throws Exception
            {
              synchronized (zzgk.zza(zzgk.this))
              {
                if (zzgk.zzb(zzgk.this)) {
                  return null;
                }
                return localObject.zza(zzgk.zzc(zzgk.this), zzgk.zzd(zzgk.this));
              }
            }
          });
          zzbpc.put(localzzlc, localObject);
          localArrayList.add(localzzlc);
        }
        break;
      }
    }
    switch (zzbpa)
    {
    default: 
      return zze(localArrayList);
    }
    return zzf(localArrayList);
  }
  
  public List<zzgi> zzmi()
  {
    return zzbpd;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */