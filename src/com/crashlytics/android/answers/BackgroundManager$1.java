package com.crashlytics.android.answers;

import java.util.concurrent.atomic.AtomicReference;

class BackgroundManager$1
  implements Runnable
{
  BackgroundManager$1(BackgroundManager paramBackgroundManager) {}
  
  public void run()
  {
    this$0.backgroundFutureRef.set(null);
    BackgroundManager.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.BackgroundManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */