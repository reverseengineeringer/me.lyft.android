package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceShareDialogFragment$2
  implements GraphRequest.Callback
{
  DeviceShareDialogFragment$2(DeviceShareDialogFragment paramDeviceShareDialogFragment) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      DeviceShareDialogFragment.access$100(this$0, (FacebookRequestError)localObject);
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    localObject = new DeviceShareDialogFragment.RequestState();
    try
    {
      ((DeviceShareDialogFragment.RequestState)localObject).setUserCode(paramGraphResponse.getString("user_code"));
      ((DeviceShareDialogFragment.RequestState)localObject).setExpiresIn(paramGraphResponse.getLong("expires_in"));
      DeviceShareDialogFragment.access$200(this$0, (DeviceShareDialogFragment.RequestState)localObject);
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      DeviceShareDialogFragment.access$100(this$0, new FacebookRequestError(0, "", "Malformed server response"));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */