package com.facebook.internal;

class WorkQueue$1
  implements Runnable
{
  WorkQueue$1(WorkQueue paramWorkQueue, WorkQueue.WorkNode paramWorkNode) {}
  
  public void run()
  {
    try
    {
      val$node.getCallback().run();
      return;
    }
    finally
    {
      WorkQueue.access$000(this$0, val$node);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.WorkQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */