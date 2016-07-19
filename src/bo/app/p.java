package bo.app;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public final class p
  implements x
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, p.class.getName() });
  private ag b = ag.a;
  private boolean c = false;
  private boolean d = false;
  
  public final ag a()
  {
    return b;
  }
  
  public final void a(Intent paramIntent, ConnectivityManager paramConnectivityManager)
  {
    String str = paramIntent.getAction();
    if (str.equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      try
      {
        paramConnectivityManager = paramConnectivityManager.getActiveNetworkInfo();
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        if ((paramConnectivityManager == null) || (bool))
        {
          b = ag.b;
          d = false;
          c = false;
          return;
        }
      }
      catch (SecurityException paramIntent)
      {
        AppboyLogger.e(a, "Failed to get active network information.  Ensure the permission android.permission.ACCESS_NETWORK_STATE is defined in your AndroidManifest.xml", paramIntent);
        return;
      }
      d = paramConnectivityManager.isConnectedOrConnecting();
      c = paramConnectivityManager.isRoaming();
      switch (paramConnectivityManager.getType())
      {
      default: 
        b = ag.a;
        return;
      case 7: 
        b = ag.a;
        return;
      case 8: 
        b = ag.a;
        return;
      case 9: 
        b = ag.a;
        return;
      case 4: 
        b = ag.a;
        return;
      case 5: 
        b = ag.a;
        return;
      case 2: 
        b = ag.a;
        return;
      case 3: 
        b = ag.a;
        return;
      case 0: 
        switch (paramConnectivityManager.getSubtype())
        {
        default: 
          b = ag.c;
          return;
        case 3: 
          b = ag.d;
          return;
        }
        b = ag.e;
        return;
      case 1: 
        b = ag.f;
        return;
      }
      b = ag.f;
      return;
    }
    AppboyLogger.w(a, String.format("Unexpected system broadcast received [%s]", new Object[] { str }));
  }
}

/* Location:
 * Qualified Name:     bo.app.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */