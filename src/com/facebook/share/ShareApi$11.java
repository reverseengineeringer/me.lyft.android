package com.facebook.share;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

class ShareApi$11
  implements CollectionMapper.OnMapperCompleteListener
{
  ShareApi$11(ShareApi paramShareApi, JSONObject paramJSONObject, String paramString, GraphRequest.Callback paramCallback, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener) {}
  
  public void onComplete()
  {
    String str = val$stagedObject.toString();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("object", str);
    try
    {
      new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.access$100(this$0, "objects/" + URLEncoder.encode(val$ogType, "UTF-8")), (Bundle)localObject2, HttpMethod.POST, val$requestCallback).executeAsync();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localObject2 = localUnsupportedEncodingException.getLocalizedMessage();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "Error staging Open Graph object.";
      }
      val$onOpenGraphObjectStagedListener.onError(new FacebookException((String)localObject1));
    }
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    val$onOpenGraphObjectStagedListener.onError(paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */