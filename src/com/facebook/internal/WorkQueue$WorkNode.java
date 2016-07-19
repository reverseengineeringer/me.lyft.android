package com.facebook.internal;

class WorkQueue$WorkNode
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
  
  WorkQueue$WorkNode(WorkQueue paramWorkQueue, Runnable paramRunnable)
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
    synchronized (WorkQueue.access$100(this$0))
    {
      if (!isRunning())
      {
        WorkQueue.access$202(this$0, removeFromList(WorkQueue.access$200(this$0)));
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
    synchronized (WorkQueue.access$100(this$0))
    {
      if (!isRunning())
      {
        WorkQueue.access$202(this$0, removeFromList(WorkQueue.access$200(this$0)));
        WorkQueue.access$202(this$0, addToList(WorkQueue.access$200(this$0), true));
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

/* Location:
 * Qualified Name:     com.facebook.internal.WorkQueue.WorkNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */