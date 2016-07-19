package me.lyft.android.test;

import android.app.Activity;
import android.content.Intent;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.utils.ActivityResult;

public class TestActivity
  extends Activity
{
  ActivityService service = new NoOpActivityService();
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    service.onActivityResult(this, ActivityResult.create(paramInt1, paramInt2, paramIntent));
  }
  
  public void setTestedService(ActivityService paramActivityService)
  {
    service = paramActivityService;
  }
  
  static class NoOpActivityService
    extends ActivityService
  {}
}

/* Location:
 * Qualified Name:     me.lyft.android.test.TestActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */