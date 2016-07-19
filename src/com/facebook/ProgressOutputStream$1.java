package com.facebook;

class ProgressOutputStream$1
  implements Runnable
{
  ProgressOutputStream$1(ProgressOutputStream paramProgressOutputStream, GraphRequestBatch.OnProgressCallback paramOnProgressCallback) {}
  
  public void run()
  {
    val$progressCallback.onBatchProgress(ProgressOutputStream.access$000(this$0), ProgressOutputStream.access$100(this$0), ProgressOutputStream.access$200(this$0));
  }
}

/* Location:
 * Qualified Name:     com.facebook.ProgressOutputStream.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */