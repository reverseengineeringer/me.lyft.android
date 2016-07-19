package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.HashMap;

class zzaer$1$1
  extends ContentObserver
{
  zzaer$1$1(zzaer.1 param1, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    try
    {
      zzaer.zzcjl().clear();
      zzaer.zzbb(new Object());
      if (zzaer.zzcjm().length > 0) {
        zzaer.zzb(aMe.aMd, zzaer.zzcjm());
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaer.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */