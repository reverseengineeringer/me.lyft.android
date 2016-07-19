package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class Action<T>
{
  boolean cancelled;
  final Drawable errorDrawable;
  final int errorResId;
  final String key;
  final int memoryPolicy;
  final int networkPolicy;
  final boolean noFade;
  final Picasso picasso;
  final Request request;
  final Object tag;
  final WeakReference<T> target;
  boolean willReplay;
  
  Action(Picasso paramPicasso, T paramT, Request paramRequest, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString, Object paramObject, boolean paramBoolean)
  {
    picasso = paramPicasso;
    request = paramRequest;
    if (paramT == null)
    {
      paramPicasso = null;
      target = paramPicasso;
      memoryPolicy = paramInt1;
      networkPolicy = paramInt2;
      noFade = paramBoolean;
      errorResId = paramInt3;
      errorDrawable = paramDrawable;
      key = paramString;
      if (paramObject == null) {
        break label90;
      }
    }
    for (;;)
    {
      tag = paramObject;
      return;
      paramPicasso = new RequestWeakReference(this, paramT, referenceQueue);
      break;
      label90:
      paramObject = this;
    }
  }
  
  void cancel()
  {
    cancelled = true;
  }
  
  abstract void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  abstract void error();
  
  String getKey()
  {
    return key;
  }
  
  int getMemoryPolicy()
  {
    return memoryPolicy;
  }
  
  int getNetworkPolicy()
  {
    return networkPolicy;
  }
  
  Picasso getPicasso()
  {
    return picasso;
  }
  
  Picasso.Priority getPriority()
  {
    return request.priority;
  }
  
  Request getRequest()
  {
    return request;
  }
  
  Object getTag()
  {
    return tag;
  }
  
  T getTarget()
  {
    if (target == null) {
      return null;
    }
    return (T)target.get();
  }
  
  boolean isCancelled()
  {
    return cancelled;
  }
  
  boolean willReplay()
  {
    return willReplay;
  }
  
  static class RequestWeakReference<M>
    extends WeakReference<M>
  {
    final Action action;
    
    public RequestWeakReference(Action paramAction, M paramM, ReferenceQueue<? super M> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      action = paramAction;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */