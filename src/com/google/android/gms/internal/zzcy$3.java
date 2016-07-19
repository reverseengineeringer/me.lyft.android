package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzcy$3
  extends zzcy<Long>
{
  zzcy$3(int paramInt, String paramString, Long paramLong)
  {
    super(paramInt, paramString, paramLong, null);
  }
  
  public Long zzd(SharedPreferences paramSharedPreferences)
  {
    return Long.valueOf(paramSharedPreferences.getLong(getKey(), ((Long)zzjw()).longValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcy.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */