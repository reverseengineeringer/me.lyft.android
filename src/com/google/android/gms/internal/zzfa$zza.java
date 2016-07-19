package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzfa$zza
{
  private final zzll zzbgj;
  
  public zzfa$zza(zzll paramzzll)
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfa.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */