package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import com.appboy.enums.ErrorType;
import com.appboy.events.SubmitFeedbackFailed;
import com.appboy.events.SubmitFeedbackSucceeded;
import com.appboy.models.ResponseError;
import com.appboy.models.outgoing.Feedback;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public final class ed
  extends dy
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ed.class.getName() });
  private final Feedback c;
  
  public ed(String paramString, Feedback paramFeedback)
  {
    super(Uri.parse(paramString + "feedback"));
    c = paramFeedback;
  }
  
  public final af a()
  {
    return af.b;
  }
  
  public final void a(bd parambd)
  {
    parambd.a(new SubmitFeedbackSucceeded(c), SubmitFeedbackSucceeded.class);
  }
  
  public final void a(bd parambd, ResponseError paramResponseError)
  {
    ErrorType localErrorType = paramResponseError.getType();
    String str = paramResponseError.getMessage();
    if (localErrorType == ErrorType.REQUIRED_FIELD_MISSING) {
      AppboyLogger.e(b, String.format("Required Field Missing: %s", new Object[] { str }));
    }
    for (;;)
    {
      parambd.a(new SubmitFeedbackFailed(c, paramResponseError), SubmitFeedbackFailed.class);
      return;
      if (localErrorType == ErrorType.BAD_INPUT) {
        AppboyLogger.e(b, String.format("Bad Input: %s", new Object[] { str }));
      }
    }
  }
  
  public final JSONObject e()
  {
    JSONObject localJSONObject = super.e();
    if (localJSONObject == null) {
      return null;
    }
    try
    {
      localJSONObject.put("feedback", c.forJsonPut());
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
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.ed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */