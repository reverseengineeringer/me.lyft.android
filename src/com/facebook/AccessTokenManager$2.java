package com.facebook;

import android.util.Log;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

class AccessTokenManager$2
  implements GraphRequest.Callback
{
  AccessTokenManager$2(AccessTokenManager paramAccessTokenManager, AtomicBoolean paramAtomicBoolean, Set paramSet1, Set paramSet2) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    paramGraphResponse = paramGraphResponse.getJSONObject();
    if (paramGraphResponse == null) {}
    do
    {
      return;
      paramGraphResponse = paramGraphResponse.optJSONArray("data");
    } while (paramGraphResponse == null);
    val$permissionsCallSucceeded.set(true);
    int i = 0;
    label31:
    Object localObject;
    if (i < paramGraphResponse.length())
    {
      localObject = paramGraphResponse.optJSONObject(i);
      if (localObject != null) {
        break label58;
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label58:
      String str = ((JSONObject)localObject).optString("permission");
      localObject = ((JSONObject)localObject).optString("status");
      if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty((String)localObject)))
      {
        localObject = ((String)localObject).toLowerCase(Locale.US);
        if (((String)localObject).equals("granted")) {
          val$permissions.add(str);
        } else if (((String)localObject).equals("declined")) {
          val$declinedPermissions.add(str);
        } else {
          Log.w("AccessTokenManager", "Unexpected status: " + (String)localObject);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessTokenManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */