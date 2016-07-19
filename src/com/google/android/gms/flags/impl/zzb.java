package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zzb
{
  private static SharedPreferences QA = null;
  
  public static SharedPreferences zzn(Context paramContext)
  {
    try
    {
      if (QA == null) {
        QA = (SharedPreferences)zzui.zzb(new Callable()
        {
          public SharedPreferences zzbfv()
          {
            return getSharedPreferences("google_sdk_flags", 1);
          }
        });
      }
      paramContext = QA;
      return paramContext;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */