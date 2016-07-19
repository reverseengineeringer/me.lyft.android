package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.appboy.support.AppboyLogger;

final class s
  extends BroadcastReceiver
{
  s(r paramr, bd parambd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      r.a(b).a(paramIntent, paramContext);
      b.c();
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(r.d(), "Failed to process connectivity event.", paramContext);
      paramIntent = b;
      r.a(a, paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */