package com.leanplum.activities;

import android.app.ActivityGroup;
import android.content.res.Resources;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;

public class LeanplumActivityGroup
  extends ActivityGroup
{
  private LeanplumActivityHelper a;
  
  private LeanplumActivityHelper a()
  {
    if (a == null) {
      a = new LeanplumActivityHelper(this);
    }
    return a;
  }
  
  public Resources getResources()
  {
    if (Leanplum.isTestModeEnabled()) {
      return super.getResources();
    }
    return a().getLeanplumResources(super.getResources());
  }
  
  protected void onPause()
  {
    super.onPause();
    a().onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    a().onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    a().onStop();
  }
  
  public void setContentView(int paramInt)
  {
    if (Leanplum.isTestModeEnabled()) {
      super.setContentView(paramInt);
    }
    a().setContentView(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.activities.LeanplumActivityGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */