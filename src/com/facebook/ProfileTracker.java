package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.Validate;

public abstract class ProfileTracker
{
  private final LocalBroadcastManager broadcastManager;
  private boolean isTracking = false;
  private final BroadcastReceiver receiver;
  
  public ProfileTracker()
  {
    Validate.sdkInitialized();
    receiver = new ProfileBroadcastReceiver(null);
    broadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
    startTracking();
  }
  
  private void addBroadcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
    broadcastManager.registerReceiver(receiver, localIntentFilter);
  }
  
  public boolean isTracking()
  {
    return isTracking;
  }
  
  protected abstract void onCurrentProfileChanged(Profile paramProfile1, Profile paramProfile2);
  
  public void startTracking()
  {
    if (isTracking) {
      return;
    }
    addBroadcastReceiver();
    isTracking = true;
  }
  
  public void stopTracking()
  {
    if (!isTracking) {
      return;
    }
    broadcastManager.unregisterReceiver(receiver);
    isTracking = false;
  }
  
  private class ProfileBroadcastReceiver
    extends BroadcastReceiver
  {
    private ProfileBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(paramIntent.getAction()))
      {
        paramContext = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE");
        paramIntent = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE");
        onCurrentProfileChanged(paramContext, paramIntent);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProfileTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */