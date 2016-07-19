package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAuthDialog$4
  implements GraphRequest.Callback
{
  DeviceAuthDialog$4(DeviceAuthDialog paramDeviceAuthDialog) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    if (DeviceAuthDialog.access$400(this$0).get()) {
      return;
    }
    FacebookRequestError localFacebookRequestError = paramGraphResponse.getError();
    if (localFacebookRequestError != null)
    {
      switch (localFacebookRequestError.getSubErrorCode())
      {
      default: 
        DeviceAuthDialog.access$100(this$0, paramGraphResponse.getError().getException());
        return;
      case 1349172: 
      case 1349174: 
        DeviceAuthDialog.access$500(this$0);
        return;
      }
      DeviceAuthDialog.access$000(this$0);
      return;
    }
    try
    {
      paramGraphResponse = paramGraphResponse.getJSONObject();
      DeviceAuthDialog.access$600(this$0, paramGraphResponse.getString("access_token"));
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      DeviceAuthDialog.access$100(this$0, new FacebookException(paramGraphResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */