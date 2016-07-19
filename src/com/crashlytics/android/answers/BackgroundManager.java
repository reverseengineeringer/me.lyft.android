package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class BackgroundManager
{
  final AtomicReference<ScheduledFuture<?>> backgroundFutureRef = new AtomicReference();
  private final ScheduledExecutorService executorService;
  private volatile boolean flushOnBackground = true;
  boolean inBackground = true;
  private final List<Listener> listeners = new ArrayList();
  
  public BackgroundManager(ScheduledExecutorService paramScheduledExecutorService)
  {
    executorService = paramScheduledExecutorService;
  }
  
  private void notifyBackground()
  {
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((Listener)localIterator.next()).onBackground();
    }
  }
  
  public void onActivityPaused()
  {
    if ((flushOnBackground) && (!inBackground)) {
      inBackground = true;
    }
    try
    {
      backgroundFutureRef.compareAndSet(null, executorService.schedule(new Runnable()
      {
        public void run()
        {
          backgroundFutureRef.set(null);
          BackgroundManager.this.notifyBackground();
        }
      }, 5000L, TimeUnit.MILLISECONDS));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Fabric.getLogger().d("Answers", "Failed to schedule background detector", localRejectedExecutionException);
    }
  }
  
  public void onActivityResumed()
  {
    inBackground = false;
    ScheduledFuture localScheduledFuture = (ScheduledFuture)backgroundFutureRef.getAndSet(null);
    if (localScheduledFuture != null) {
      localScheduledFuture.cancel(false);
    }
  }
  
  public void registerListener(Listener paramListener)
  {
    listeners.add(paramListener);
  }
  
  public void setFlushOnBackground(boolean paramBoolean)
  {
    flushOnBackground = paramBoolean;
  }
  
  public static abstract interface Listener
  {
    public abstract void onBackground();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.BackgroundManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */