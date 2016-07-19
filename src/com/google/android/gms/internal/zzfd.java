package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzir
public final class zzfd
  implements zzet
{
  private final Map<zzll, Integer> zzbjd = new WeakHashMap();
  private boolean zzbje;
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = zzm.zziw().zza(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      zzkh.zzcy(String.valueOf(paramString).length() + 34 + String.valueOf(paramMap).length() + "Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    Object localObject2 = (String)paramMap.get("action");
    if (localObject2 == null) {
      zzkh.zzcy("Action missing from video GMSG.");
    }
    Object localObject1;
    Context localContext;
    do
    {
      for (;;)
      {
        return;
        if (zzkh.zzaz(3))
        {
          localObject1 = new JSONObject(paramMap);
          ((JSONObject)localObject1).remove("google.afma.Notify_dt");
          localObject1 = String.valueOf(((JSONObject)localObject1).toString());
          zzkh.zzcw(String.valueOf(localObject2).length() + 13 + String.valueOf(localObject1).length() + "Video GMSG: " + (String)localObject2 + " " + (String)localObject1);
        }
        if ("background".equals(localObject2))
        {
          paramMap = (String)paramMap.get("color");
          if (TextUtils.isEmpty(paramMap))
          {
            zzkh.zzcy("Color parameter missing from color video GMSG.");
            return;
          }
          try
          {
            i = Color.parseColor(paramMap);
            paramMap = paramzzll.zzur();
            if (paramMap != null)
            {
              paramMap = paramMap.zzuc();
              if (paramMap != null)
              {
                paramMap.setBackgroundColor(i);
                return;
              }
            }
          }
          catch (IllegalArgumentException paramzzll)
          {
            zzkh.zzcy("Invalid color parameter in video GMSG.");
            return;
          }
          zzbjd.put(paramzzll, Integer.valueOf(i));
          return;
        }
        localObject1 = paramzzll.zzur();
        if (localObject1 == null)
        {
          zzkh.zzcy("Could not get underlay container for a video GMSG.");
          return;
        }
        boolean bool1 = "new".equals(localObject2);
        boolean bool2 = "position".equals(localObject2);
        if ((bool1) || (bool2))
        {
          localObject2 = paramzzll.getContext();
          j = zza((Context)localObject2, paramMap, "x", 0);
          int k = zza((Context)localObject2, paramMap, "y", 0);
          int m = zza((Context)localObject2, paramMap, "w", -1);
          int n = zza((Context)localObject2, paramMap, "h", -1);
          try
          {
            i = Integer.parseInt((String)paramMap.get("player"));
            bool2 = Boolean.parseBoolean((String)paramMap.get("spherical"));
            if ((bool1) && (((zzlk)localObject1).zzuc() == null))
            {
              ((zzlk)localObject1).zza(j, k, m, n, i, bool2);
              if (!zzbjd.containsKey(paramzzll)) {
                continue;
              }
              i = ((Integer)zzbjd.get(paramzzll)).intValue();
              ((zzlk)localObject1).zzuc().setBackgroundColor(i);
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              i = 0;
            }
            ((zzlk)localObject1).zze(j, k, m, n);
            return;
          }
        }
      }
      localObject1 = ((zzlk)localObject1).zzuc();
      if (localObject1 == null)
      {
        zzk.zzi(paramzzll);
        return;
      }
      if ("click".equals(localNumberFormatException))
      {
        paramzzll = paramzzll.getContext();
        i = zza(paramzzll, paramMap, "x", 0);
        j = zza(paramzzll, paramMap, "y", 0);
        long l = SystemClock.uptimeMillis();
        paramzzll = MotionEvent.obtain(l, l, 0, i, j, 0);
        ((zzk)localObject1).zzd(paramzzll);
        paramzzll.recycle();
        return;
      }
      if ("currentTime".equals(localNumberFormatException))
      {
        paramzzll = (String)paramMap.get("time");
        if (paramzzll == null)
        {
          zzkh.zzcy("Time parameter missing from currentTime video GMSG.");
          return;
        }
        try
        {
          ((zzk)localObject1).seekTo((int)(Float.parseFloat(paramzzll) * 1000.0F));
          return;
        }
        catch (NumberFormatException paramMap)
        {
          paramzzll = String.valueOf(paramzzll);
          if (paramzzll.length() == 0) {}
        }
        for (paramzzll = "Could not parse time parameter from currentTime video GMSG: ".concat(paramzzll);; paramzzll = new String("Could not parse time parameter from currentTime video GMSG: "))
        {
          zzkh.zzcy(paramzzll);
          return;
        }
      }
      if ("hide".equals(localNumberFormatException))
      {
        ((zzk)localObject1).setVisibility(4);
        return;
      }
      if ("load".equals(localNumberFormatException))
      {
        ((zzk)localObject1).zzlx();
        return;
      }
      if ("mimetype".equals(localNumberFormatException))
      {
        ((zzk)localObject1).setMimeType((String)paramMap.get("mimetype"));
        return;
      }
      if ("muted".equals(localNumberFormatException))
      {
        if (Boolean.parseBoolean((String)paramMap.get("muted")))
        {
          ((zzk)localObject1).zznq();
          return;
        }
        ((zzk)localObject1).zznr();
        return;
      }
      if ("pause".equals(localNumberFormatException))
      {
        ((zzk)localObject1).pause();
        return;
      }
      if ("play".equals(localNumberFormatException))
      {
        ((zzk)localObject1).play();
        return;
      }
      if ("show".equals(localNumberFormatException))
      {
        ((zzk)localObject1).setVisibility(0);
        return;
      }
      if ("src".equals(localNumberFormatException))
      {
        ((zzk)localObject1).zzbx((String)paramMap.get("src"));
        return;
      }
      if (!"touchMove".equals(localNumberFormatException)) {
        break;
      }
      localContext = paramzzll.getContext();
      int i = zza(localContext, paramMap, "dx", 0);
      int j = zza(localContext, paramMap, "dy", 0);
      ((zzk)localObject1).zza(i, j);
    } while (zzbje);
    paramzzll.zzui().zzod();
    zzbje = true;
    return;
    if ("volume".equals(localContext))
    {
      paramzzll = (String)paramMap.get("volume");
      if (paramzzll == null)
      {
        zzkh.zzcy("Level parameter missing from volume video GMSG.");
        return;
      }
      try
      {
        ((zzk)localObject1).zza(Float.parseFloat(paramzzll));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        paramzzll = String.valueOf(paramzzll);
        if (paramzzll.length() == 0) {}
      }
      for (paramzzll = "Could not parse volume parameter from volume video GMSG: ".concat(paramzzll);; paramzzll = new String("Could not parse volume parameter from volume video GMSG: "))
      {
        zzkh.zzcy(paramzzll);
        return;
      }
    }
    if ("watermark".equals(localContext))
    {
      ((zzk)localObject1).zzop();
      return;
    }
    paramzzll = String.valueOf(localContext);
    if (paramzzll.length() != 0) {}
    for (paramzzll = "Unknown video action: ".concat(paramzzll);; paramzzll = new String("Unknown video action: "))
    {
      zzkh.zzcy(paramzzll);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */