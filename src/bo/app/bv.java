package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import java.util.UUID;

public final class bv
  implements ck
{
  private final Context a;
  
  public bv(Context paramContext)
  {
    a = paramContext;
  }
  
  public final dg a()
  {
    return new dg(Build.SERIAL, b());
  }
  
  public final String b()
  {
    SharedPreferences localSharedPreferences = a.getSharedPreferences("com.appboy.device", 0);
    Object localObject2 = localSharedPreferences.getString("device_id", null);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = UUID.randomUUID().toString();
      localObject2 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject2).putString("device_id", (String)localObject1);
      ((SharedPreferences.Editor)localObject2).apply();
    }
    return (String)localObject1;
  }
}

/* Location:
 * Qualified Name:     bo.app.bv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */