package bo.app;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class br
  implements ThreadFactory
{
  public Thread.UncaughtExceptionHandler a;
  private final AtomicInteger b = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    if (a == null) {
      throw new IllegalStateException("No UncaughtExceptionHandler. You must call setUncaughtExceptionHandler before creating a new thread");
    }
    paramRunnable = new Thread(paramRunnable, String.format("%s #%d", new Object[] { br.class.getSimpleName(), Integer.valueOf(b.getAndIncrement()) }));
    paramRunnable.setUncaughtExceptionHandler(a);
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     bo.app.br
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */