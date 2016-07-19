package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class AndroidExecutors$UIThreadExecutor
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     bolts.AndroidExecutors.UIThreadExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */