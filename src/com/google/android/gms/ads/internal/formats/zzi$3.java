package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzil.zza;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zza;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class zzi$3
  extends zzil.zza
{
  zzi$3(zzi paramzzi) {}
  
  public void zze(final zzfx paramzzfx)
  {
    paramzzfx.zza("/loadHtml", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, final Map<String, String> paramAnonymousMap)
      {
        zzi.zzb(zzbgo).zzuk().zza(new zzlm.zza()
        {
          public void zza(zzll paramAnonymous2zzll, boolean paramAnonymous2Boolean)
          {
            zzi.zza(zzbgo, (String)paramAnonymousMap.get("id"));
            paramAnonymous2zzll = new JSONObject();
            try
            {
              paramAnonymous2zzll.put("messageType", "htmlLoaded");
              paramAnonymous2zzll.put("id", zzi.zza(zzbgo));
              zzbgp.zzb("sendMessageToNativeJs", paramAnonymous2zzll);
              return;
            }
            catch (JSONException paramAnonymous2zzll)
            {
              zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymous2zzll);
            }
          }
        });
        paramAnonymouszzll = (String)paramAnonymousMap.get("overlayHtml");
        paramAnonymousMap = (String)paramAnonymousMap.get("baseUrl");
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          zzi.zzb(zzbgo).loadData(paramAnonymouszzll, "text/html", "UTF-8");
          return;
        }
        zzi.zzb(zzbgo).loadDataWithBaseURL(paramAnonymousMap, paramAnonymouszzll, "text/html", "UTF-8", null);
      }
    });
    paramzzfx.zza("/showOverlay", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        zzi.zzb(zzbgo).getView().setVisibility(0);
      }
    });
    paramzzfx.zza("/hideOverlay", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        zzi.zzb(zzbgo).getView().setVisibility(8);
      }
    });
    zzi.zzb(zzbgo).zzuk().zza("/hideOverlay", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        zzi.zzb(zzbgo).getView().setVisibility(8);
      }
    });
    zzi.zzb(zzbgo).zzuk().zza("/sendMessageToSdk", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        paramAnonymouszzll = new JSONObject();
        try
        {
          Iterator localIterator = paramAnonymousMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            paramAnonymouszzll.put(str, paramAnonymousMap.get(str));
          }
          paramAnonymouszzll.put("id", zzi.zza(zzbgo));
        }
        catch (JSONException paramAnonymouszzll)
        {
          zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymouszzll);
          return;
        }
        paramzzfx.zzb("sendMessageToNativeJs", paramAnonymouszzll);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzi.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */