package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class zzfh$2
  implements Runnable
{
  zzfh$2(zzfh paramzzfh, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheComplete");
    localHashMap.put("src", zzbjl);
    localHashMap.put("cachedSrc", zzbjm);
    localHashMap.put("totalBytes", Integer.toString(zzbjo));
    zzfh.zza(zzbjq, "onPrecacheEvent", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfh.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */