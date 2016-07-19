package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzfb
  implements zzet
{
  private final Object zzail = new Object();
  private final Map<String, zza> zzbjb = new HashMap();
  
  public void zza(zzll paramzzll, Map<String, String> arg2)
  {
    paramzzll = (String)???.get("id");
    String str1 = (String)???.get("fail");
    String str2 = (String)???.get("fail_reason");
    String str3 = (String)???.get("result");
    zza localzza;
    synchronized (zzail)
    {
      localzza = (zza)zzbjb.remove(paramzzll);
      if (localzza == null)
      {
        paramzzll = String.valueOf(paramzzll);
        if (paramzzll.length() != 0)
        {
          paramzzll = "Received result for unexpected method invocation: ".concat(paramzzll);
          zzkh.zzcy(paramzzll);
          return;
        }
        paramzzll = new String("Received result for unexpected method invocation: ");
      }
    }
    if (!TextUtils.isEmpty(str1))
    {
      localzza.zzaz(str2);
      return;
    }
    if (str3 == null)
    {
      localzza.zzaz("No result.");
      return;
    }
    try
    {
      localzza.zzd(new JSONObject(str3));
      return;
    }
    catch (JSONException paramzzll)
    {
      for (;;)
      {
        localzza.zzaz(paramzzll.getMessage());
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzaz(String paramString);
    
    public abstract void zzd(JSONObject paramJSONObject);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */