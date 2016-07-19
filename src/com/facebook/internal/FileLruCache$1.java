package com.facebook.internal;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

class FileLruCache$1
  implements FileLruCache.StreamCloseCallback
{
  FileLruCache$1(FileLruCache paramFileLruCache, long paramLong, File paramFile, String paramString) {}
  
  public void onClose()
  {
    if (val$bufferFileCreateTime < FileLruCache.access$000(this$0).get())
    {
      val$buffer.delete();
      return;
    }
    FileLruCache.access$100(this$0, val$key, val$buffer);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */