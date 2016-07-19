package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.formats.zzh;
import java.lang.ref.WeakReference;

public class zzcd$zza
  implements zzck
{
  private WeakReference<zzh> zzaqz;
  
  public zzcd$zza(zzh paramzzh)
  {
    zzaqz = new WeakReference(paramzzh);
  }
  
  public View zzhh()
  {
    zzh localzzh = (zzh)zzaqz.get();
    if (localzzh != null) {
      return localzzh.zzle();
    }
    return null;
  }
  
  public boolean zzhi()
  {
    return zzaqz.get() == null;
  }
  
  public zzck zzhj()
  {
    return new zzcd.zzb((zzh)zzaqz.get());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */