package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import org.json.JSONArray;

class ShareApi$6
  implements CollectionMapper.OnMapperCompleteListener
{
  ShareApi$6(ShareApi paramShareApi, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener, JSONArray paramJSONArray) {}
  
  public void onComplete()
  {
    val$onArrayListStagedListener.onComplete(val$stagedObject);
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    val$onArrayListStagedListener.onError(paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */