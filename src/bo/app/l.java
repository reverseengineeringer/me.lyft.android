package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class l
{
  public final SharedPreferences a;
  
  public l(Context paramContext)
  {
    a = paramContext.getSharedPreferences("com.appboy.offline.storagemap", 0);
  }
  
  public static SharedPreferences.Editor a(Context paramContext)
  {
    return paramContext.getSharedPreferences("com_appboy_override_configuration_cache", 0).edit();
  }
  
  public final String a()
  {
    return a.getString("last_user", "");
  }
}

/* Location:
 * Qualified Name:     bo.app.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */