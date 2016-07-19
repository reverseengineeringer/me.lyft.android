package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzcy$2
  extends zzcy<Integer>
{
  zzcy$2(int paramInt, String paramString, Integer paramInteger)
  {
    super(paramInt, paramString, paramInteger, null);
  }
  
  public Integer zzc(SharedPreferences paramSharedPreferences)
  {
    return Integer.valueOf(paramSharedPreferences.getInt(getKey(), ((Integer)zzjw()).intValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcy.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */