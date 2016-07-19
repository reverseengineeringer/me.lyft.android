package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public abstract class zza<T>
{
  public static class zza
    extends zza<Boolean>
  {
    public static Boolean zza(SharedPreferences paramSharedPreferences, final String paramString, final Boolean paramBoolean)
    {
      (Boolean)zzui.zzb(new Callable()
      {
        public Boolean zzto()
        {
          return Boolean.valueOf(getBoolean(paramString, paramBoolean.booleanValue()));
        }
      });
    }
  }
  
  public static class zzb
    extends zza<Integer>
  {
    public static Integer zza(SharedPreferences paramSharedPreferences, final String paramString, final Integer paramInteger)
    {
      (Integer)zzui.zzb(new Callable()
      {
        public Integer zzbft()
        {
          return Integer.valueOf(getInt(paramString, paramInteger.intValue()));
        }
      });
    }
  }
  
  public static class zzc
    extends zza<Long>
  {
    public static Long zza(SharedPreferences paramSharedPreferences, final String paramString, final Long paramLong)
    {
      (Long)zzui.zzb(new Callable()
      {
        public Long zzbfu()
        {
          return Long.valueOf(getLong(paramString, paramLong.longValue()));
        }
      });
    }
  }
  
  public static class zzd
    extends zza<String>
  {
    public static String zza(SharedPreferences paramSharedPreferences, final String paramString1, final String paramString2)
    {
      (String)zzui.zzb(new Callable()
      {
        public String zzaba()
        {
          return getString(paramString1, paramString2);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */