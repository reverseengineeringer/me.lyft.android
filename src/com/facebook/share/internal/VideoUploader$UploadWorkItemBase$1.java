package com.facebook.share.internal;

class VideoUploader$UploadWorkItemBase$1
  implements Runnable
{
  VideoUploader$UploadWorkItemBase$1(VideoUploader.UploadWorkItemBase paramUploadWorkItemBase) {}
  
  public void run()
  {
    this$0.enqueueRetry(this$0.completedRetries + 1);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.UploadWorkItemBase.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */