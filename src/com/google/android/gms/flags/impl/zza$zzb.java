package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zza$zzb
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

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zza.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */