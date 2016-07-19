package com.facebook;

import android.net.Uri;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

final class GraphRequest$7
  implements OpenGraphJSONUtility.PhotoJSONProcessor
{
  public JSONObject toJSONObject(SharePhoto paramSharePhoto)
  {
    paramSharePhoto = paramSharePhoto.getImageUrl();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramSharePhoto.toString());
      return localJSONObject;
    }
    catch (Exception paramSharePhoto)
    {
      throw new FacebookException("Unable to attach images", paramSharePhoto);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */