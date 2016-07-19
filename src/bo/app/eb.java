package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.enums.ErrorType;
import com.appboy.models.ResponseError;
import com.appboy.support.AppboyLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class eb
  extends dy
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, eb.class.getName() });
  private final List<ai> c = new ArrayList();
  
  public eb(String paramString, int paramInt)
  {
    super(Uri.parse(paramString + "data"));
    switch (ec.a[(paramInt - 1)])
    {
    default: 
      AppboyLogger.e(b, "Unknown dataSyncRequestType received.");
    case 5: 
      return;
    case 1: 
      c.add(ai.b);
      c.add(ai.a);
      return;
    case 2: 
      c.add(ai.b);
      return;
    case 3: 
      c.add(ai.a);
      return;
    }
    c.add(ai.d);
  }
  
  public final af a()
  {
    return af.b;
  }
  
  public final void a(bd parambd) {}
  
  public final void a(bd parambd, ResponseError paramResponseError)
  {
    parambd = paramResponseError.getType();
    if (parambd == ErrorType.REQUIRED_FIELD_MISSING) {
      AppboyLogger.e(b, String.format("Required Field Missing: %s", new Object[] { paramResponseError.getMessage() }));
    }
    while (parambd != ErrorType.BAD_INPUT) {
      return;
    }
    AppboyLogger.e(b, String.format("Bad Input: %s", new Object[] { paramResponseError.getMessage() }));
  }
  
  public final JSONObject e()
  {
    JSONObject localJSONObject = super.e();
    if (localJSONObject == null) {
      return null;
    }
    try
    {
      localJSONObject.put("only_respond_with", fl.a(c));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.w(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }
  
  public final boolean f()
  {
    if ((c == null) || (c.size() == 0)) {}
    for (int i = 1; (i != 0) && (super.f()); i = 0) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.eb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */