package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;

public abstract class zzd$zze<TListener>
{
  private TListener mListener;
  private boolean xw;
  
  public zzd$zze(TListener paramTListener)
  {
    Object localObject;
    mListener = localObject;
    xw = false;
  }
  
  public void unregister()
  {
    zzasc();
    synchronized (zzd.zzd(xv))
    {
      zzd.zzd(xv).remove(this);
      return;
    }
  }
  
  protected abstract void zzasa();
  
  public void zzasb()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = mListener;
        if (xw)
        {
          String str = String.valueOf(this);
          Log.w("GmsClient", String.valueOf(str).length() + 47 + "Callback proxy " + str + " being reused. This is not safe.");
        }
        if (localObject1 != null) {}
        zzasa();
      }
      finally
      {
        try
        {
          zzx(localObject1);
        }
        catch (RuntimeException localRuntimeException)
        {
          zzasa();
          throw localRuntimeException;
        }
        try
        {
          xw = true;
          unregister();
          return;
        }
        finally {}
        localObject2 = finally;
      }
    }
  }
  
  public void zzasc()
  {
    try
    {
      mListener = null;
      return;
    }
    finally {}
  }
  
  protected abstract void zzx(TListener paramTListener);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */