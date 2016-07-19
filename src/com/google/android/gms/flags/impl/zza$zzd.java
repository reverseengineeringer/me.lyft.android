package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zza$zzd
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

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zza.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */