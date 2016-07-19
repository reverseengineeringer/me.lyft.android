package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
class zzld
{
  private final Object zzcob = new Object();
  private final List<Runnable> zzcoc = new ArrayList();
  private final List<Runnable> zzcod = new ArrayList();
  private boolean zzcoe = false;
  
  private void zzd(Runnable paramRunnable)
  {
    zzkk.zza(paramRunnable);
  }
  
  private void zze(Runnable paramRunnable)
  {
    zza.zzcnf.post(paramRunnable);
  }
  
  public void zzb(Runnable paramRunnable)
  {
    synchronized (zzcob)
    {
      if (zzcoe)
      {
        zzd(paramRunnable);
        return;
      }
      zzcoc.add(paramRunnable);
    }
  }
  
  public void zzc(Runnable paramRunnable)
  {
    synchronized (zzcob)
    {
      if (zzcoe)
      {
        zze(paramRunnable);
        return;
      }
      zzcod.add(paramRunnable);
    }
  }
  
  public void zzua()
  {
    synchronized (zzcob)
    {
      if (zzcoe) {
        return;
      }
      Iterator localIterator1 = zzcoc.iterator();
      if (localIterator1.hasNext()) {
        zzd((Runnable)localIterator1.next());
      }
    }
    Iterator localIterator2 = zzcod.iterator();
    while (localIterator2.hasNext()) {
      zze((Runnable)localIterator2.next());
    }
    zzcoc.clear();
    zzcod.clear();
    zzcoe = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzld
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */