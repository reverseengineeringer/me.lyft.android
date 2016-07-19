package com.facebook.internal;

import com.facebook.FacebookException;

final class CollectionMapper$2
  implements CollectionMapper.OnMapValueCompleteListener
{
  CollectionMapper$2(CollectionMapper.Collection paramCollection, Object paramObject, CollectionMapper.OnMapperCompleteListener paramOnMapperCompleteListener) {}
  
  public void onComplete(Object paramObject)
  {
    val$collection.set(val$key, paramObject, val$jobCompleteListener);
    val$jobCompleteListener.onComplete();
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    val$jobCompleteListener.onError(paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.CollectionMapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */