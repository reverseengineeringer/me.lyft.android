package com.facebook.login;

import android.app.Dialog;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAuthDialog$5
  implements GraphRequest.Callback
{
  DeviceAuthDialog$5(DeviceAuthDialog paramDeviceAuthDialog, String paramString) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    if (DeviceAuthDialog.access$400(this$0).get()) {
      return;
    }
    if (paramGraphResponse.getError() != null)
    {
      DeviceAuthDialog.access$100(this$0, paramGraphResponse.getError().getException());
      return;
    }
    try
    {
      Object localObject = paramGraphResponse.getJSONObject();
      paramGraphResponse = ((JSONObject)localObject).getString("id");
      localObject = Utility.handlePermissionResponse((JSONObject)localObject);
      DeviceAuthDialog.access$700(this$0).onSuccess(val$accessToken, FacebookSdk.getApplicationId(), paramGraphResponse, ((Utility.PermissionsPair)localObject).getGrantedPermissions(), ((Utility.PermissionsPair)localObject).getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null);
      DeviceAuthDialog.access$800(this$0).dismiss();
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      DeviceAuthDialog.access$100(this$0, new FacebookException(paramGraphResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */