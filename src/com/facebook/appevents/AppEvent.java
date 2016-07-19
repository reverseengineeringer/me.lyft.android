package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class AppEvent
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final HashSet<String> validatedIdentifiers = new HashSet();
  private boolean isImplicit;
  private JSONObject jsonObject;
  private String name;
  
  public AppEvent(String paramString1, String paramString2, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    try
    {
      validateIdentifier(paramString2);
      name = paramString2;
      isImplicit = paramBoolean;
      jsonObject = new JSONObject();
      jsonObject.put("_eventName", paramString2);
      jsonObject.put("_logTime", System.currentTimeMillis() / 1000L);
      jsonObject.put("_ui", paramString1);
      if (paramUUID != null) {
        jsonObject.put("_session_id", paramUUID);
      }
      if (paramDouble != null) {
        jsonObject.put("_valueToSum", paramDouble.doubleValue());
      }
      if (isImplicit) {
        jsonObject.put("_implicitlyLogged", "1");
      }
      if (paramBundle == null) {
        break label282;
      }
      paramString1 = paramBundle.keySet().iterator();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] { paramString1.toString() });
        jsonObject = null;
        return;
        jsonObject.put(paramString2, paramDouble.toString());
      }
    }
    catch (FacebookException paramString1)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", new Object[] { paramString1.toString() });
      jsonObject = null;
      return;
    }
    if (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      validateIdentifier(paramString2);
      paramDouble = paramBundle.get(paramString2);
      if ((!(paramDouble instanceof String)) && (!(paramDouble instanceof Number))) {
        throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] { paramDouble, paramString2 }));
      }
    }
    label282:
    while (isImplicit) {}
    Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", new Object[] { jsonObject.toString() });
  }
  
  private AppEvent(String paramString, boolean paramBoolean)
    throws JSONException
  {
    jsonObject = new JSONObject(paramString);
    isImplicit = paramBoolean;
  }
  
  private void validateIdentifier(String paramString)
    throws FacebookException
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.length() > 40))
    {
      ??? = paramString;
      if (paramString == null) {
        ??? = "<None Provided>";
      }
      throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] { ???, Integer.valueOf(40) }));
    }
    synchronized (validatedIdentifiers)
    {
      boolean bool = validatedIdentifiers.contains(paramString);
      if (!bool) {
        if (!paramString.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
          break label117;
        }
      }
    }
    synchronized (validatedIdentifiers)
    {
      validatedIdentifiers.add(paramString);
      return;
      paramString = finally;
      throw paramString;
    }
    label117:
    throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] { paramString }));
  }
  
  private Object writeReplace()
  {
    return new SerializationProxyV1(jsonObject.toString(), isImplicit, null);
  }
  
  public boolean getIsImplicit()
  {
    return isImplicit;
  }
  
  public JSONObject getJSONObject()
  {
    return jsonObject;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String toString()
  {
    return String.format("\"%s\", implicit: %b, json: %s", new Object[] { jsonObject.optString("_eventName"), Boolean.valueOf(isImplicit), jsonObject.toString() });
  }
  
  static class SerializationProxyV1
    implements Serializable
  {
    private static final long serialVersionUID = -2488473066578201069L;
    private final boolean isImplicit;
    private final String jsonString;
    
    private SerializationProxyV1(String paramString, boolean paramBoolean)
    {
      jsonString = paramString;
      isImplicit = paramBoolean;
    }
    
    private Object readResolve()
      throws JSONException
    {
      return new AppEvent(jsonString, isImplicit, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */