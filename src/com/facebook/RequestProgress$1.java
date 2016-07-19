package com.facebook;

class RequestProgress$1
  implements Runnable
{
  RequestProgress$1(RequestProgress paramRequestProgress, GraphRequest.OnProgressCallback paramOnProgressCallback, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    val$callbackCopy.onProgress(val$currentCopy, val$maxProgressCopy);
  }
}

/* Location:
 * Qualified Name:     com.facebook.RequestProgress.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */