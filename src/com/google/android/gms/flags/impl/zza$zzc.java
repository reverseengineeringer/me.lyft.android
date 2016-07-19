package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zza$zzc
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

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zza.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */