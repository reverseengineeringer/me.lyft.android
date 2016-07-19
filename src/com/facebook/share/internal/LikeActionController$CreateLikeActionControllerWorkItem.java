package com.facebook.share.internal;

import com.facebook.share.widget.LikeView.ObjectType;

class LikeActionController$CreateLikeActionControllerWorkItem
  implements Runnable
{
  private LikeActionController.CreationCallback callback;
  private String objectId;
  private LikeView.ObjectType objectType;
  
  LikeActionController$CreateLikeActionControllerWorkItem(String paramString, LikeView.ObjectType paramObjectType, LikeActionController.CreationCallback paramCreationCallback)
  {
    objectId = paramString;
    objectType = paramObjectType;
    callback = paramCreationCallback;
  }
  
  public void run()
  {
    LikeActionController.access$2700(objectId, objectType, callback);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.CreateLikeActionControllerWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */