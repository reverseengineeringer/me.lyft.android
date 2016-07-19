package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class zzfh$1
  implements Runnable
{
  zzfh$1(zzfh paramzzfh, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheProgress");
    localHashMap.put("src", zzbjl);
    localHashMap.put("cachedSrc", zzbjm);
    localHashMap.put("bytesLoaded", Integer.toString(zzbjn));
    localHashMap.put("totalBytes", Integer.toString(zzbjo));
    if (zzbjp) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("cacheReady", str);
      zzfh.zza(zzbjq, "onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfh.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */