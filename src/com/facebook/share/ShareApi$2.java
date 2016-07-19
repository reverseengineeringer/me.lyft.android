package com.facebook.share;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareOpenGraphAction;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class ShareApi$2
  implements CollectionMapper.OnMapperCompleteListener
{
  ShareApi$2(ShareApi paramShareApi, Bundle paramBundle, ShareOpenGraphAction paramShareOpenGraphAction, GraphRequest.Callback paramCallback, FacebookCallback paramFacebookCallback) {}
  
  public void onComplete()
  {
    try
    {
      ShareApi.access$000(val$parameters);
      new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.access$100(this$0, URLEncoder.encode(val$action.getActionType(), "UTF-8")), val$parameters, HttpMethod.POST, val$requestCallback).executeAsync();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ShareInternalUtility.invokeCallbackWithException(val$callback, localUnsupportedEncodingException);
    }
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    ShareInternalUtility.invokeCallbackWithException(val$callback, paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */