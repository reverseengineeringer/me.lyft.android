package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb
  extends Service
{
  private int aay;
  private int aaz = 0;
  MessengerCompat abV = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = MessengerCompat.zzc(paramAnonymousMessage);
      zzf.zzdi(zzb.this);
      getPackageManager();
      if ((i != zzf.ach) && (i != zzf.acg))
      {
        int j = zzf.acg;
        int k = zzf.ach;
        Log.w("FirebaseInstanceId", 77 + "Message from unexpected caller " + i + " mine=" + j + " appid=" + k);
        return;
      }
      zzm((Intent)obj);
    }
  });
  final ExecutorService axF = Executors.newSingleThreadExecutor();
  private final Object zzail = new Object();
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.firebase.INSTANCE_ID_EVENT".equals(paramIntent.getAction()))) {
      return abV.getBinder();
    }
    return null;
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        aay = paramInt2;
        aaz += 1;
        paramIntent = zzz(paramIntent);
        if (paramIntent == null)
        {
          zzbmb();
          paramInt1 = 2;
          return paramInt1;
        }
      }
      try
      {
        paramInt2 = zzaa(paramIntent);
        paramInt1 = paramInt2;
        return paramInt2;
      }
      finally
      {
        if (paramIntent.getStringExtra("from") != null) {
          WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
        }
      }
    }
  }
  
  protected int zzaa(final Intent paramIntent)
  {
    axF.execute(new Runnable()
    {
      public void run()
      {
        zzm(paramIntent);
        zzbmb();
      }
    });
    return 3;
  }
  
  protected void zzbmb()
  {
    synchronized (zzail)
    {
      aaz -= 1;
      if (aaz == 0) {
        zzsh(aay);
      }
      return;
    }
  }
  
  public abstract void zzm(Intent paramIntent);
  
  boolean zzsh(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  protected abstract Intent zzz(Intent paramIntent);
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */