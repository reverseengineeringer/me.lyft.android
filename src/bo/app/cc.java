package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appboy.support.AppboyLogger;

final class cc
  extends BroadcastReceiver
{
  cc(cb paramcb) {}
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized (cb.a(a))
    {
      try
      {
        cb.b(a);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          try
          {
            cb.c(a).a(paramIntent, Throwable.class);
          }
          catch (Exception paramIntent)
          {
            AppboyLogger.e(cb.f(), "Failed to log throwable.", paramIntent);
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */