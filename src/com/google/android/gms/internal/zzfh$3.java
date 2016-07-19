package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class zzfh$3
  implements Runnable
{
  zzfh$3(zzfh paramzzfh, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheCanceled");
    localHashMap.put("src", zzbjl);
    if (!TextUtils.isEmpty(zzbjm)) {
      localHashMap.put("cachedSrc", zzbjm);
    }
    localHashMap.put("type", zzfh.zza(zzbjq, zzbjr));
    localHashMap.put("reason", zzbjr);
    if (!TextUtils.isEmpty(zzbjs)) {
      localHashMap.put("message", zzbjs);
    }
    zzfh.zza(zzbjq, "onPrecacheEvent", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfh.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */