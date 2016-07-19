package com.facebook;

import android.os.Handler;

class RequestProgress
{
  private final Handler callbackHandler;
  private long lastReportedProgress;
  private long maxProgress;
  private long progress;
  private final GraphRequest request;
  private final long threshold;
  
  RequestProgress(Handler paramHandler, GraphRequest paramGraphRequest)
  {
    request = paramGraphRequest;
    callbackHandler = paramHandler;
    threshold = FacebookSdk.getOnProgressThreshold();
  }
  
  void addProgress(long paramLong)
  {
    progress += paramLong;
    if ((progress >= lastReportedProgress + threshold) || (progress >= maxProgress)) {
      reportProgress();
    }
  }
  
  void addToMax(long paramLong)
  {
    maxProgress += paramLong;
  }
  
  long getMaxProgress()
  {
    return maxProgress;
  }
  
  long getProgress()
  {
    return progress;
  }
  
  void reportProgress()
  {
    final Object localObject;
    final long l1;
    long l2;
    if (progress > lastReportedProgress)
    {
      localObject = request.getCallback();
      if ((maxProgress > 0L) && ((localObject instanceof GraphRequest.OnProgressCallback)))
      {
        l1 = progress;
        l2 = maxProgress;
        localObject = (GraphRequest.OnProgressCallback)localObject;
        if (callbackHandler != null) {
          break label80;
        }
        ((GraphRequest.OnProgressCallback)localObject).onProgress(l1, l2);
      }
    }
    for (;;)
    {
      lastReportedProgress = progress;
      return;
      label80:
      callbackHandler.post(new Runnable()
      {
        public void run()
        {
          localObject.onProgress(l1, val$maxProgressCopy);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.RequestProgress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */