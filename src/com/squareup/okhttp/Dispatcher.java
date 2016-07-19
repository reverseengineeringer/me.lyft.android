package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher
{
  private final Deque<Call> executedCalls = new ArrayDeque();
  private ExecutorService executorService;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque();
  private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque();
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService)
  {
    executorService = paramExecutorService;
  }
  
  private void promoteCalls()
  {
    if (runningCalls.size() >= maxRequests) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (readyCalls.isEmpty()) {}
        localIterator = readyCalls.iterator();
      } while (!localIterator.hasNext());
      Call.AsyncCall localAsyncCall = (Call.AsyncCall)localIterator.next();
      if (runningCallsForHost(localAsyncCall) < maxRequestsPerHost)
      {
        localIterator.remove();
        runningCalls.add(localAsyncCall);
        getExecutorService().execute(localAsyncCall);
      }
    } while (runningCalls.size() < maxRequests);
  }
  
  private int runningCallsForHost(Call.AsyncCall paramAsyncCall)
  {
    int i = 0;
    Iterator localIterator = runningCalls.iterator();
    while (localIterator.hasNext()) {
      if (((Call.AsyncCall)localIterator.next()).host().equals(paramAsyncCall.host())) {
        i += 1;
      }
    }
    return i;
  }
  
  public void cancel(Object paramObject)
  {
    Object localObject;
    try
    {
      localIterator = readyCalls.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Call.AsyncCall)localIterator.next();
        if (Util.equal(paramObject, ((Call.AsyncCall)localObject).tag())) {
          ((Call.AsyncCall)localObject).cancel();
        }
      }
      localIterator = runningCalls.iterator();
    }
    finally {}
    while (localIterator.hasNext())
    {
      localObject = (Call.AsyncCall)localIterator.next();
      if (Util.equal(paramObject, ((Call.AsyncCall)localObject).tag()))
      {
        getcanceled = true;
        localObject = getengine;
        if (localObject != null) {
          ((HttpEngine)localObject).cancel();
        }
      }
    }
    Iterator localIterator = executedCalls.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Call)localIterator.next();
      if (Util.equal(paramObject, ((Call)localObject).tag())) {
        ((Call)localObject).cancel();
      }
    }
  }
  
  /* Error */
  void enqueue(Call.AsyncCall paramAsyncCall)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/squareup/okhttp/Dispatcher:runningCalls	Ljava/util/Deque;
    //   6: invokeinterface 43 1 0
    //   11: aload_0
    //   12: getfield 21	com/squareup/okhttp/Dispatcher:maxRequests	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 66	com/squareup/okhttp/Dispatcher:runningCallsForHost	(Lcom/squareup/okhttp/Call$AsyncCall;)I
    //   23: aload_0
    //   24: getfield 23	com/squareup/okhttp/Dispatcher:maxRequestsPerHost	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 30	com/squareup/okhttp/Dispatcher:runningCalls	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 73 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 77	com/squareup/okhttp/Dispatcher:getExecutorService	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 83 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 28	com/squareup/okhttp/Dispatcher:readyCalls	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 73 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	Dispatcher
    //   0	73	1	paramAsyncCall	Call.AsyncCall
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void executed(Call paramCall)
  {
    try
    {
      executedCalls.add(paramCall);
      return;
    }
    finally
    {
      paramCall = finally;
      throw paramCall;
    }
  }
  
  void finished(Call.AsyncCall paramAsyncCall)
  {
    try
    {
      if (!runningCalls.remove(paramAsyncCall)) {
        throw new AssertionError("AsyncCall wasn't running!");
      }
    }
    finally {}
    promoteCalls();
  }
  
  void finished(Call paramCall)
  {
    try
    {
      if (!executedCalls.remove(paramCall)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
  }
  
  public ExecutorService getExecutorService()
  {
    try
    {
      if (executorService == null) {
        executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = executorService;
      return localExecutorService;
    }
    finally {}
  }
  
  public int getMaxRequests()
  {
    try
    {
      int i = maxRequests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMaxRequestsPerHost()
  {
    try
    {
      int i = maxRequestsPerHost;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getQueuedCallCount()
  {
    try
    {
      int i = readyCalls.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getRunningCallCount()
  {
    try
    {
      int i = runningCalls.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setMaxRequests(int paramInt)
  {
    if (paramInt < 1) {
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally {}
    }
    maxRequests = paramInt;
    promoteCalls();
  }
  
  public void setMaxRequestsPerHost(int paramInt)
  {
    if (paramInt < 1) {
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally {}
    }
    maxRequestsPerHost = paramInt;
    promoteCalls();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Dispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */