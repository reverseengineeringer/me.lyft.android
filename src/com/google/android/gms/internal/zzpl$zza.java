package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

class zzpl$zza
{
  final ContentResolver mContentResolver;
  
  zzpl$zza(Context paramContext)
  {
    if ((paramContext == null) || (!zzbm(paramContext)))
    {
      mContentResolver = null;
      return;
    }
    mContentResolver = paramContext.getContentResolver();
    zzaer.zzb(mContentResolver, new String[] { "gms:playlog:service:sampling_" });
  }
  
  private String getString(String paramString1, String paramString2)
  {
    if (mContentResolver == null) {
      return paramString2;
    }
    return zzaer.zza(mContentResolver, paramString1, paramString2);
  }
  
  private static boolean zzbm(Context paramContext)
  {
    if (zzpl.qK == null) {
      if (paramContext.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      zzpl.qK = Boolean.valueOf(bool);
      return zzpl.qK.booleanValue();
    }
  }
  
  long zzanb()
  {
    if (mContentResolver == null) {
      return 0L;
    }
    return zzaer.getLong(mContentResolver, "android_id", 0L);
  }
  
  String zzgv(String paramString)
  {
    String str = String.valueOf("gms:playlog:service:sampling_");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str)) {
      return getString(paramString, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */