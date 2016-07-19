package com.facebook;

import org.json.JSONArray;
import org.json.JSONObject;

final class GraphRequest$3
  implements GraphRequest.Callback
{
  GraphRequest$3(GraphRequest.GraphJSONArrayCallback paramGraphJSONArrayCallback) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    if (val$callback != null)
    {
      localObject = paramGraphResponse.getJSONObject();
      if (localObject == null) {
        break label35;
      }
    }
    label35:
    for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
    {
      val$callback.onCompleted((JSONArray)localObject, paramGraphResponse);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */