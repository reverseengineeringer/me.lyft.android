package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import io.fabric.sdk.android.services.events.EventTransform;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventTransform
  implements EventTransform<SessionEvent>
{
  @TargetApi(9)
  public JSONObject buildJsonForEvent(SessionEvent paramSessionEvent)
    throws IOException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      SessionEventMetadata localSessionEventMetadata = sessionEventMetadata;
      localJSONObject.put("appBundleId", appBundleId);
      localJSONObject.put("executionId", executionId);
      localJSONObject.put("installationId", installationId);
      localJSONObject.put("androidId", androidId);
      localJSONObject.put("advertisingId", advertisingId);
      localJSONObject.put("limitAdTrackingEnabled", limitAdTrackingEnabled);
      localJSONObject.put("betaDeviceToken", betaDeviceToken);
      localJSONObject.put("buildId", buildId);
      localJSONObject.put("osVersion", osVersion);
      localJSONObject.put("deviceModel", deviceModel);
      localJSONObject.put("appVersionCode", appVersionCode);
      localJSONObject.put("appVersionName", appVersionName);
      localJSONObject.put("timestamp", timestamp);
      localJSONObject.put("type", type.toString());
      if (details != null) {
        localJSONObject.put("details", new JSONObject(details));
      }
      localJSONObject.put("customType", customType);
      if (customAttributes != null) {
        localJSONObject.put("customAttributes", new JSONObject(customAttributes));
      }
      localJSONObject.put("predefinedType", predefinedType);
      if (predefinedAttributes != null) {
        localJSONObject.put("predefinedAttributes", new JSONObject(predefinedAttributes));
      }
      return localJSONObject;
    }
    catch (JSONException paramSessionEvent)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        throw new IOException(paramSessionEvent.getMessage(), paramSessionEvent);
      }
      throw new IOException(paramSessionEvent.getMessage());
    }
  }
  
  public byte[] toBytes(SessionEvent paramSessionEvent)
    throws IOException
  {
    return buildJsonForEvent(paramSessionEvent).toString().getBytes("UTF-8");
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionEventTransform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */