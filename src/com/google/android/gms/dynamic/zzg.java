package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zze;

public abstract class zzg<T>
{
  private final String Mb;
  private T Mc;
  
  protected zzg(String paramString)
  {
    Mb = paramString;
  }
  
  protected abstract T zzc(IBinder paramIBinder);
  
  protected final T zzcr(Context paramContext)
    throws zzg.zza
  {
    if (Mc == null)
    {
      zzab.zzaa(paramContext);
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      Mc = zzc((IBinder)paramContext.loadClass(Mb).newInstance());
      return (T)Mc;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */