package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzalr
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final zzalr baU = new zzalr();
  private final AtomicBoolean baV = new AtomicBoolean();
  private boolean zzcwt;
  
  public static void zza(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(baU);
    paramApplication.registerComponentCallbacks(baU);
    baUzzcwt = true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (baV.compareAndSet(true, false)) {
      FirebaseApp.zzck(false);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (baV.compareAndSet(true, false)) {
      FirebaseApp.zzck(false);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (baV.compareAndSet(false, true))) {
      FirebaseApp.zzck(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzalr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */