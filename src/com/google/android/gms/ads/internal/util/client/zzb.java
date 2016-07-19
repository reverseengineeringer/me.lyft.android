package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzir;

@zzir
public class zzb
{
  public static void e(String paramString)
  {
    if (zzaz(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void zza(String paramString, Throwable paramThrowable)
  {
    if (zzaz(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean zzaz(int paramInt)
  {
    return (paramInt >= 5) || (Log.isLoggable("Ads", paramInt));
  }
  
  public static void zzb(String paramString, Throwable paramThrowable)
  {
    if (zzaz(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzc(String paramString, Throwable paramThrowable)
  {
    if (zzaz(4)) {
      Log.i("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzcw(String paramString)
  {
    if (zzaz(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void zzcx(String paramString)
  {
    if (zzaz(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void zzcy(String paramString)
  {
    if (zzaz(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void zzd(String paramString, Throwable paramThrowable)
  {
    if (zzaz(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */