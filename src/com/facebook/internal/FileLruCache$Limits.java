package com.facebook.internal;

import java.security.InvalidParameterException;

public final class FileLruCache$Limits
{
  private int byteCount = 1048576;
  private int fileCount = 1024;
  
  int getByteCount()
  {
    return byteCount;
  }
  
  int getFileCount()
  {
    return fileCount;
  }
  
  void setByteCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new InvalidParameterException("Cache byte-count limit must be >= 0");
    }
    byteCount = paramInt;
  }
  
  void setFileCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new InvalidParameterException("Cache file count limit must be >= 0");
    }
    fileCount = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.Limits
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */