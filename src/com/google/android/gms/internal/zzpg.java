package com.google.android.gms.internal;

import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.clearcut.zzb.zzc;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class zzpg
  implements zzc
{
  private static final Object qu = new Object();
  private static ScheduledExecutorService qv;
  private static final zze qw = new zze(null);
  private static final long qx = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
  private GoogleApiClient hb = null;
  private long qA = 0L;
  private final long qB;
  private ScheduledFuture<?> qC = null;
  private final Runnable qD = new Runnable()
  {
    public void run()
    {
      synchronized (zzpg.zza(zzpg.this))
      {
        if ((zzpg.zzb(zzpg.this) <= zzpg.zzc(zzpg.this).elapsedRealtime()) && (zzpg.zzd(zzpg.this) != null))
        {
          Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
          zzpg.zzd(zzpg.this).disconnect();
          zzpg.zza(zzpg.this, null);
        }
        return;
      }
    }
  };
  private final zza qy;
  private final Object qz = new Object();
  private final zze zzaoa;
  
  public zzpg()
  {
    this(new zzh(), qx, new zzb());
  }
  
  public zzpg(zze paramzze, long paramLong, zza paramzza)
  {
    zzaoa = paramzze;
    qB = paramLong;
    qy = paramzza;
  }
  
  private PendingResult<Status> zza(final GoogleApiClient paramGoogleApiClient, final zzc<Status> paramzzc)
  {
    zzamx().execute(new Runnable()
    {
      public void run()
      {
        paramGoogleApiClient.zzc(paramzzc);
      }
    });
    return paramzzc;
  }
  
  private static void zza(LogEventParcelable paramLogEventParcelable)
  {
    if ((qs != null) && (qr.biM.length == 0)) {
      qr.biM = qs.zzamw();
    }
    if ((qt != null) && (qr.biT.length == 0)) {
      qr.biT = qt.zzamw();
    }
    ql = zzapc.zzf(qr);
  }
  
  private ScheduledExecutorService zzamx()
  {
    synchronized (qu)
    {
      if (qv == null) {
        qv = Executors.newSingleThreadScheduledExecutor(new ThreadFactory()
        {
          public Thread newThread(final Runnable paramAnonymousRunnable)
          {
            new Thread(new Runnable()
            {
              public void run()
              {
                Process.setThreadPriority(10);
                paramAnonymousRunnable.run();
              }
            }, "ClearcutLoggerApiImpl");
          }
        });
      }
      return qv;
    }
  }
  
  private zzd zzb(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable)
  {
    qw.zzamz();
    paramGoogleApiClient = new zzd(paramLogEventParcelable, paramGoogleApiClient);
    paramGoogleApiClient.zza(new PendingResult.zza()
    {
      public void zzv(Status paramAnonymousStatus)
      {
        zzpg.zzamy().zzana();
      }
    });
    return paramGoogleApiClient;
  }
  
  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable)
  {
    return zza(paramGoogleApiClient, zzb(paramGoogleApiClient, paramLogEventParcelable));
  }
  
  public static abstract interface zza {}
  
  public static class zzb
    implements zzpg.zza
  {}
  
  static abstract class zzc<R extends Result>
    extends zzpr.zza<R, zzph>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  static final class zzd
    extends zzpg.zzc<Status>
  {
    private final LogEventParcelable qI;
    
    zzd(LogEventParcelable paramLogEventParcelable, GoogleApiClient paramGoogleApiClient)
    {
      super();
      qI = paramLogEventParcelable;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
      return qI.equals(qI);
    }
    
    public String toString()
    {
      String str = String.valueOf(qI);
      return String.valueOf(str).length() + 12 + "MethodImpl(" + str + ")";
    }
    
    protected void zza(zzph paramzzph)
      throws RemoteException
    {
      zzpj.zza local1 = new zzpj.zza()
      {
        public void zzw(Status paramAnonymousStatus)
        {
          zzc(paramAnonymousStatus);
        }
      };
      try
      {
        zzpg.zzb(qI);
        paramzzph.zza(local1, qI);
        return;
      }
      catch (RuntimeException paramzzph)
      {
        Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", paramzzph);
        zzz(new Status(10, "MessageProducer"));
      }
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static final class zze
  {
    private int mSize = 0;
    
    public void zzamz()
    {
      try
      {
        mSize += 1;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void zzana()
    {
      try
      {
        if (mSize == 0) {
          throw new RuntimeException("too many decrements");
        }
      }
      finally {}
      mSize -= 1;
      if (mSize == 0) {
        notifyAll();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */