package com.facebook.applinks;

import android.net.Uri;
import bolts.AppLink;
import bolts.AppLink.Target;
import bolts.Task.TaskCompletionSource;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookAppLinkResolver$2
  implements GraphRequest.Callback
{
  FacebookAppLinkResolver$2(FacebookAppLinkResolver paramFacebookAppLinkResolver, Task.TaskCompletionSource paramTaskCompletionSource, Map paramMap, HashSet paramHashSet) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    Object localObject1 = paramGraphResponse.getError();
    if (localObject1 != null)
    {
      val$taskCompletionSource.setError(((FacebookRequestError)localObject1).getException());
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    if (paramGraphResponse == null)
    {
      val$taskCompletionSource.setResult(val$appLinkResults);
      return;
    }
    localObject1 = val$urisToRequest.iterator();
    Uri localUri;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localUri = (Uri)((Iterator)localObject1).next();
    } while (!paramGraphResponse.has(localUri.toString()));
    for (;;)
    {
      int i;
      try
      {
        ??? = paramGraphResponse.getJSONObject(localUri.toString()).getJSONObject("app_links");
        Object localObject4 = ((JSONObject)???).getJSONArray("android");
        int j = ((JSONArray)localObject4).length();
        ArrayList localArrayList = new ArrayList(j);
        i = 0;
        if (i < j)
        {
          AppLink.Target localTarget = FacebookAppLinkResolver.access$000(((JSONArray)localObject4).getJSONObject(i));
          if (localTarget == null) {
            break label257;
          }
          localArrayList.add(localTarget);
          break label257;
        }
        localObject4 = new AppLink(localUri, localArrayList, FacebookAppLinkResolver.access$100(localUri, (JSONObject)???));
        val$appLinkResults.put(localUri, localObject4);
        synchronized (FacebookAppLinkResolver.access$200(this$0))
        {
          FacebookAppLinkResolver.access$200(this$0).put(localUri, localObject4);
        }
      }
      catch (JSONException localJSONException) {}
      val$taskCompletionSource.setResult(val$appLinkResults);
      return;
      label257:
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.applinks.FacebookAppLinkResolver.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */