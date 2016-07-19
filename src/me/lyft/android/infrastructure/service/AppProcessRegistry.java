package me.lyft.android.infrastructure.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.application.polling.IAppProcess;
import rx.functions.Action1;

public class AppProcessRegistry
  implements IAppProcessRegistry
{
  private List<IAppProcess> appServiceListeners;
  
  public AppProcessRegistry(IAppProcess... paramVarArgs)
  {
    appServiceListeners = Arrays.asList(paramVarArgs);
  }
  
  public void onServiceCreated()
  {
    Iterator localIterator = appServiceListeners.iterator();
    while (localIterator.hasNext()) {
      ((IAppProcess)localIterator.next()).onServiceCreated();
    }
  }
  
  public void onServiceDestroyed()
  {
    Iterator localIterator = appServiceListeners.iterator();
    while (localIterator.hasNext()) {
      ((IAppProcess)localIterator.next()).onServiceDestroyed();
    }
  }
  
  public void setErrorHandler(Action1<Throwable> paramAction1)
  {
    Iterator localIterator = appServiceListeners.iterator();
    while (localIterator.hasNext()) {
      ((IAppProcess)localIterator.next()).setErrorHandler(paramAction1);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.service.AppProcessRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */