package com.facebook.internal;

import com.facebook.FacebookException;

final class CollectionMapper$1
  implements CollectionMapper.OnMapperCompleteListener
{
  CollectionMapper$1(Mutable paramMutable1, Mutable paramMutable2, CollectionMapper.OnMapperCompleteListener paramOnMapperCompleteListener) {}
  
  public void onComplete()
  {
    if (((Boolean)val$didReturnError.value).booleanValue()) {}
    Integer localInteger;
    do
    {
      return;
      Mutable localMutable = val$pendingJobCount;
      localInteger = Integer.valueOf(((Integer)val$pendingJobCount.value).intValue() - 1);
      value = localInteger;
    } while (localInteger.intValue() != 0);
    val$onMapperCompleteListener.onComplete();
  }
  
  public void onError(FacebookException paramFacebookException)
  {
    if (((Boolean)val$didReturnError.value).booleanValue()) {
      return;
    }
    val$didReturnError.value = Boolean.valueOf(true);
    val$onMapperCompleteListener.onError(paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.CollectionMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */