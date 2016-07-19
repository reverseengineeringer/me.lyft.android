package bo.app;

import com.appboy.Constants;
import com.appboy.enums.inappmessage.MessageType;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageFull;
import com.appboy.models.InAppMessageHtmlFull;
import com.appboy.models.InAppMessageModal;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class fj
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fj.class.getName() });
  
  public static IInAppMessage a(String paramString, ch paramch)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.i(a, "In-app message string was null or blank.  Not de-serializing message.");
        return null;
      }
      paramch = a(new JSONObject(paramString), paramch);
      return paramch;
    }
    catch (JSONException paramch)
    {
      AppboyLogger.w(a, "Encountered JSONException processing in-app message string: " + paramString, paramch);
      return null;
    }
    catch (Exception paramch)
    {
      AppboyLogger.e(a, "Failed to deserialize the in-app message string." + paramString, paramch);
    }
    return null;
  }
  
  public static IInAppMessage a(JSONObject paramJSONObject, ch paramch)
  {
    if (paramJSONObject == null) {}
    try
    {
      paramch = a;
      return null;
    }
    catch (JSONException paramch)
    {
      MessageType localMessageType;
      AppboyLogger.w(a, "Encountered JSONException processing in-app message: " + paramJSONObject.toString(), paramch);
      return null;
      paramch = new InAppMessageModal(paramJSONObject, paramch);
      return paramch;
    }
    catch (Exception paramch)
    {
      AppboyLogger.e(a, "Failed to deserialize the in-app message: " + paramJSONObject.toString(), paramch);
      return null;
    }
    localMessageType = (MessageType)fl.a(paramJSONObject, "type", MessageType.class, null);
    if (localMessageType == null)
    {
      AppboyLogger.i(a, "In-app message type was null.  Not de-serializing message: " + paramJSONObject.toString());
      return null;
    }
    switch (fk.a[localMessageType.ordinal()])
    {
    }
    for (;;)
    {
      AppboyLogger.e(a, "Unknown in-app message type.  Not de-serializing message: " + paramJSONObject.toString());
      return null;
      paramch = new InAppMessageFull(paramJSONObject, paramch);
      return paramch;
      return new InAppMessageSlideup(paramJSONObject, paramch);
      paramch = new InAppMessageHtmlFull(paramJSONObject, paramch);
      return paramch;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.fj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */