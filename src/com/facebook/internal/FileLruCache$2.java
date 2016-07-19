package com.facebook.internal;

import java.io.File;

class FileLruCache$2
  implements Runnable
{
  FileLruCache$2(FileLruCache paramFileLruCache, File[] paramArrayOfFile) {}
  
  public void run()
  {
    File[] arrayOfFile = val$filesToDelete;
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFile[i].delete();
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */