package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
public class zzkm$zzc
  extends zzkm.zzb
{
  public String zza(SslError paramSslError)
  {
    return paramSslError.getUrl();
  }
  
  public WebChromeClient zzl(zzll paramzzll)
  {
    return new zzlu(paramzzll);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkm.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */