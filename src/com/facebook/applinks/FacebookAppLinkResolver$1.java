package com.facebook.applinks;

import android.net.Uri;
import bolts.AppLink;
import bolts.Continuation;
import bolts.Task;
import java.util.Map;

class FacebookAppLinkResolver$1
  implements Continuation<Map<Uri, AppLink>, AppLink>
{
  FacebookAppLinkResolver$1(FacebookAppLinkResolver paramFacebookAppLinkResolver, Uri paramUri) {}
  
  public AppLink then(Task<Map<Uri, AppLink>> paramTask)
    throws Exception
  {
    return (AppLink)((Map)paramTask.getResult()).get(val$uri);
  }
}

/* Location:
 * Qualified Name:     com.facebook.applinks.FacebookAppLinkResolver.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */