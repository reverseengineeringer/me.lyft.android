package com.squareup.picasso;

import android.graphics.Bitmap;

class FetchAction
  extends Action<Object>
{
  private Callback callback;
  private final Object target = new Object();
  
  FetchAction(Picasso paramPicasso, Request paramRequest, int paramInt1, int paramInt2, Object paramObject, String paramString, Callback paramCallback)
  {
    super(paramPicasso, null, paramRequest, paramInt1, paramInt2, 0, null, paramString, paramObject, false);
    callback = paramCallback;
  }
  
  void cancel()
  {
    super.cancel();
    callback = null;
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    if (callback != null) {
      callback.onSuccess();
    }
  }
  
  void error()
  {
    if (callback != null) {
      callback.onError();
    }
  }
  
  Object getTarget()
  {
    return target;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.FetchAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */