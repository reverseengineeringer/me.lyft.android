package me.lyft.android.application.polling;

import rx.functions.Action1;

public abstract interface IAppProcess
{
  public abstract void onServiceCreated();
  
  public abstract void onServiceDestroyed();
  
  public abstract void setErrorHandler(Action1<Throwable> paramAction1);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.IAppProcess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */