package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzir
public class zzhp
  extends Handler
{
  private final zzho zzbwk;
  
  public zzhp(Context paramContext)
  {
    this(new zzhq(localContext));
  }
  
  public zzhp(zzho paramzzho)
  {
    zzbwk = paramzzho;
  }
  
  private void zze(JSONObject paramJSONObject)
  {
    try
    {
      zzbwk.zza(paramJSONObject.getString("request_id"), paramJSONObject.getString("base_url"), paramJSONObject.getString("html"));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        return;
      }
      paramMessage = new JSONObject(paramMessage.getString("data"));
      if ("fetch_html".equals(paramMessage.getString("message_name")))
      {
        zze(paramMessage);
        return;
      }
    }
    catch (Exception paramMessage) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */