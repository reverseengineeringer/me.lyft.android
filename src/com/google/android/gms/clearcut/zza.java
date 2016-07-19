package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.SharedPreferences;

public class zza
{
  private static int pN = -1;
  public static final zza pO = new zza();
  
  public int zzbk(Context paramContext)
  {
    if (pN < 0) {
      pN = paramContext.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
    }
    return pN;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */