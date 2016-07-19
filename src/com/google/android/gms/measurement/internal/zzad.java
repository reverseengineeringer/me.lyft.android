package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzad
  extends zzaa
{
  private final zza anl;
  private zzm anm;
  private Boolean ann;
  private final zzf ano;
  private final zzah anp;
  private final List<Runnable> anq = new ArrayList();
  private final zzf anr;
  
  protected zzad(zzx paramzzx)
  {
    super(paramzzx);
    anp = new zzah(paramzzx.zzyw());
    anl = new zza();
    ano = new zzf(paramzzx)
    {
      public void run()
      {
        zzad.zzb(zzad.this);
      }
    };
    anr = new zzf(paramzzx)
    {
      public void run()
      {
        zzbsz().zzbtt().log("Tasks have been queued for a long time");
      }
    };
  }
  
  private void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzwu();
    if (anm != null)
    {
      anm = null;
      zzbsz().zzbty().zzj("Disconnected from device MeasurementService", paramComponentName);
      zzbvq();
    }
  }
  
  private void zza(zzm paramzzm)
  {
    zzwu();
    zzab.zzaa(paramzzm);
    anm = paramzzm;
    zzzt();
    zzbvr();
  }
  
  private boolean zzbvo()
  {
    List localList = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
    return (localList != null) && (localList.size() > 0);
  }
  
  private void zzbvq()
  {
    zzwu();
    zzaai();
  }
  
  private void zzbvr()
  {
    zzwu();
    zzbsz().zzbty().zzj("Processing queued up service tasks", Integer.valueOf(anq.size()));
    Iterator localIterator = anq.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      zzbsy().zzl(localRunnable);
    }
    anq.clear();
    anr.cancel();
  }
  
  private void zzn(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzwu();
    if (isConnected())
    {
      paramRunnable.run();
      return;
    }
    if (anq.size() >= zzbtb().zzbsd())
    {
      zzbsz().zzbtr().log("Discarding data. Max runnable queue size reached");
      return;
    }
    anq.add(paramRunnable);
    if (!aja.zzbuu()) {
      anr.zzv(60000L);
    }
    zzaai();
  }
  
  private void zzzt()
  {
    zzwu();
    anp.start();
    if (!aja.zzbuu()) {
      ano.zzv(zzbtb().zzabx());
    }
  }
  
  private void zzzu()
  {
    zzwu();
    if (!isConnected()) {
      return;
    }
    zzbsz().zzbty().log("Inactivity, disconnecting from AppMeasurementService");
    disconnect();
  }
  
  public void disconnect()
  {
    zzwu();
    zzzg();
    try
    {
      zzb.zzaut().zza(getContext(), anl);
      anm = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public boolean isConnected()
  {
    zzwu();
    zzzg();
    return anm != null;
  }
  
  protected void zza(final UserAttributeParcel paramUserAttributeParcel)
  {
    zzwu();
    zzzg();
    zzn(new Runnable()
    {
      public void run()
      {
        zzm localzzm = zzad.zzc(zzad.this);
        if (localzzm == null)
        {
          zzbsz().zzbtr().log("Discarding data. Failed to set user attribute");
          return;
        }
        try
        {
          localzzm.zza(paramUserAttributeParcel, zzbsr().zzlw(zzbsz().zzbtz()));
          zzad.zzd(zzad.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzbsz().zzbtr().zzj("Failed to send attribute to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  void zzaai()
  {
    zzwu();
    zzzg();
    if (isConnected()) {
      return;
    }
    if (ann == null)
    {
      ann = zzbta().zzbuf();
      if (ann == null)
      {
        zzbsz().zzbty().log("State of service unknown");
        ann = Boolean.valueOf(zzbvp());
        zzbta().zzca(ann.booleanValue());
      }
    }
    if (ann.booleanValue())
    {
      zzbsz().zzbty().log("Using measurement service");
      anl.zzbvs();
      return;
    }
    if ((!aja.zzbuu()) && (zzbvo()))
    {
      zzbsz().zzbty().log("Using local app measurement service");
      Intent localIntent = new Intent("com.google.android.gms.measurement.START");
      localIntent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
      anl.zzx(localIntent);
      return;
    }
    if (zzbtb().zzabd())
    {
      zzbsz().zzbty().log("Using direct local measurement implementation");
      zza(new zzy(aja, true));
      return;
    }
    zzbsz().zzbtr().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
  }
  
  protected void zzbvk()
  {
    zzwu();
    zzzg();
    zzn(new Runnable()
    {
      public void run()
      {
        zzm localzzm = zzad.zzc(zzad.this);
        if (localzzm == null)
        {
          zzbsz().zzbtr().log("Discarding data. Failed to send app launch");
          return;
        }
        try
        {
          localzzm.zza(zzbsr().zzlw(zzbsz().zzbtz()));
          zzad.zzd(zzad.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzbsz().zzbtr().zzj("Failed to send app launch to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected void zzbvn()
  {
    zzwu();
    zzzg();
    zzn(new Runnable()
    {
      public void run()
      {
        zzm localzzm = zzad.zzc(zzad.this);
        if (localzzm == null)
        {
          zzbsz().zzbtr().log("Failed to send measurementEnabled to service");
          return;
        }
        try
        {
          localzzm.zzb(zzbsr().zzlw(zzbsz().zzbtz()));
          zzad.zzd(zzad.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzbsz().zzbtr().zzj("Failed to send measurementEnabled to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected boolean zzbvp()
  {
    zzwu();
    zzzg();
    if (zzbtb().zzabc()) {
      return true;
    }
    zzbsz().zzbty().log("Checking service availability");
    switch (zzc.zzand().isGooglePlayServicesAvailable(getContext()))
    {
    default: 
      return false;
    case 0: 
      zzbsz().zzbty().log("Service available");
      return true;
    case 1: 
      zzbsz().zzbty().log("Service missing");
      return false;
    case 18: 
      zzbsz().zzbtt().log("Service updating");
      return true;
    case 2: 
      zzbsz().zzbtx().log("Service container out of date");
      return true;
    case 3: 
      zzbsz().zzbtt().log("Service disabled");
      return false;
    }
    zzbsz().zzbtt().log("Service invalid");
    return false;
  }
  
  protected void zzc(final EventParcel paramEventParcel, final String paramString)
  {
    zzab.zzaa(paramEventParcel);
    zzwu();
    zzzg();
    zzn(new Runnable()
    {
      public void run()
      {
        zzm localzzm = zzad.zzc(zzad.this);
        if (localzzm == null)
        {
          zzbsz().zzbtr().log("Discarding data. Failed to send event to service");
          return;
        }
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty(paramString))
            {
              localzzm.zza(paramEventParcel, zzbsr().zzlw(zzbsz().zzbtz()));
              zzad.zzd(zzad.this);
              return;
            }
          }
          catch (RemoteException localRemoteException)
          {
            zzbsz().zzbtr().zzj("Failed to send event to AppMeasurementService", localRemoteException);
            return;
          }
          localRemoteException.zza(paramEventParcel, paramString, zzbsz().zzbtz());
        }
      }
    });
  }
  
  protected void zzwv() {}
  
  protected class zza
    implements ServiceConnection, zzd.zzb, zzd.zzc
  {
    private volatile boolean anu;
    private volatile zzo anv;
    
    protected zza() {}
    
    /* Error */
    public void onConnected(final android.os.Bundle paramBundle)
    {
      // Byte code:
      //   0: ldc 46
      //   2: invokestatic 52	com/google/android/gms/common/internal/zzab:zzhj	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 54	com/google/android/gms/measurement/internal/zzad$zza:anv	Lcom/google/android/gms/measurement/internal/zzo;
      //   11: invokevirtual 60	com/google/android/gms/measurement/internal/zzo:zzarw	()Landroid/os/IInterface;
      //   14: checkcast 62	com/google/android/gms/measurement/internal/zzm
      //   17: astore_1
      //   18: aload_0
      //   19: aconst_null
      //   20: putfield 54	com/google/android/gms/measurement/internal/zzad$zza:anv	Lcom/google/android/gms/measurement/internal/zzo;
      //   23: aload_0
      //   24: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   27: invokevirtual 66	com/google/android/gms/measurement/internal/zzad:zzbsy	()Lcom/google/android/gms/measurement/internal/zzw;
      //   30: new 19	com/google/android/gms/measurement/internal/zzad$zza$3
      //   33: dup
      //   34: aload_0
      //   35: aload_1
      //   36: invokespecial 69	com/google/android/gms/measurement/internal/zzad$zza$3:<init>	(Lcom/google/android/gms/measurement/internal/zzad$zza;Lcom/google/android/gms/measurement/internal/zzm;)V
      //   39: invokevirtual 75	com/google/android/gms/measurement/internal/zzw:zzl	(Ljava/lang/Runnable;)V
      //   42: aload_0
      //   43: monitorexit
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 54	com/google/android/gms/measurement/internal/zzad$zza:anv	Lcom/google/android/gms/measurement/internal/zzo;
      //   50: aload_0
      //   51: iconst_0
      //   52: putfield 38	com/google/android/gms/measurement/internal/zzad$zza:anu	Z
      //   55: goto -13 -> 42
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      //   63: astore_1
      //   64: goto -19 -> 45
      //   67: astore_1
      //   68: goto -23 -> 45
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	zza
      //   0	71	1	paramBundle	android.os.Bundle
      // Exception table:
      //   from	to	target	type
      //   7	42	58	finally
      //   42	44	58	finally
      //   45	55	58	finally
      //   59	61	58	finally
      //   7	42	63	java/lang/IllegalStateException
      //   7	42	67	android/os/DeadObjectException
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzab.zzhj("MeasurementServiceConnection.onConnectionFailed");
      zzp localzzp = aja.zzbul();
      if (localzzp != null) {
        localzzp.zzbtt().zzj("Service connection failed", paramConnectionResult);
      }
      try
      {
        anu = false;
        anv = null;
        return;
      }
      finally {}
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzab.zzhj("MeasurementServiceConnection.onConnectionSuspended");
      zzbsz().zzbtx().log("Service connection suspended");
      zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzad.zza(zzad.this, new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
        }
      });
    }
    
    /* Error */
    public void onServiceConnected(final ComponentName paramComponentName, android.os.IBinder paramIBinder)
    {
      // Byte code:
      //   0: ldc -127
      //   2: invokestatic 52	com/google/android/gms/common/internal/zzab:zzhj	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_2
      //   8: ifnonnull +26 -> 34
      //   11: aload_0
      //   12: iconst_0
      //   13: putfield 38	com/google/android/gms/measurement/internal/zzad$zza:anu	Z
      //   16: aload_0
      //   17: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   20: invokevirtual 110	com/google/android/gms/measurement/internal/zzad:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
      //   23: invokevirtual 132	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   26: ldc -122
      //   28: invokevirtual 118	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: aconst_null
      //   35: astore 4
      //   37: aconst_null
      //   38: astore_3
      //   39: aload 4
      //   41: astore_1
      //   42: aload_2
      //   43: invokeinterface 140 1 0
      //   48: astore 5
      //   50: aload 4
      //   52: astore_1
      //   53: ldc -114
      //   55: aload 5
      //   57: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   60: ifeq +67 -> 127
      //   63: aload 4
      //   65: astore_1
      //   66: aload_2
      //   67: invokestatic 154	com/google/android/gms/measurement/internal/zzm$zza:zzjb	(Landroid/os/IBinder;)Lcom/google/android/gms/measurement/internal/zzm;
      //   70: astore_2
      //   71: aload_2
      //   72: astore_1
      //   73: aload_0
      //   74: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   77: invokevirtual 110	com/google/android/gms/measurement/internal/zzad:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
      //   80: invokevirtual 157	com/google/android/gms/measurement/internal/zzp:zzbty	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   83: ldc -97
      //   85: invokevirtual 118	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
      //   88: aload_2
      //   89: astore_1
      //   90: aload_1
      //   91: ifnonnull +80 -> 171
      //   94: aload_0
      //   95: iconst_0
      //   96: putfield 38	com/google/android/gms/measurement/internal/zzad$zza:anu	Z
      //   99: invokestatic 165	com/google/android/gms/common/stats/zzb:zzaut	()Lcom/google/android/gms/common/stats/zzb;
      //   102: aload_0
      //   103: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   106: invokevirtual 169	com/google/android/gms/measurement/internal/zzad:getContext	()Landroid/content/Context;
      //   109: aload_0
      //   110: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   113: invokestatic 172	com/google/android/gms/measurement/internal/zzad:zza	(Lcom/google/android/gms/measurement/internal/zzad;)Lcom/google/android/gms/measurement/internal/zzad$zza;
      //   116: invokevirtual 175	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
      //   119: aload_0
      //   120: monitorexit
      //   121: return
      //   122: astore_1
      //   123: aload_0
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: aload 4
      //   129: astore_1
      //   130: aload_0
      //   131: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   134: invokevirtual 110	com/google/android/gms/measurement/internal/zzad:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
      //   137: invokevirtual 132	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   140: ldc -79
      //   142: aload 5
      //   144: invokevirtual 103	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   147: aload_3
      //   148: astore_1
      //   149: goto -59 -> 90
      //   152: astore_2
      //   153: aload_0
      //   154: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   157: invokevirtual 110	com/google/android/gms/measurement/internal/zzad:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
      //   160: invokevirtual 132	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   163: ldc -77
      //   165: invokevirtual 118	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
      //   168: goto -78 -> 90
      //   171: aload_0
      //   172: getfield 31	com/google/android/gms/measurement/internal/zzad$zza:ans	Lcom/google/android/gms/measurement/internal/zzad;
      //   175: invokevirtual 66	com/google/android/gms/measurement/internal/zzad:zzbsy	()Lcom/google/android/gms/measurement/internal/zzw;
      //   178: new 15	com/google/android/gms/measurement/internal/zzad$zza$1
      //   181: dup
      //   182: aload_0
      //   183: aload_1
      //   184: invokespecial 180	com/google/android/gms/measurement/internal/zzad$zza$1:<init>	(Lcom/google/android/gms/measurement/internal/zzad$zza;Lcom/google/android/gms/measurement/internal/zzm;)V
      //   187: invokevirtual 75	com/google/android/gms/measurement/internal/zzw:zzl	(Ljava/lang/Runnable;)V
      //   190: goto -71 -> 119
      //   193: astore_1
      //   194: goto -75 -> 119
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	zza
      //   0	197	1	paramComponentName	ComponentName
      //   0	197	2	paramIBinder	android.os.IBinder
      //   38	110	3	localObject1	Object
      //   35	93	4	localObject2	Object
      //   48	95	5	str	String
      // Exception table:
      //   from	to	target	type
      //   11	33	122	finally
      //   42	50	122	finally
      //   53	63	122	finally
      //   66	71	122	finally
      //   73	88	122	finally
      //   94	99	122	finally
      //   99	119	122	finally
      //   119	121	122	finally
      //   123	125	122	finally
      //   130	147	122	finally
      //   153	168	122	finally
      //   171	190	122	finally
      //   42	50	152	android/os/RemoteException
      //   53	63	152	android/os/RemoteException
      //   66	71	152	android/os/RemoteException
      //   73	88	152	android/os/RemoteException
      //   130	147	152	android/os/RemoteException
      //   99	119	193	java/lang/IllegalArgumentException
    }
    
    public void onServiceDisconnected(final ComponentName paramComponentName)
    {
      zzab.zzhj("MeasurementServiceConnection.onServiceDisconnected");
      zzbsz().zzbtx().log("Service disconnected");
      zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzad.zza(zzad.this, paramComponentName);
        }
      });
    }
    
    public void zzbvs()
    {
      zzwu();
      Context localContext1 = getContext();
      try
      {
        if (anu)
        {
          zzbsz().zzbty().log("Connection attempt already in progress");
          return;
        }
        if (anv != null)
        {
          zzbsz().zzbty().log("Already awaiting connection attempt");
          return;
        }
      }
      finally {}
      anv = new zzo(localContext2, Looper.getMainLooper(), this, this);
      zzbsz().zzbty().log("Connecting to remote service");
      anu = true;
      anv.zzart();
    }
    
    public void zzx(Intent paramIntent)
    {
      zzwu();
      Context localContext = getContext();
      zzb localzzb = zzb.zzaut();
      try
      {
        if (anu)
        {
          zzbsz().zzbty().log("Connection attempt already in progress");
          return;
        }
        anu = true;
        localzzb.zza(localContext, paramIntent, zzad.zza(zzad.this), 129);
        return;
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */