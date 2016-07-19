package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.atomic.AtomicLong;

class FileLruCache$BufferFile
{
  private static final String FILE_NAME_PREFIX = "buffer";
  private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return !paramAnonymousString.startsWith("buffer");
    }
  };
  private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.startsWith("buffer");
    }
  };
  
  static void deleteAll(File paramFile)
  {
    paramFile = paramFile.listFiles(excludeNonBufferFiles());
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        paramFile[i].delete();
        i += 1;
      }
    }
  }
  
  static FilenameFilter excludeBufferFiles()
  {
    return filterExcludeBufferFiles;
  }
  
  static FilenameFilter excludeNonBufferFiles()
  {
    return filterExcludeNonBufferFiles;
  }
  
  static File newFile(File paramFile)
  {
    return new File(paramFile, "buffer" + Long.valueOf(FileLruCache.access$300().incrementAndGet()).toString());
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.BufferFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */