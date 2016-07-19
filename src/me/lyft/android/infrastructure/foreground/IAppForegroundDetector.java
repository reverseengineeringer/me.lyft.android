package me.lyft.android.infrastructure.foreground;

import rx.Observable;

public abstract interface IAppForegroundDetector
{
  public abstract boolean isForegrounded();
  
  public abstract Observable<Boolean> observeAppForegrounded();
  
  public abstract void onStart();
  
  public abstract void onStop();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.foreground.IAppForegroundDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */