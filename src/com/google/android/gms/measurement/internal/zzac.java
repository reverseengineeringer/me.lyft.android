package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzac
  extends zzaa
{
  private zza amW;
  private AppMeasurement.zzb amX;
  private final Set<AppMeasurement.zzc> amY = new HashSet();
  private boolean amZ;
  
  protected zzac(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    zza(paramString1, paramString2, zzyw().currentTimeMillis(), paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  private void zza(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    zzab.zzhs(paramString1);
    zzab.zzhs(paramString2);
    zzwu();
    zzyv();
    zzzg();
    if (!aja.isEnabled()) {
      zzbsz().zzbtx().log("User property not set since app measurement is disabled");
    }
    while (!aja.zzbuk()) {
      return;
    }
    zzbsz().zzbtx().zze("Setting user property (FE)", paramString2, paramObject);
    paramString1 = new UserAttributeParcel(paramString2, paramLong, paramObject, paramString1);
    zzbst().zza(paramString1);
  }
  
  private void zzb(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    zzab.zzhs(paramString1);
    zzab.zzhs(paramString2);
    zzab.zzaa(paramBundle);
    zzwu();
    zzzg();
    if (!aja.isEnabled()) {
      zzbsz().zzbtx().log("Event not sent since app measurement is disabled");
    }
    do
    {
      return;
      if (!amZ)
      {
        amZ = true;
        zzbvl();
      }
      boolean bool = zzal.zzmu(paramString2);
      if ((paramBoolean1) && (amX != null) && (!bool))
      {
        zzbsz().zzbtx().zze("Passing event to registered event handler (FE)", paramString2, paramBundle);
        amX.zzb(paramString1, paramString2, paramBundle, paramLong);
        return;
      }
    } while (!aja.zzbuk());
    int i = zzbsv().zzmm(paramString2);
    if (i != 0)
    {
      paramString1 = zzbsv().zza(paramString2, zzbtb().zzbrj(), true);
      aja.zzbsv().zze(i, "_ev", paramString1);
      return;
    }
    paramBundle.putString("_o", paramString1);
    Object localObject = zzf.zzab("_o");
    paramBundle = zzbsv().zza(paramString2, paramBundle, (List)localObject, paramBoolean3);
    if (paramBoolean2) {
      paramBundle = zzal(paramBundle);
    }
    for (;;)
    {
      zzbsz().zzbtx().zze("Logging event (FE)", paramString2, paramBundle);
      localObject = new EventParcel(paramString2, new EventParams(paramBundle), paramString1, paramLong);
      zzbst().zzc((EventParcel)localObject, paramString3);
      paramString3 = amY.iterator();
      while (paramString3.hasNext()) {
        ((AppMeasurement.zzc)paramString3.next()).zzc(paramString1, paramString2, paramBundle, paramLong);
      }
      break;
    }
  }
  
  private void zzbvl()
  {
    try
    {
      zzg(Class.forName(zzbvm()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzbsz().zzbtw().log("Tag Manager is not found and thus will not be used");
    }
  }
  
  private String zzbvm()
  {
    return "com.google.android.gms.tagmanager.TagManagerService";
  }
  
  private void zzcc(boolean paramBoolean)
  {
    zzwu();
    zzyv();
    zzzg();
    zzbsz().zzbtx().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    zzbta().setMeasurementEnabled(paramBoolean);
    zzbst().zzbvn();
  }
  
  protected void zza(final String paramString1, final String paramString2, final long paramLong, Bundle paramBundle, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final String paramString3)
  {
    if (paramBundle != null) {}
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzac.zza(zzac.this, paramString1, paramString2, paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString3, aee);
        }
      });
      return;
    }
  }
  
  void zza(final String paramString1, final String paramString2, final long paramLong, final Object paramObject)
  {
    zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzac.zza(zzac.this, paramString1, paramString2, paramObject, paramLong);
      }
    });
  }
  
  Bundle zzal(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zzbsv().zzl(str, paramBundle.get(str));
        if (localObject == null) {
          zzbsz().zzbtt().zzj("Param value can't be null", str);
        } else if (((!(localObject instanceof String)) && (!(localObject instanceof Character)) && (!(localObject instanceof CharSequence))) || (!TextUtils.isEmpty(String.valueOf(localObject)))) {
          zzbsv().zza(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  @TargetApi(14)
  public void zzbvj()
  {
    if ((getContext().getApplicationContext() instanceof Application))
    {
      Application localApplication = (Application)getContext().getApplicationContext();
      if (amW == null) {
        amW = new zza(null);
      }
      localApplication.unregisterActivityLifecycleCallbacks(amW);
      localApplication.registerActivityLifecycleCallbacks(amW);
      zzbsz().zzbty().log("Registered activity lifecycle callback");
    }
  }
  
  public void zzbvk()
  {
    zzwu();
    zzyv();
    zzzg();
    if (!aja.zzbuk()) {}
    String str;
    do
    {
      return;
      zzbst().zzbvk();
      str = zzbta().zzbuh();
    } while ((TextUtils.isEmpty(str)) || (str.equals(zzbss().zzbtk())));
    Bundle localBundle = new Bundle();
    localBundle.putString("_po", str);
    zze("auto", "_ou", localBundle);
  }
  
  public void zzd(String paramString1, String paramString2, Object paramObject)
  {
    zzab.zzhs(paramString1);
    long l = zzyw().currentTimeMillis();
    int i = zzbsv().zzmo(paramString2);
    if (i != 0)
    {
      paramString1 = zzbsv().zza(paramString2, zzbtb().zzbrk(), true);
      aja.zzbsv().zze(i, "_ev", paramString1);
    }
    do
    {
      return;
      if (paramObject == null) {
        break;
      }
      i = zzbsv().zzm(paramString2, paramObject);
      if (i != 0)
      {
        paramString1 = zzbsv().zza(paramString2, zzbtb().zzbrk(), true);
        aja.zzbsv().zze(i, "_ev", paramString1);
        return;
      }
      paramObject = zzbsv().zzn(paramString2, paramObject);
    } while (paramObject == null);
    zza(paramString1, paramString2, l, paramObject);
    return;
    zza(paramString1, paramString2, l, null);
  }
  
  public void zze(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzyv();
    if ((amX == null) || (zzal.zzmu(paramString2))) {}
    for (boolean bool = true;; bool = false)
    {
      zza(paramString1, paramString2, paramBundle, true, bool, false, null);
      return;
    }
  }
  
  public void zzg(Class<?> paramClass)
  {
    try
    {
      paramClass.getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { getContext() });
      return;
    }
    catch (Exception paramClass)
    {
      zzbsz().zzbtt().zzj("Failed to invoke Tag Manager's initialize() method", paramClass);
    }
  }
  
  protected void zzwv() {}
  
  @TargetApi(14)
  private class zza
    implements Application.ActivityLifecycleCallbacks
  {
    private zza() {}
    
    private boolean zzmi(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        zzd("auto", "_ldl", paramString);
        return true;
      }
      return false;
    }
    
    private boolean zzs(Uri paramUri)
    {
      String str1 = paramUri.getQueryParameter("utm_campaign");
      String str2 = paramUri.getQueryParameter("utm_source");
      String str3 = paramUri.getQueryParameter("utm_medium");
      String str4 = paramUri.getQueryParameter("gclid");
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)))
      {
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("campaign", str1);
        }
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
          localBundle.putString("medium", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("gclid", str4);
        }
        str1 = paramUri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("term", str1);
        }
        str1 = paramUri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("content", str1);
        }
        str1 = paramUri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("aclid", str1);
        }
        str1 = paramUri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("cp1", str1);
        }
        paramUri = paramUri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(paramUri)) {
          localBundle.putString("anid", paramUri);
        }
        zze("auto", "_cmp", localBundle);
        return true;
      }
      return false;
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      try
      {
        zzbsz().zzbty().log("onActivityCreated");
        paramActivity = paramActivity.getIntent();
        if (paramActivity == null) {
          return;
        }
        paramActivity = paramActivity.getData();
        if ((paramActivity == null) || (!paramActivity.isHierarchical())) {
          return;
        }
        if (paramBundle == null) {
          zzs(paramActivity);
        }
        paramActivity = paramActivity.getQueryParameter("referrer");
        if (TextUtils.isEmpty(paramActivity)) {
          return;
        }
        if (!paramActivity.contains("gclid"))
        {
          zzbsz().zzbtx().log("Activity created with data 'referrer' param without gclid");
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        zzbsz().zzbtr().zzj("Throwable caught in onActivityCreated", paramActivity);
        return;
      }
      zzbsz().zzbtx().zzj("Activity created with referrer", paramActivity);
      zzmi(paramActivity);
    }
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity)
    {
      zzbsx().zzbvv();
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      zzbsx().zzbvt();
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */