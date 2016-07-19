package com.facebook.share.internal;

abstract interface LikeActionController$LikeRequestWrapper
  extends LikeActionController.RequestWrapper
{
  public abstract String getUnlikeToken();
  
  public abstract boolean isObjectLiked();
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.LikeRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */