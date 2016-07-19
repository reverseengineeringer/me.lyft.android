package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzcy$1
  extends zzcy<Boolean>
{
  zzcy$1(int paramInt, String paramString, Boolean paramBoolean)
  {
    super(paramInt, paramString, paramBoolean, null);
  }
  
  public Boolean zzb(SharedPreferences paramSharedPreferences)
  {
    return Boolean.valueOf(paramSharedPreferences.getBoolean(getKey(), ((Boolean)zzjw()).booleanValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcy.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */