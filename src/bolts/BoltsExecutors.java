package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors
{
  private static final BoltsExecutors INSTANCE = new BoltsExecutors();
  private final ExecutorService background;
  private final Executor immediate;
  private final ScheduledExecutorService scheduled;
  
  private BoltsExecutors()
  {
    if (!isAndroidRuntime()) {}
    for (ExecutorService localExecutorService = Executors.newCachedThreadPool();; localExecutorService = AndroidExecutors.newCachedThreadPool())
    {
      background = localExecutorService;
      scheduled = Executors.newSingleThreadScheduledExecutor();
      immediate = new ImmediateExecutor(null);
      return;
    }
  }
  
  public static ExecutorService background()
  {
    return INSTANCEbackground;
  }
  
  static Executor immediate()
  {
    return INSTANCEimmediate;
  }
  
  private static boolean isAndroidRuntime()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null) {
      return false;
    }
    return str.toLowerCase(Locale.US).contains("android");
  }
  
  private static class ImmediateExecutor
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
}

/* Location:
 * Qualified Name:     bolts.BoltsExecutors
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */