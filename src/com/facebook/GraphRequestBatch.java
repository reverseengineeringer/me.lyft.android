package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch
  extends AbstractList<GraphRequest>
{
  private static AtomicInteger idGenerator = new AtomicInteger();
  private String batchApplicationId;
  private Handler callbackHandler;
  private List<Callback> callbacks = new ArrayList();
  private final String id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
  private List<GraphRequest> requests = new ArrayList();
  private int timeoutInMilliseconds = 0;
  
  public GraphRequestBatch()
  {
    requests = new ArrayList();
  }
  
  public GraphRequestBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    requests = new ArrayList(paramGraphRequestBatch);
    callbackHandler = callbackHandler;
    timeoutInMilliseconds = timeoutInMilliseconds;
    callbacks = new ArrayList(callbacks);
  }
  
  public GraphRequestBatch(Collection<GraphRequest> paramCollection)
  {
    requests = new ArrayList(paramCollection);
  }
  
  public GraphRequestBatch(GraphRequest... paramVarArgs)
  {
    requests = Arrays.asList(paramVarArgs);
  }
  
  public final void add(int paramInt, GraphRequest paramGraphRequest)
  {
    requests.add(paramInt, paramGraphRequest);
  }
  
  public final boolean add(GraphRequest paramGraphRequest)
  {
    return requests.add(paramGraphRequest);
  }
  
  public void addCallback(Callback paramCallback)
  {
    if (!callbacks.contains(paramCallback)) {
      callbacks.add(paramCallback);
    }
  }
  
  public final void clear()
  {
    requests.clear();
  }
  
  public final List<GraphResponse> executeAndWait()
  {
    return executeAndWaitImpl();
  }
  
  List<GraphResponse> executeAndWaitImpl()
  {
    return GraphRequest.executeBatchAndWait(this);
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    return executeAsyncImpl();
  }
  
  GraphRequestAsyncTask executeAsyncImpl()
  {
    return GraphRequest.executeBatchAsync(this);
  }
  
  public final GraphRequest get(int paramInt)
  {
    return (GraphRequest)requests.get(paramInt);
  }
  
  public final String getBatchApplicationId()
  {
    return batchApplicationId;
  }
  
  final Handler getCallbackHandler()
  {
    return callbackHandler;
  }
  
  final List<Callback> getCallbacks()
  {
    return callbacks;
  }
  
  final String getId()
  {
    return id;
  }
  
  final List<GraphRequest> getRequests()
  {
    return requests;
  }
  
  public int getTimeout()
  {
    return timeoutInMilliseconds;
  }
  
  public final GraphRequest remove(int paramInt)
  {
    return (GraphRequest)requests.remove(paramInt);
  }
  
  public void removeCallback(Callback paramCallback)
  {
    callbacks.remove(paramCallback);
  }
  
  public final GraphRequest set(int paramInt, GraphRequest paramGraphRequest)
  {
    return (GraphRequest)requests.set(paramInt, paramGraphRequest);
  }
  
  public final void setBatchApplicationId(String paramString)
  {
    batchApplicationId = paramString;
  }
  
  final void setCallbackHandler(Handler paramHandler)
  {
    callbackHandler = paramHandler;
  }
  
  public void setTimeout(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
    }
    timeoutInMilliseconds = paramInt;
  }
  
  public final int size()
  {
    return requests.size();
  }
  
  public static abstract interface Callback
  {
    public abstract void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch);
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequestBatch.Callback
  {
    public abstract void onBatchProgress(GraphRequestBatch paramGraphRequestBatch, long paramLong1, long paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequestBatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */