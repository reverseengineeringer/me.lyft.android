package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@zzir
public class zzdq
  implements zzapj
{
  private CustomTabsSession zzbem;
  private CustomTabsClient zzben;
  private CustomTabsServiceConnection zzbeo;
  private zza zzbep;
  
  public static boolean zzo(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    if (localObject1 == null) {}
    for (;;)
    {
      return false;
      Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
      ResolveInfo localResolveInfo = ((PackageManager)localObject1).resolveActivity((Intent)localObject2, 0);
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 65536);
      if ((localObject1 != null) && (localResolveInfo != null))
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (ResolveInfo)((List)localObject1).get(i);
          if (activityInfo.name.equals(activityInfo.name)) {
            return activityInfo.packageName.equals(zzaph.zzeu(paramContext));
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean mayLaunchUrl(Uri paramUri, Bundle paramBundle, List<Bundle> paramList)
  {
    if (zzben == null) {}
    CustomTabsSession localCustomTabsSession;
    do
    {
      return false;
      localCustomTabsSession = zzkl();
    } while (localCustomTabsSession == null);
    return localCustomTabsSession.mayLaunchUrl(paramUri, paramBundle, paramList);
  }
  
  public void zza(CustomTabsClient paramCustomTabsClient)
  {
    zzben = paramCustomTabsClient;
    zzben.warmup(0L);
    if (zzbep != null) {
      zzbep.zzkn();
    }
  }
  
  public void zza(zza paramzza)
  {
    zzbep = paramzza;
  }
  
  public void zzd(Activity paramActivity)
  {
    if (zzbeo == null) {
      return;
    }
    paramActivity.unbindService(zzbeo);
    zzben = null;
    zzbem = null;
    zzbeo = null;
  }
  
  public void zze(Activity paramActivity)
  {
    if (zzben != null) {}
    String str;
    do
    {
      return;
      str = zzaph.zzeu(paramActivity);
    } while (str == null);
    zzbeo = new zzapi(this);
    CustomTabsClient.bindCustomTabsService(paramActivity, str, zzbeo);
  }
  
  public CustomTabsSession zzkl()
  {
    if (zzben == null) {
      zzbem = null;
    }
    for (;;)
    {
      return zzbem;
      if (zzbem == null) {
        zzbem = zzben.newSession(null);
      }
    }
  }
  
  public void zzkm()
  {
    zzben = null;
    zzbem = null;
    if (zzbep != null) {
      zzbep.zzko();
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzkn();
    
    public abstract void zzko();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */