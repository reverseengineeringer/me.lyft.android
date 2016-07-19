package com.appboy.ui.activities;

import android.support.v4.app.FragmentActivity;
import com.appboy.Appboy;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;

public class AppboyBaseFragmentActivity
  extends FragmentActivity
{
  public void onPause()
  {
    super.onPause();
    AppboyInAppMessageManager.getInstance().unregisterInAppMessageManager(this);
  }
  
  public void onResume()
  {
    super.onResume();
    AppboyInAppMessageManager.getInstance().registerInAppMessageManager(this);
  }
  
  public void onStart()
  {
    super.onStart();
    Appboy.getInstance(this).openSession(this);
  }
  
  public void onStop()
  {
    super.onStop();
    Appboy.getInstance(this).closeSession(this);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.activities.AppboyBaseFragmentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */