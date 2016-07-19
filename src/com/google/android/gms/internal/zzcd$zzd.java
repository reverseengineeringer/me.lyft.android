package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;

public class zzcd$zzd
  implements zzck
{
  private final WeakReference<View> zzarc;
  private final WeakReference<zzjy> zzard;
  
  public zzcd$zzd(View paramView, zzjy paramzzjy)
  {
    zzarc = new WeakReference(paramView);
    zzard = new WeakReference(paramzzjy);
  }
  
  public View zzhh()
  {
    return (View)zzarc.get();
  }
  
  public boolean zzhi()
  {
    return (zzarc.get() == null) || (zzard.get() == null);
  }
  
  public zzck zzhj()
  {
    return new zzcd.zzc((View)zzarc.get(), (zzjy)zzard.get());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcd.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */