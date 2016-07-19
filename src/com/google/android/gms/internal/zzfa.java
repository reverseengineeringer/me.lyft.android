package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzir
public final class zzfa
  implements zzet
{
  private final zze zzbix;
  private final zzhe zzbiy;
  private final zzev zzbja;
  
  public zzfa(zzev paramzzev, zze paramzze, zzhe paramzzhe)
  {
    zzbja = paramzzev;
    zzbix = paramzze;
    zzbiy = paramzzhe;
  }
  
  private static boolean zzc(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int zzd(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return zzu.zzfs().zztl();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return zzu.zzfs().zztk();
      }
      if ("c".equalsIgnoreCase(paramMap)) {
        return zzu.zzfs().zztm();
      }
    }
    return -1;
  }
  
  private static void zze(zzll paramzzll, Map<String, String> paramMap)
  {
    Context localContext = paramzzll.getContext();
    if (TextUtils.isEmpty((String)paramMap.get("u")))
    {
      zzkh.zzcy("Destination url cannot be empty.");
      return;
    }
    zzlm localzzlm = paramzzll.zzuk();
    paramzzll = new zza(paramzzll).zzc(localContext, paramMap);
    try
    {
      localzzlm.zza(new AdLauncherIntentInfoParcel(paramzzll));
      return;
    }
    catch (ActivityNotFoundException paramzzll)
    {
      zzkh.zzcy(paramzzll.getMessage());
    }
  }
  
  private void zzr(boolean paramBoolean)
  {
    if (zzbiy != null) {
      zzbiy.zzs(paramBoolean);
    }
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null) {
      zzkh.zzcy("Action missing from an open GMSG.");
    }
    zzlm localzzlm;
    do
    {
      return;
      if ((zzbix != null) && (!zzbix.zzem()))
      {
        zzbix.zzt((String)paramMap.get("u"));
        return;
      }
      localzzlm = paramzzll.zzuk();
      if ("expand".equalsIgnoreCase(str))
      {
        if (paramzzll.zzuo())
        {
          zzkh.zzcy("Cannot expand WebView that is already expanded.");
          return;
        }
        zzr(false);
        localzzlm.zza(zzc(paramMap), zzd(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str))
      {
        paramzzll = (String)paramMap.get("u");
        zzr(false);
        if (paramzzll != null)
        {
          localzzlm.zza(zzc(paramMap), zzd(paramMap), paramzzll);
          return;
        }
        localzzlm.zza(zzc(paramMap), zzd(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str)) {
        break;
      }
      paramzzll = (String)paramMap.get("product_id");
      paramMap = (String)paramMap.get("report_urls");
    } while (zzbja == null);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.split(" ");
      zzbja.zza(paramzzll, new ArrayList(Arrays.asList(paramMap)));
      return;
    }
    zzbja.zza(paramzzll, new ArrayList());
    return;
    if (("app".equalsIgnoreCase(str)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      zzr(true);
      zze(paramzzll, paramMap);
      return;
    }
    zzr(true);
    str = (String)paramMap.get("u");
    if (!TextUtils.isEmpty(str)) {}
    for (paramzzll = zzu.zzfq().zza(paramzzll, str);; paramzzll = str)
    {
      localzzlm.zza(new AdLauncherIntentInfoParcel((String)paramMap.get("i"), paramzzll, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
  
  public static class zza
  {
    private final zzll zzbgj;
    
    public zza(zzll paramzzll)
    {
      zzbgj = paramzzll;
    }
    
    public Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setClassName(activityInfo.packageName, activityInfo.name);
      return paramIntent;
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent)
    {
      return zza(paramContext, paramIntent, new ArrayList());
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      List localList = paramContext.queryIntentActivities(paramIntent, 65536);
      paramContext = paramContext.resolveActivity(paramIntent, 65536);
      int i;
      if ((localList != null) && (paramContext != null))
      {
        i = 0;
        if (i < localList.size())
        {
          paramIntent = (ResolveInfo)localList.get(i);
          if ((paramContext == null) || (!activityInfo.name.equals(activityInfo.name))) {}
        }
      }
      for (;;)
      {
        paramArrayList.addAll(localList);
        return paramContext;
        i += 1;
        break;
        paramContext = null;
      }
    }
    
    public Intent zzc(Context paramContext, Map<String, String> paramMap)
    {
      Object localObject1 = null;
      Object localObject3 = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject2 = (String)paramMap.get("u");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMap = (Map<String, String>)localObject1;
        return paramMap;
      }
      localObject1 = localObject2;
      if (zzbgj != null) {
        localObject1 = zzu.zzfq().zza(zzbgj, (String)localObject2);
      }
      localObject1 = Uri.parse((String)localObject1);
      boolean bool1 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      if ("http".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
        paramMap = ((Uri)localObject1).buildUpon().scheme("https").build();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        Intent localIntent = zze((Uri)localObject1);
        paramMap = zze(paramMap);
        localObject1 = zza(paramContext, localIntent, (ArrayList)localObject2);
        if (localObject1 != null)
        {
          return zza(localIntent, (ResolveInfo)localObject1);
          if ("https".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
            paramMap = ((Uri)localObject1).buildUpon().scheme("http").build();
          }
        }
        else
        {
          if (paramMap != null)
          {
            paramMap = zza(paramContext, paramMap);
            if (paramMap != null)
            {
              localObject1 = zza(localIntent, paramMap);
              paramMap = (Map<String, String>)localObject1;
              if (zza(paramContext, (Intent)localObject1) != null) {
                break;
              }
            }
          }
          if (((ArrayList)localObject2).size() == 0) {
            return localIntent;
          }
          if ((bool2) && (localObject3 != null))
          {
            paramContext = ((ActivityManager)localObject3).getRunningAppProcesses();
            if (paramContext != null)
            {
              do
              {
                paramMap = ((ArrayList)localObject2).iterator();
                while (!((Iterator)localObject3).hasNext())
                {
                  if (!paramMap.hasNext()) {
                    break;
                  }
                  localObject1 = (ResolveInfo)paramMap.next();
                  localObject3 = paramContext.iterator();
                }
              } while (!nextprocessName.equals(activityInfo.packageName));
              return zza(localIntent, (ResolveInfo)localObject1);
            }
          }
          if (bool1) {
            return zza(localIntent, (ResolveInfo)((ArrayList)localObject2).get(0));
          }
          return localIntent;
        }
        paramMap = null;
      }
    }
    
    public Intent zze(Uri paramUri)
    {
      if (paramUri == null) {
        return null;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramUri);
      localIntent.setAction("android.intent.action.VIEW");
      return localIntent;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */