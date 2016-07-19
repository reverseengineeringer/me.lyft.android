package me.lyft.android.rx;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;
import rx.Scheduler.Worker;

final class MainThreadScheduler
  extends Scheduler
{
  private static final MainThreadScheduler INSTANCE = new MainThreadScheduler();
  private final Handler handler = new Handler(Looper.getMainLooper());
  
  public static Scheduler mainThread()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new MainThreadScheduler.InnerHandlerThreadScheduler(handler);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.rx.MainThreadScheduler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */