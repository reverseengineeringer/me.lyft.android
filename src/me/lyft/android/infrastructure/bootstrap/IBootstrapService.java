package me.lyft.android.infrastructure.bootstrap;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IBootstrapService
{
  public abstract void bootstrap();
  
  public abstract Observable<Unit> observeBootstrapComplete();
  
  public abstract Observable<Unit> retryLoadUser();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.bootstrap.IBootstrapService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */