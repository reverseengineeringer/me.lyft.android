package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class zzy
  extends zzm.zza
{
  private final zzx aja;
  private final boolean amQ;
  
  public zzy(zzx paramzzx)
  {
    zzab.zzaa(paramzzx);
    aja = paramzzx;
    amQ = false;
  }
  
  public zzy(zzx paramzzx, boolean paramBoolean)
  {
    zzab.zzaa(paramzzx);
    aja = paramzzx;
    amQ = paramBoolean;
  }
  
  private void zzf(AppMetadata paramAppMetadata)
  {
    zzab.zzaa(paramAppMetadata);
    zzmg(packageName);
    aja.zzbsv().zzmr(ajz);
  }
  
  private void zzmg(String paramString)
    throws SecurityException
  {
    if (TextUtils.isEmpty(paramString))
    {
      aja.zzbsz().zzbtr().log("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
    }
    try
    {
      zzmh(paramString);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      aja.zzbsz().zzbtr().zzj("Measurement Service called with invalid calling package", paramString);
      throw localSecurityException;
    }
  }
  
  /* Error */
  public List<UserAttributeParcel> zza(final AppMetadata paramAppMetadata, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 114	com/google/android/gms/measurement/internal/zzy:zzf	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   5: aload_0
    //   6: getfield 37	com/google/android/gms/measurement/internal/zzy:aja	Lcom/google/android/gms/measurement/internal/zzx;
    //   9: invokevirtual 118	com/google/android/gms/measurement/internal/zzx:zzbsy	()Lcom/google/android/gms/measurement/internal/zzw;
    //   12: new 18	com/google/android/gms/measurement/internal/zzy$7
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 121	com/google/android/gms/measurement/internal/zzy$7:<init>	(Lcom/google/android/gms/measurement/internal/zzy;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   21: invokevirtual 127	com/google/android/gms/measurement/internal/zzw:zzd	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   24: astore_1
    //   25: aload_1
    //   26: invokeinterface 133 1 0
    //   31: checkcast 135	java/util/List
    //   34: astore_3
    //   35: new 137	java/util/ArrayList
    //   38: dup
    //   39: aload_3
    //   40: invokeinterface 141 1 0
    //   45: invokespecial 144	java/util/ArrayList:<init>	(I)V
    //   48: astore_1
    //   49: aload_3
    //   50: invokeinterface 148 1 0
    //   55: astore_3
    //   56: aload_3
    //   57: invokeinterface 154 1 0
    //   62: ifeq +67 -> 129
    //   65: aload_3
    //   66: invokeinterface 157 1 0
    //   71: checkcast 159	com/google/android/gms/measurement/internal/zzak
    //   74: astore 4
    //   76: iload_2
    //   77: ifne +14 -> 91
    //   80: aload 4
    //   82: getfield 162	com/google/android/gms/measurement/internal/zzak:mName	Ljava/lang/String;
    //   85: invokestatic 165	com/google/android/gms/measurement/internal/zzal:zzmu	(Ljava/lang/String;)Z
    //   88: ifne -32 -> 56
    //   91: aload_1
    //   92: new 167	com/google/android/gms/measurement/internal/UserAttributeParcel
    //   95: dup
    //   96: aload 4
    //   98: invokespecial 170	com/google/android/gms/measurement/internal/UserAttributeParcel:<init>	(Lcom/google/android/gms/measurement/internal/zzak;)V
    //   101: invokeinterface 174 2 0
    //   106: pop
    //   107: goto -51 -> 56
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 37	com/google/android/gms/measurement/internal/zzy:aja	Lcom/google/android/gms/measurement/internal/zzx;
    //   115: invokevirtual 82	com/google/android/gms/measurement/internal/zzx:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   118: invokevirtual 88	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   121: ldc -80
    //   123: aload_1
    //   124: invokevirtual 106	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   127: aconst_null
    //   128: areturn
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: goto -21 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	zzy
    //   0	135	1	paramAppMetadata	AppMetadata
    //   0	135	2	paramBoolean	boolean
    //   34	32	3	localObject	Object
    //   74	23	4	localzzak	zzak
    // Exception table:
    //   from	to	target	type
    //   25	56	110	java/lang/InterruptedException
    //   56	76	110	java/lang/InterruptedException
    //   80	91	110	java/lang/InterruptedException
    //   91	107	110	java/lang/InterruptedException
    //   25	56	131	java/util/concurrent/ExecutionException
    //   56	76	131	java/util/concurrent/ExecutionException
    //   80	91	131	java/util/concurrent/ExecutionException
    //   91	107	131	java/util/concurrent/ExecutionException
  }
  
  public void zza(final AppMetadata paramAppMetadata)
  {
    zzf(paramAppMetadata);
    aja.zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this).zzbvd();
        zzmf(paramAppMetadataajD);
        zzy.zza(zzy.this).zzd(paramAppMetadata);
      }
    });
  }
  
  public void zza(final EventParcel paramEventParcel, final AppMetadata paramAppMetadata)
  {
    zzab.zzaa(paramEventParcel);
    zzf(paramAppMetadata);
    aja.zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this).zzbvd();
        zzmf(paramAppMetadataajD);
        zzy.zza(zzy.this).zzb(paramEventParcel, paramAppMetadata);
      }
    });
  }
  
  public void zza(final EventParcel paramEventParcel, final String paramString1, final String paramString2)
  {
    zzab.zzaa(paramEventParcel);
    zzab.zzhs(paramString1);
    zzmg(paramString1);
    aja.zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this).zzbvd();
        zzmf(paramString2);
        zzy.zza(zzy.this).zzb(paramEventParcel, paramString1);
      }
    });
  }
  
  public void zza(final UserAttributeParcel paramUserAttributeParcel, final AppMetadata paramAppMetadata)
  {
    zzab.zzaa(paramUserAttributeParcel);
    zzf(paramAppMetadata);
    if (paramUserAttributeParcel.getValue() == null)
    {
      aja.zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzy.zza(zzy.this).zzbvd();
          zzmf(paramAppMetadataajD);
          zzy.zza(zzy.this).zzc(paramUserAttributeParcel, paramAppMetadata);
        }
      });
      return;
    }
    aja.zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this).zzbvd();
        zzmf(paramAppMetadataajD);
        zzy.zza(zzy.this).zzb(paramUserAttributeParcel, paramAppMetadata);
      }
    });
  }
  
  public byte[] zza(final EventParcel paramEventParcel, final String paramString)
  {
    zzab.zzhs(paramString);
    zzab.zzaa(paramEventParcel);
    zzmg(paramString);
    aja.zzbsz().zzbtx().zzj("Log and bundle. event", name);
    long l1 = aja.zzyw().nanoTime() / 1000000L;
    paramString = aja.zzbsy().zze(new Callable()
    {
      public byte[] zzbvf()
        throws Exception
      {
        zzy.zza(zzy.this).zzbvd();
        return zzy.zza(zzy.this).zza(paramEventParcel, paramString);
      }
    });
    try
    {
      byte[] arrayOfByte = (byte[])paramString.get();
      paramString = arrayOfByte;
      if (arrayOfByte == null)
      {
        aja.zzbsz().zzbtr().log("Log and bundle returned null");
        paramString = new byte[0];
      }
      long l2 = aja.zzyw().nanoTime() / 1000000L;
      aja.zzbsz().zzbtx().zzd("Log and bundle processed. event, size, time_ms", name, Integer.valueOf(paramString.length), Long.valueOf(l2 - l1));
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      aja.zzbsz().zzbtr().zze("Failed to log and bundle. event, error", name, paramString);
      return null;
    }
    catch (ExecutionException paramString)
    {
      for (;;) {}
    }
  }
  
  public void zzb(final AppMetadata paramAppMetadata)
  {
    zzf(paramAppMetadata);
    aja.zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzy.zza(zzy.this).zzbvd();
        zzmf(paramAppMetadataajD);
        zzy.zza(zzy.this).zzc(paramAppMetadata);
      }
    });
  }
  
  void zzmf(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(":", 2);
      if (paramString.length != 2) {}
    }
    long l;
    try
    {
      l = Long.valueOf(paramString[0]).longValue();
      if (l > 0L)
      {
        aja.zzbta().alu.zzg(paramString[1], l);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      aja.zzbsz().zzbtt().zzj("Combining sample with a non-number weight", paramString[0]);
      return;
    }
    aja.zzbsz().zzbtt().zzj("Combining sample with a non-positive weight", Long.valueOf(l));
  }
  
  protected void zzmh(String paramString)
    throws SecurityException
  {
    int i;
    if (amQ)
    {
      i = Process.myUid();
      if (!com.google.android.gms.common.util.zzy.zzb(aja.getContext(), i, paramString)) {
        break label34;
      }
    }
    label34:
    while ((com.google.android.gms.common.util.zzy.zze(aja.getContext(), i)) && (!aja.zzbuu()))
    {
      return;
      i = Binder.getCallingUid();
      break;
    }
    throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */