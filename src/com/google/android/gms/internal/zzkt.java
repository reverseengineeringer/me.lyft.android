package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzir
public class zzkt
{
  Map<Integer, Bitmap> zzcmt = new ConcurrentHashMap();
  private AtomicInteger zzcmu = new AtomicInteger(0);
  
  public Bitmap zza(Integer paramInteger)
  {
    return (Bitmap)zzcmt.get(paramInteger);
  }
  
  public int zzb(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      zzkh.zzcw("Bitmap is null. Skipping putting into the Memory Map.");
      return -1;
    }
    zzcmt.put(Integer.valueOf(zzcmu.get()), paramBitmap);
    return zzcmu.getAndIncrement();
  }
  
  public void zzb(Integer paramInteger)
  {
    zzcmt.remove(paramInteger);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */