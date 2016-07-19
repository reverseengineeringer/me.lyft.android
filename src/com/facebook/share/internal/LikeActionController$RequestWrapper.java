package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequestBatch;

abstract interface LikeActionController$RequestWrapper
{
  public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
  
  public abstract FacebookRequestError getError();
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.RequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */