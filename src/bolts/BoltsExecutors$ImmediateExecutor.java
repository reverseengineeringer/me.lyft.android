package bolts;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class BoltsExecutors$ImmediateExecutor
  implements Executor
{
  private ThreadLocal<Integer> executionDepth = new ThreadLocal();
  
  private int decrementDepth()
  {
    Integer localInteger2 = (Integer)executionDepth.get();
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = localInteger1.intValue() - 1;
    if (i == 0)
    {
      executionDepth.remove();
      return i;
    }
    executionDepth.set(Integer.valueOf(i));
    return i;
  }
  
  private int incrementDepth()
  {
    Integer localInteger2 = (Integer)executionDepth.get();
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = localInteger1.intValue() + 1;
    executionDepth.set(Integer.valueOf(i));
    return i;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (incrementDepth() <= 15) {}
    for (;;)
    {
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        decrementDepth();
      }
      BoltsExecutors.background().execute(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     bolts.BoltsExecutors.ImmediateExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */