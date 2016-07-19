package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
public class zzkm$zze
  extends zzkm.zzd
{
  public boolean isAttachedToWindow(View paramView)
  {
    return (super.isAttachedToWindow(paramView)) || (paramView.getWindowId() != null);
  }
  
  public int zztm()
  {
    return 14;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkm.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */