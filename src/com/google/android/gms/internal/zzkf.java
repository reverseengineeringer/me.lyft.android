package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.math.BigInteger;
import java.util.Locale;

@zzir
public final class zzkf
{
  private static final Object zzamp = new Object();
  private static String zzckn;
  
  public static String zza(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (zzamp)
    {
      if ((zzckn == null) && (!TextUtils.isEmpty(paramString1))) {
        zzb(paramContext, paramString1, paramString2);
      }
      paramContext = zzckn;
      return paramContext;
    }
  }
  
  private static void zzb(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, paramString2);
      paramContext = new BigInteger(new byte[1]);
      String[] arrayOfString = paramString1.split(",");
      int i = 0;
      while (i < arrayOfString.length)
      {
        paramString1 = paramContext;
        if (zzu.zzfq().zza(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      zzckn = "err";
      return;
    }
    tmp96_93[0] = paramContext;
    zzckn = String.format(Locale.US, "%X", tmp96_93);
  }
  
  public static String zzsz()
  {
    synchronized (zzamp)
    {
      String str = zzckn;
      return str;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */