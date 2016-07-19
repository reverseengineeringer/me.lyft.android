package bo.app;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.Constants;
import com.appboy.managers.InAppMessageManagerStateListener;
import com.appboy.models.IInAppMessage;
import com.appboy.support.AppboyLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class ft
  extends fv
  implements fs
{
  private static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ft.class.getName() });
  private IInAppMessage d;
  private ch e;
  private String f;
  
  public ft(JSONObject paramJSONObject, ch paramch)
  {
    super(paramJSONObject);
    paramJSONObject = paramJSONObject.getJSONObject("data");
    if (paramJSONObject != null)
    {
      e = paramch;
      if (paramJSONObject.optBoolean("is_control", false))
      {
        paramch = c;
        d = new cv(paramJSONObject, e);
        return;
      }
      paramch = c;
      d = fj.a(paramJSONObject, e);
      return;
    }
    AppboyLogger.w(c, "InAppMessageTriggeredAction Json did not contain in-app message.");
  }
  
  public final void a(Context paramContext, bd parambd)
  {
    try
    {
      if (getInstancea.get())
      {
        JSONObject localJSONObject = (JSONObject)d.forJsonPut();
        if ((d instanceof cv))
        {
          paramContext = c;
          new cv(localJSONObject, e).a();
          return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new fu(this, localJSONObject, parambd, paramContext), b.d() * 1000);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      AppboyLogger.w(c, "Caught JSON exception while performing triggered action.", paramContext);
      return;
      AppboyLogger.i(c, "No in-app message manager registered. Storing triggered message.");
      paramContext = Appboy.getInstance(paramContext).getCurrentUser().getUserId();
      InAppMessageManagerStateListener.getInstance().a(this, paramContext, parambd);
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.w(c, "Caught exception while performing triggered action.", paramContext);
    }
  }
  
  public final void a(String paramString)
  {
    f = paramString;
  }
  
  public final String d()
  {
    return d.getRemoteAssetPathForPrefetch();
  }
  
  public final JSONObject e()
  {
    try
    {
      JSONObject localJSONObject = super.e();
      localJSONObject.put("data", d.forJsonPut());
      localJSONObject.put("type", "inapp");
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.ft
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */