package com.squareup.okhttp.internal;

import java.io.IOException;

class DiskLruCache$1
  implements Runnable
{
  DiskLruCache$1(DiskLruCache paramDiskLruCache) {}
  
  public void run()
  {
    int i = 0;
    synchronized (this$0)
    {
      if (!DiskLruCache.access$000(this$0)) {
        i = 1;
      }
      if ((i | DiskLruCache.access$100(this$0)) != 0) {
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */