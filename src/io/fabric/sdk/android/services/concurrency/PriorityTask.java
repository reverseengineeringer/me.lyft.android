package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PriorityTask
  implements Dependency<Task>, PriorityProvider, Task
{
  private final List<Task> dependencies = new ArrayList();
  private final AtomicBoolean hasRun = new AtomicBoolean(false);
  private final AtomicReference<Throwable> throwable = new AtomicReference(null);
  
  public static boolean isProperDelegate(Object paramObject)
  {
    boolean bool2 = false;
    try
    {
      Dependency localDependency = (Dependency)paramObject;
      Task localTask = (Task)paramObject;
      paramObject = (PriorityProvider)paramObject;
      boolean bool1 = bool2;
      if (localDependency != null)
      {
        bool1 = bool2;
        if (localTask != null)
        {
          bool1 = bool2;
          if (paramObject != null) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public void addDependency(Task paramTask)
  {
    try
    {
      dependencies.add(paramTask);
      return;
    }
    finally
    {
      paramTask = finally;
      throw paramTask;
    }
  }
  
  public boolean areDependenciesMet()
  {
    Iterator localIterator = getDependencies().iterator();
    while (localIterator.hasNext()) {
      if (!((Task)localIterator.next()).isFinished()) {
        return false;
      }
    }
    return true;
  }
  
  public int compareTo(Object paramObject)
  {
    return Priority.compareTo(this, paramObject);
  }
  
  public Collection<Task> getDependencies()
  {
    try
    {
      Collection localCollection = Collections.unmodifiableCollection(dependencies);
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Priority getPriority()
  {
    return Priority.NORMAL;
  }
  
  public boolean isFinished()
  {
    return hasRun.get();
  }
  
  public void setError(Throwable paramThrowable)
  {
    throwable.set(paramThrowable);
  }
  
  public void setFinished(boolean paramBoolean)
  {
    try
    {
      hasRun.set(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */