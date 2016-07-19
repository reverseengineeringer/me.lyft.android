package com.google.android.gms.internal;

import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class zzbo
{
  protected static final String TAG = zzbo.class.getSimpleName();
  private final String className;
  private final zzax zzaey;
  private final String zzahf;
  private final int zzahg = 2;
  private volatile Method zzahh = null;
  private List<Class> zzahi;
  private CountDownLatch zzahj = new CountDownLatch(1);
  
  public zzbo(zzax paramzzax, String paramString1, String paramString2, List<Class> paramList)
  {
    zzaey = paramzzax;
    className = paramString1;
    zzahf = paramString2;
    zzahi = new ArrayList(paramList);
    zzaey.zzce().submit(new Runnable()
    {
      public void run()
      {
        zzbo.zza(zzbo.this);
      }
    });
  }
  
  private void zzcz()
  {
    try
    {
      Object localObject1 = zzaey.zzcf().loadClass(zzd(zzaey.zzch(), className));
      if (localObject1 == null) {
        return;
      }
      zzahh = ((Class)localObject1).getMethod(zzd(zzaey.zzch(), zzahf), (Class[])zzahi.toArray(new Class[zzahi.size()]));
      localObject1 = zzahh;
      if (localObject1 == null) {
        return;
      }
      return;
    }
    catch (zzau.zza localzza) {}catch (UnsupportedEncodingException localUnsupportedEncodingException) {}catch (ClassNotFoundException localClassNotFoundException) {}catch (NoSuchMethodException localNoSuchMethodException) {}catch (NullPointerException localNullPointerException) {}finally
    {
      zzahj.countDown();
    }
  }
  
  private String zzd(byte[] paramArrayOfByte, String paramString)
    throws zzau.zza, UnsupportedEncodingException
  {
    return new String(zzaey.zzcg().zzc(paramArrayOfByte, paramString), "UTF-8");
  }
  
  public Method zzda()
  {
    Method localMethod = null;
    if (zzahh != null) {
      localMethod = zzahh;
    }
    for (;;)
    {
      return localMethod;
      try
      {
        if (zzahj.await(2L, TimeUnit.SECONDS))
        {
          localMethod = zzahh;
          return localMethod;
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */