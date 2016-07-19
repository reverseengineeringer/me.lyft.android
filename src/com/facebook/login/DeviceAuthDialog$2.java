package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAuthDialog$2
  implements GraphRequest.Callback
{
  DeviceAuthDialog$2(DeviceAuthDialog paramDeviceAuthDialog) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    if (paramGraphResponse.getError() != null)
    {
      DeviceAuthDialog.access$100(this$0, paramGraphResponse.getError().getException());
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    DeviceAuthDialog.RequestState localRequestState = new DeviceAuthDialog.RequestState();
    try
    {
      localRequestState.setUserCode(paramGraphResponse.getString("user_code"));
      localRequestState.setRequestCode(paramGraphResponse.getString("code"));
      localRequestState.setInterval(paramGraphResponse.getLong("interval"));
      DeviceAuthDialog.access$200(this$0, localRequestState);
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      DeviceAuthDialog.access$100(this$0, new FacebookException(paramGraphResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */