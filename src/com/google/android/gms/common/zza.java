package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza
  implements ServiceConnection
{
  boolean qP = false;
  private final BlockingQueue<IBinder> qQ = new LinkedBlockingQueue();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    qQ.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public IBinder zza(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    zzab.zzhk("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (qP) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    qP = true;
    paramTimeUnit = (IBinder)qQ.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null) {
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    return paramTimeUnit;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */