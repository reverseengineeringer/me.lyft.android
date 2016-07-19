package com.google.android.gms.internal;

import android.os.Handler;
import java.util.Map;
import org.json.JSONObject;

class zzeu$1
  implements Runnable
{
  zzeu$1(zzeu paramzzeu, Map paramMap, zzll paramzzll) {}
  
  public void run()
  {
    zzkh.zzcw("Received Http request.");
    final Object localObject = (String)zzbgr.get("http_request");
    localObject = zzbij.zzaw((String)localObject);
    if (localObject == null)
    {
      zzkh.e("Response should not be null.");
      return;
    }
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        zzbii.zzb("fetchHttpRequestCompleted", localObject);
        zzkh.zzcw("Dispatched http response.");
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeu.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */