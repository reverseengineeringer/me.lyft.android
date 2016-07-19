package bo.app;

import android.content.Context;
import com.appboy.models.IPutIntoJson;
import org.json.JSONObject;

public abstract interface fs
  extends IPutIntoJson<JSONObject>
{
  public abstract void a(Context paramContext, bd parambd);
  
  public abstract void a(String paramString);
  
  public abstract boolean a();
  
  public abstract boolean a(gh paramgh);
  
  public abstract String b();
  
  public abstract gd c();
  
  public abstract String d();
}

/* Location:
 * Qualified Name:     bo.app.fs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */