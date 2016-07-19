package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appboy.support.AppboyLogger;

final class bx
  extends BroadcastReceiver
{
  bx(bw parambw) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      AppboyLogger.e(bw.c(), "Location broadcast receiver received null intent.");
    }
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (paramContext.endsWith(".SINGLE_APPBOY_LOCATION_UPDATE"))
      {
        bw.a(a, paramIntent);
        return;
      }
    } while (!paramContext.endsWith(".REQUEST_INIT_APPBOY_LOCATION_SERVICE"));
    a.b();
  }
}

/* Location:
 * Qualified Name:     bo.app.bx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */