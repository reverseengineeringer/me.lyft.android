package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zza$zza
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

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */