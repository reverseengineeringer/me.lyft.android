package bo.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public final class fn
{
  public static boolean a(Context paramContext, Class<?> paramClass)
  {
    return paramContext.getPackageManager().queryIntentServices(new Intent().setClass(paramContext, paramClass), 65536).size() > 0;
  }
}

/* Location:
 * Qualified Name:     bo.app.fn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */