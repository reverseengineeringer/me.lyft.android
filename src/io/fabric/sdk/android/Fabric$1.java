package io.fabric.sdk.android;

import android.app.Activity;
import android.os.Bundle;

class Fabric$1
  extends ActivityLifecycleManager.Callbacks
{
  Fabric$1(Fabric paramFabric) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this$0.setCurrentActivity(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this$0.setCurrentActivity(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    this$0.setCurrentActivity(paramActivity);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.Fabric.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */