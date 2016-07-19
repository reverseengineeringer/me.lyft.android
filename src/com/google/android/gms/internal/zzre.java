package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzre<T>
{
  private static zza vA = null;
  private static int vB = 0;
  private static String vC = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzamp = new Object();
  private T vD = null;
  protected final String zzaxn;
  protected final T zzaxo;
  
  protected zzre(String paramString, T paramT)
  {
    zzaxn = paramString;
    zzaxo = paramT;
  }
  
  public static zzre<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzre(paramString, paramInteger)
    {
      protected Integer zzhc(String paramAnonymousString)
      {
        return zzre.zzaqx().zzb(zzaxn, (Integer)zzaxo);
      }
    };
  }
  
  public static zzre<Long> zza(String paramString, Long paramLong)
  {
    new zzre(paramString, paramLong)
    {
      protected Long zzhb(String paramAnonymousString)
      {
        return zzre.zzaqx().getLong(zzaxn, (Long)zzaxo);
      }
    };
  }
  
  public static zzre<String> zzab(String paramString1, String paramString2)
  {
    new zzre(paramString1, paramString2)
    {
      protected String zzhe(String paramAnonymousString)
      {
        return zzre.zzaqx().getString(zzaxn, (String)zzaxo);
      }
    };
  }
  
  public static zzre<Boolean> zzm(String paramString, boolean paramBoolean)
  {
    new zzre(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzha(String paramAnonymousString)
      {
        return zzre.zzaqx().zza(zzaxn, (Boolean)zzaxo);
      }
    };
  }
  
  public final T get()
  {
    try
    {
      Object localObject1 = zzgz(zzaxn);
      return (T)localObject1;
    }
    catch (SecurityException localSecurityException)
    {
      long l = Binder.clearCallingIdentity();
      try
      {
        Object localObject2 = zzgz(zzaxn);
        return (T)localObject2;
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
    }
  }
  
  protected abstract T zzgz(String paramString);
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */