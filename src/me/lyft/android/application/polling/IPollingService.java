package me.lyft.android.application.polling;

import rx.functions.Action1;

public abstract interface IPollingService
{
  public abstract void setErrorHandler(Action1<Throwable> paramAction1);
  
  public abstract void start();
  
  public abstract void stop();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.IPollingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */