package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ProgressOutputStream
  extends FilterOutputStream
  implements RequestOutputStream
{
  private long batchProgress;
  private RequestProgress currentRequestProgress;
  private long lastReportedProgress;
  private long maxProgress;
  private final Map<GraphRequest, RequestProgress> progressMap;
  private final GraphRequestBatch requests;
  private final long threshold;
  
  ProgressOutputStream(OutputStream paramOutputStream, GraphRequestBatch paramGraphRequestBatch, Map<GraphRequest, RequestProgress> paramMap, long paramLong)
  {
    super(paramOutputStream);
    requests = paramGraphRequestBatch;
    progressMap = paramMap;
    maxProgress = paramLong;
    threshold = FacebookSdk.getOnProgressThreshold();
  }
  
  private void addProgress(long paramLong)
  {
    if (currentRequestProgress != null) {
      currentRequestProgress.addProgress(paramLong);
    }
    batchProgress += paramLong;
    if ((batchProgress >= lastReportedProgress + threshold) || (batchProgress >= maxProgress)) {
      reportBatchProgress();
    }
  }
  
  private void reportBatchProgress()
  {
    if (batchProgress > lastReportedProgress)
    {
      Iterator localIterator = requests.getCallbacks().iterator();
      while (localIterator.hasNext())
      {
        final Object localObject = (GraphRequestBatch.Callback)localIterator.next();
        if ((localObject instanceof GraphRequestBatch.OnProgressCallback))
        {
          Handler localHandler = requests.getCallbackHandler();
          localObject = (GraphRequestBatch.OnProgressCallback)localObject;
          if (localHandler == null) {
            ((GraphRequestBatch.OnProgressCallback)localObject).onBatchProgress(requests, batchProgress, maxProgress);
          } else {
            localHandler.post(new Runnable()
            {
              public void run()
              {
                localObject.onBatchProgress(requests, batchProgress, maxProgress);
              }
            });
          }
        }
      }
      lastReportedProgress = batchProgress;
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    Iterator localIterator = progressMap.values().iterator();
    while (localIterator.hasNext()) {
      ((RequestProgress)localIterator.next()).reportProgress();
    }
    reportBatchProgress();
  }
  
  long getBatchProgress()
  {
    return batchProgress;
  }
  
  long getMaxProgress()
  {
    return maxProgress;
  }
  
  public void setCurrentRequest(GraphRequest paramGraphRequest)
  {
    if (paramGraphRequest != null) {}
    for (paramGraphRequest = (RequestProgress)progressMap.get(paramGraphRequest);; paramGraphRequest = null)
    {
      currentRequestProgress = paramGraphRequest;
      return;
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    out.write(paramArrayOfByte);
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    addProgress(paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProgressOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */