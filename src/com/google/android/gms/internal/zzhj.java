package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzhj
{
  private final zzll zzbgj;
  private final String zzbrq;
  
  public zzhj(zzll paramzzll)
  {
    this(paramzzll, "");
  }
  
  public zzhj(zzll paramzzll, String paramString)
  {
    zzbgj = paramzzll;
    zzbrq = paramString;
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      zzbgj.zzb("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void zzb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzbgj.zzb("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  public void zzbu(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", zzbrq);
      zzbgj.zzb("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzkh.zzb("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public void zzbv(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("js", paramString);
      zzbgj.zzb("onReadyEventReceived", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzkh.zzb("Error occured while dispatching ready Event.", paramString);
    }
  }
  
  public void zzbw(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      zzbgj.zzb("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzkh.zzb("Error occured while dispatching state change.", paramString);
    }
  }
  
  public void zzc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzbgj.zzb("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Error occured while dispatching default position.", localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */