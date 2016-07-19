package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream
  extends OutputStream
  implements RequestOutputStream
{
  private int batchMax;
  private final Handler callbackHandler;
  private GraphRequest currentRequest;
  private RequestProgress currentRequestProgress;
  private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();
  
  ProgressNoopOutputStream(Handler paramHandler)
  {
    callbackHandler = paramHandler;
  }
  
  void addProgress(long paramLong)
  {
    if (currentRequestProgress == null)
    {
      currentRequestProgress = new RequestProgress(callbackHandler, currentRequest);
      progressMap.put(currentRequest, currentRequestProgress);
    }
    currentRequestProgress.addToMax(paramLong);
    batchMax = ((int)(batchMax + paramLong));
  }
  
  int getMaxProgress()
  {
    return batchMax;
  }
  
  Map<GraphRequest, RequestProgress> getProgressMap()
  {
    return progressMap;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    currentRequest = paramGraphRequest;
    if (paramGraphRequest != null) {}
    for (paramGraphRequest = (RequestProgress)progressMap.get(paramGraphRequest);; paramGraphRequest = null)
    {
      currentRequestProgress = paramGraphRequest;
      return;
    }
  }
  
  public void write(int paramInt)
  {
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    addProgress(paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProgressNoopOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */