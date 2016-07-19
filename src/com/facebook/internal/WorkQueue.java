package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

public class WorkQueue
{
  public static final int DEFAULT_MAX_CONCURRENT = 8;
  private final Executor executor;
  private final int maxConcurrent;
  private WorkNode pendingJobs;
  private int runningCount = 0;
  private WorkNode runningJobs = null;
  private final Object workLock = new Object();
  
  static
  {
    if (!WorkQueue.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WorkQueue()
  {
    this(8);
  }
  
  public WorkQueue(int paramInt)
  {
    this(paramInt, FacebookSdk.getExecutor());
  }
  
  public WorkQueue(int paramInt, Executor paramExecutor)
  {
    maxConcurrent = paramInt;
    executor = paramExecutor;
  }
  
  private void execute(final WorkNode paramWorkNode)
  {
    executor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          paramWorkNode.getCallback().run();
          return;
        }
        finally
        {
          WorkQueue.this.finishItemAndStartNew(paramWorkNode);
        }
      }
    });
  }
  
  private void finishItemAndStartNew(WorkNode paramWorkNode)
  {
    WorkNode localWorkNode = null;
    Object localObject = workLock;
    if (paramWorkNode != null) {}
    try
    {
      runningJobs = paramWorkNode.removeFromList(runningJobs);
      runningCount -= 1;
      paramWorkNode = localWorkNode;
      if (runningCount < maxConcurrent)
      {
        localWorkNode = pendingJobs;
        paramWorkNode = localWorkNode;
        if (localWorkNode != null)
        {
          pendingJobs = localWorkNode.removeFromList(pendingJobs);
          runningJobs = localWorkNode.addToList(runningJobs, false);
          runningCount += 1;
          localWorkNode.setIsRunning(true);
          paramWorkNode = localWorkNode;
        }
      }
      if (paramWorkNode != null) {
        execute(paramWorkNode);
      }
      return;
    }
    finally {}
  }
  
  private void startItem()
  {
    finishItemAndStartNew(null);
  }
  
  public WorkItem addActiveWorkItem(Runnable paramRunnable)
  {
    return addActiveWorkItem(paramRunnable, true);
  }
  
  public WorkItem addActiveWorkItem(Runnable arg1, boolean paramBoolean)
  {
    WorkNode localWorkNode = new WorkNode(???);
    synchronized (workLock)
    {
      pendingJobs = localWorkNode.addToList(pendingJobs, paramBoolean);
      startItem();
      return localWorkNode;
    }
  }
  
  public void validate()
  {
    Object localObject3 = workLock;
    int j = 0;
    int i = 0;
    try
    {
      if (runningJobs != null)
      {
        Object localObject1 = runningJobs;
        WorkNode localWorkNode;
        do
        {
          ((WorkNode)localObject1).verify(true);
          j = i + 1;
          localWorkNode = ((WorkNode)localObject1).getNext();
          i = j;
          localObject1 = localWorkNode;
        } while (localWorkNode != runningJobs);
      }
      if ((!$assertionsDisabled) && (runningCount != j)) {
        throw new AssertionError();
      }
    }
    finally {}
  }
  
  public static abstract interface WorkItem
  {
    public abstract boolean cancel();
    
    public abstract boolean isRunning();
    
    public abstract void moveToFront();
  }
  
  private class WorkNode
    implements WorkQueue.WorkItem
  {
    private final Runnable callback;
    private boolean isRunning;
    private WorkNode next;
    private WorkNode prev;
    
    static
    {
      if (!WorkQueue.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    WorkNode(Runnable paramRunnable)
    {
      callback = paramRunnable;
    }
    
    WorkNode addToList(WorkNode paramWorkNode, boolean paramBoolean)
    {
      assert (next == null);
      assert (prev == null);
      if (paramWorkNode == null)
      {
        prev = this;
        next = this;
        paramWorkNode = this;
      }
      while (paramBoolean)
      {
        return this;
        next = paramWorkNode;
        prev = prev;
        WorkNode localWorkNode = next;
        prev.next = this;
        prev = this;
      }
      return paramWorkNode;
    }
    
    public boolean cancel()
    {
      synchronized (workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(pendingJobs));
          return true;
        }
        return false;
      }
    }
    
    Runnable getCallback()
    {
      return callback;
    }
    
    WorkNode getNext()
    {
      return next;
    }
    
    public boolean isRunning()
    {
      return isRunning;
    }
    
    public void moveToFront()
    {
      synchronized (workLock)
      {
        if (!isRunning())
        {
          WorkQueue.access$202(WorkQueue.this, removeFromList(pendingJobs));
          WorkQueue.access$202(WorkQueue.this, addToList(pendingJobs, true));
        }
        return;
      }
    }
    
    WorkNode removeFromList(WorkNode paramWorkNode)
    {
      assert (next != null);
      assert (prev != null);
      WorkNode localWorkNode = paramWorkNode;
      if (paramWorkNode == this) {
        if (next != this) {
          break label93;
        }
      }
      label93:
      for (localWorkNode = null;; localWorkNode = next)
      {
        next.prev = prev;
        prev.next = next;
        prev = null;
        next = null;
        return localWorkNode;
      }
    }
    
    void setIsRunning(boolean paramBoolean)
    {
      isRunning = paramBoolean;
    }
    
    void verify(boolean paramBoolean)
    {
      assert (prev.next == this);
      assert (next.prev == this);
      assert (isRunning() == paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.WorkQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */