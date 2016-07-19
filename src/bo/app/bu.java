package bo.app;

import android.content.Context;
import com.amazon.device.messaging.development.ADMManifest;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class bu
{
  public static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, bu.class.getName() });
  public final Context a;
  public final cm b;
  
  public bu(Context paramContext, cm paramcm)
  {
    a = paramContext;
    b = paramcm;
  }
  
  private static boolean a()
  {
    try
    {
      Class.forName("com.amazon.device.messaging.ADM");
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.i(c, "com.amazon.device.messaging.ADM not found");
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return (a()) && (b(paramContext));
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      ADMManifest.checkManifestAuthoredProperly(paramContext);
      return true;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.i(c, "Manifest not authored properly to support ADM.");
      AppboyLogger.i(c, "ADM manifest exception: ", paramContext);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.bu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */