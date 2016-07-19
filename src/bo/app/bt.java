package bo.app;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bt
  extends ThreadPoolExecutor
{
  private static final TimeUnit a = TimeUnit.MILLISECONDS;
  
  public bt(ThreadFactory paramThreadFactory)
  {
    super(1, 1, 0L, a, new LinkedBlockingQueue(), paramThreadFactory);
  }
}

/* Location:
 * Qualified Name:     bo.app.bt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */