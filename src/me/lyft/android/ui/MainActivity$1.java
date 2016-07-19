package me.lyft.android.ui;

import me.lyft.android.infrastructure.activity.ActivityServiceRegistry;

class MainActivity$1
  implements Runnable
{
  MainActivity$1(MainActivity paramMainActivity) {}
  
  public void run()
  {
    if (MainActivity.access$000(this$0) != null)
    {
      this$0.activityServiceRegistry.onActivityResult(this$0, MainActivity.access$000(this$0));
      MainActivity.access$002(this$0, null);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */