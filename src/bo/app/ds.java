package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class ds
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ds.class.getName() });
  public static boolean c = false;
  public final SharedPreferences b;
  private by d;
  
  public ds(Context paramContext, String paramString, by paramby)
  {
    d = paramby;
    if (paramString == null) {
      AppboyLogger.e(a, "PlaceIQManager received null api key.");
    }
    for (paramString = "";; paramString = "." + paramString)
    {
      b = paramContext.getSharedPreferences("com.appboy.storage.piqqueue" + paramString, 0);
      if (c) {
        break;
      }
      new dt(this, (byte)0).execute(new Void[0]);
      return;
    }
    AppboyLogger.i(a, "Not calling piq because it has already been attempted this app run");
  }
}

/* Location:
 * Qualified Name:     bo.app.ds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */