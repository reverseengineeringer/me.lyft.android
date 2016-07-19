package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzir
public abstract class zzfh
  implements Releasable
{
  protected Context mContext;
  protected String zzbjj;
  protected WeakReference<zzll> zzbjk;
  
  public zzfh(zzll paramzzll)
  {
    mContext = paramzzll.getContext();
    zzbjj = zzu.zzfq().zzh(mContext, zzunzzcs);
    zzbjk = new WeakReference(paramzzll);
  }
  
  private void zza(String paramString, Map<String, String> paramMap)
  {
    zzll localzzll = (zzll)zzbjk.get();
    if (localzzll != null) {
      localzzll.zza(paramString, paramMap);
    }
  }
  
  private String zzbc(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "internal";
        if (paramString.equals("error"))
        {
          i = 0;
          continue;
          if (paramString.equals("playerFailed"))
          {
            i = 1;
            continue;
            if (paramString.equals("inProgress"))
            {
              i = 2;
              continue;
              if (paramString.equals("contentLengthMissing"))
              {
                i = 3;
                continue;
                if (paramString.equals("noCacheDir"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("expireFailed"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("badUrl"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("downloadTimeout"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("sizeExceeded"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("externalAbort")) {
                            i = 9;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "internal";
    return "io";
    return "network";
    return "policy";
  }
  
  public abstract void abort();
  
  public void release() {}
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt)
  {
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheComplete");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("totalBytes", Integer.toString(paramInt));
        zzfh.zza(zzfh.this, "onPrecacheEvent", localHashMap);
      }
    });
  }
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheProgress");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("bytesLoaded", Integer.toString(paramInt1));
        localHashMap.put("totalBytes", Integer.toString(paramInt2));
        if (paramBoolean) {}
        for (String str = "1";; str = "0")
        {
          localHashMap.put("cacheReady", str);
          zzfh.zza(zzfh.this, "onPrecacheEvent", localHashMap);
          return;
        }
      }
    });
  }
  
  protected void zza(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheCanceled");
        localHashMap.put("src", paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          localHashMap.put("cachedSrc", paramString2);
        }
        localHashMap.put("type", zzfh.zza(zzfh.this, paramString3));
        localHashMap.put("reason", paramString3);
        if (!TextUtils.isEmpty(paramString4)) {
          localHashMap.put("message", paramString4);
        }
        zzfh.zza(zzfh.this, "onPrecacheEvent", localHashMap);
      }
    });
  }
  
  public abstract boolean zzba(String paramString);
  
  protected String zzbb(String paramString)
  {
    return zzm.zziw().zzcv(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */