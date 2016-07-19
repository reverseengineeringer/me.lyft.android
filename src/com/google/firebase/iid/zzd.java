package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class zzd
{
  static Map<String, zzd> abO = new HashMap();
  static String abU;
  private static zzg baQ;
  private static zzf baR;
  KeyPair abR;
  String abS = "";
  long abT;
  Context mContext;
  
  protected zzd(Context paramContext, String paramString, Bundle paramBundle)
  {
    mContext = paramContext.getApplicationContext();
    abS = paramString;
  }
  
  public static zzd zzb(Context paramContext, Bundle paramBundle)
  {
    String str;
    if (paramBundle == null) {
      str = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (baQ == null)
        {
          baQ = new zzg(localContext);
          baR = new zzf(localContext);
        }
        abU = Integer.toString(FirebaseInstanceId.zzdf(localContext));
        zzd localzzd = (zzd)abO.get(str);
        paramContext = localzzd;
        if (localzzd == null)
        {
          paramContext = new zzd(localContext, str, paramBundle);
          abO.put(str, paramContext);
        }
        return paramContext;
      }
      finally {}
      str = paramBundle.getString("subtype");
      while (str != null) {
        break;
      }
      str = "";
    }
  }
  
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    int j = 0;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    int i = 1;
    if (zzbmx()) {}
    for (Object localObject = null; localObject != null; localObject = baQ.zzi(abS, paramString1, paramString2)) {
      return (String)localObject;
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    if (((Bundle)localObject).getString("ttl") != null) {
      i = 0;
    }
    if ("jwt".equals(((Bundle)localObject).getString("type"))) {
      i = j;
    }
    for (;;)
    {
      paramBundle = zzc(paramString1, paramString2, (Bundle)localObject);
      localObject = paramBundle;
      if (paramBundle == null) {
        break;
      }
      localObject = paramBundle;
      if (i == 0) {
        break;
      }
      baQ.zza(abS, paramString1, paramString2, paramBundle, abU);
      return paramBundle;
    }
  }
  
  public void zzb(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    baQ.zzj(abS, paramString1, paramString2);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("sender", paramString1);
    if (paramString2 != null) {
      localBundle.putString("scope", paramString2);
    }
    localBundle.putString("subscription", paramString1);
    localBundle.putString("delete", "1");
    localBundle.putString("X-delete", "1");
    if ("".equals(abS))
    {
      paramString2 = paramString1;
      localBundle.putString("subtype", paramString2);
      if (!"".equals(abS)) {
        break label165;
      }
    }
    for (;;)
    {
      localBundle.putString("X-subtype", paramString1);
      paramString1 = baR.zza(localBundle, zzbmt());
      baR.zzs(paramString1);
      return;
      paramString2 = abS;
      break;
      label165:
      paramString1 = abS;
    }
  }
  
  KeyPair zzbmt()
  {
    if (abR == null) {
      abR = baQ.zzki(abS);
    }
    if (abR == null)
    {
      abT = System.currentTimeMillis();
      abR = baQ.zze(abS, abT);
    }
    return abR;
  }
  
  public void zzbmu()
  {
    abT = 0L;
    baQ.zzkj(abS);
    abR = null;
  }
  
  boolean zzbmx()
  {
    String str = baQ.get("appVersion");
    if ((str == null) || (!str.equals(abU))) {}
    long l;
    do
    {
      do
      {
        return true;
        str = baQ.get("lastToken");
      } while (str == null);
      l = Long.parseLong(str);
    } while (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 604800L);
    return false;
  }
  
  public String zzc(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (paramString2 != null) {
      paramBundle.putString("scope", paramString2);
    }
    paramBundle.putString("sender", paramString1);
    if ("".equals(abS)) {}
    for (paramString2 = paramString1;; paramString2 = abS)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      paramString1 = baR.zza(paramBundle, zzbmt());
      return baR.zzs(paramString1);
    }
  }
  
  public zzg zzcxa()
  {
    return baQ;
  }
  
  public zzf zzcxb()
  {
    return baR;
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */