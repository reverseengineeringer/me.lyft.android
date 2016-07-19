package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class AdvertisingIdClient$zza
  extends Thread
{
  private WeakReference<AdvertisingIdClient> zzajh;
  private long zzaji;
  CountDownLatch zzajj;
  boolean zzajk;
  
  public AdvertisingIdClient$zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
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

/* Location:
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */