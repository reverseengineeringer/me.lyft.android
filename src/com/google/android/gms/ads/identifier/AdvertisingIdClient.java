package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcc.zza;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  zza zzajb;
  zzcc zzajc;
  boolean zzajd;
  Object zzaje = new Object();
  zza zzajf;
  final long zzajg;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong)
  {
    zzab.zzaa(paramContext);
    mContext = paramContext;
    zzajd = false;
    zzajg = paramLong;
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    paramContext = new AdvertisingIdClient(paramContext, -1L);
    try
    {
      paramContext.zze(false);
      Info localInfo = paramContext.getInfo();
      return localInfo;
    }
    finally
    {
      paramContext.finish();
    }
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  static zzcc zza(Context paramContext, zza paramzza)
    throws IOException
  {
    try
    {
      paramContext = zzcc.zza.zzf(paramzza.zza(10000L, TimeUnit.MILLISECONDS));
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
  }
  
  private void zzdj()
  {
    synchronized (zzaje)
    {
      if (zzajf != null) {
        zzajf.cancel();
      }
    }
    try
    {
      zzajf.join();
      if (zzajg > 0L) {
        zzajf = new zza(this, zzajg);
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  static zza zzh(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (zzc.zzand().isGooglePlayServicesAvailable(paramContext))
      {
      case 1: 
      default: 
        throw new IOException("Google Play services not available");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    zza localzza = new zza();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = zzb.zzaut().zza(paramContext, localIntent, localzza, 1);
      if (bool) {
        return localzza;
      }
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
    throw new IOException("Connection failure");
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc -75
    //   2: invokestatic 184	com/google/android/gms/common/internal/zzab:zzhk	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 45	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 186	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajb	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajd	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 169	com/google/android/gms/common/stats/zzb:zzaut	()Lcom/google/android/gms/common/stats/zzb;
    //   34: aload_0
    //   35: getfield 45	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 186	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajb	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 189	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajd	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 191	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajc	Lcom/google/android/gms/internal/zzcc;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 186	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajb	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: ldc -63
    //   71: ldc -61
    //   73: aload_1
    //   74: invokestatic 201	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   77: pop
    //   78: goto -33 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	AdvertisingIdClient
    //   63	4	1	localObject	Object
    //   68	6	1	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	78	63	finally
    //   24	45	68	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc -75
    //   2: invokestatic 184	com/google/android/gms/common/internal/zzab:zzhk	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajd	Z
    //   11: ifne +83 -> 94
    //   14: aload_0
    //   15: getfield 37	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzaje	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 109	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajf	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 109	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajf	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: invokevirtual 209	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzdk	()Z
    //   35: ifne +23 -> 58
    //   38: new 53	java/io/IOException
    //   41: dup
    //   42: ldc -45
    //   44: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: aload_1
    //   59: monitorexit
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 65	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	(Z)V
    //   65: aload_0
    //   66: getfield 47	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajd	Z
    //   69: ifne +25 -> 94
    //   72: new 53	java/io/IOException
    //   75: dup
    //   76: ldc -43
    //   78: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_1
    //   83: new 53	java/io/IOException
    //   86: dup
    //   87: ldc -43
    //   89: aload_1
    //   90: invokespecial 216	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    //   94: aload_0
    //   95: getfield 186	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajb	Lcom/google/android/gms/common/zza;
    //   98: invokestatic 43	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: getfield 191	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajc	Lcom/google/android/gms/internal/zzcc;
    //   106: invokestatic 43	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   113: dup
    //   114: aload_0
    //   115: getfield 191	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajc	Lcom/google/android/gms/internal/zzcc;
    //   118: invokeinterface 222 1 0
    //   123: aload_0
    //   124: getfield 191	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzajc	Lcom/google/android/gms/internal/zzcc;
    //   127: iconst_1
    //   128: invokeinterface 225 2 0
    //   133: invokespecial 228	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_0
    //   140: invokespecial 230	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzdj	()V
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: ldc -63
    //   148: ldc -24
    //   150: aload_1
    //   151: invokestatic 201	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   154: pop
    //   155: new 53	java/io/IOException
    //   158: dup
    //   159: ldc -22
    //   161: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	AdvertisingIdClient
    //   53	6	1	localObject2	Object
    //   82	8	1	localException	Exception
    //   136	8	1	localInfo	Info
    //   145	6	1	localRemoteException	android.os.RemoteException
    //   48	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	38	48	finally
    //   38	48	48	finally
    //   49	51	48	finally
    //   58	60	48	finally
    //   7	21	53	finally
    //   51	53	53	finally
    //   54	56	53	finally
    //   60	65	53	finally
    //   65	82	53	finally
    //   83	94	53	finally
    //   94	110	53	finally
    //   110	137	53	finally
    //   137	139	53	finally
    //   146	165	53	finally
    //   60	65	82	java/lang/Exception
    //   110	137	145	android/os/RemoteException
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zze(true);
  }
  
  protected void zze(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzab.zzhk("Calling this from your main thread can lead to deadlock");
    try
    {
      if (zzajd) {
        finish();
      }
      zzajb = zzh(mContext);
      zzajc = zza(mContext, zzajb);
      zzajd = true;
      if (paramBoolean) {
        zzdj();
      }
      return;
    }
    finally {}
  }
  
  public static final class Info
  {
    private final String zzajl;
    private final boolean zzajm;
    
    public Info(String paramString, boolean paramBoolean)
    {
      zzajl = paramString;
      zzajm = paramBoolean;
    }
    
    public String getId()
    {
      return zzajl;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return zzajm;
    }
    
    public String toString()
    {
      String str = zzajl;
      boolean bool = zzajm;
      return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
    }
  }
  
  static class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzajh;
    private long zzaji;
    CountDownLatch zzajj;
    boolean zzajk;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      zzajh = new WeakReference(paramAdvertisingIdClient);
      zzaji = paramLong;
      zzajj = new CountDownLatch(1);
      zzajk = false;
      start();
    }
    
    private void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)zzajh.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        zzajk = true;
      }
    }
    
    public void cancel()
    {
      zzajj.countDown();
    }
    
    public void run()
    {
      try
      {
        if (!zzajj.await(zzaji, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }
    
    public boolean zzdk()
    {
      return zzajk;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */