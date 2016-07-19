package com.facebook.internal;

import java.io.File;

final class FileLruCache$ModifiedFile
  implements Comparable<ModifiedFile>
{
  private static final int HASH_MULTIPLIER = 37;
  private static final int HASH_SEED = 29;
  private final File file;
  private final long modified;
  
  FileLruCache$ModifiedFile(File paramFile)
  {
    file = paramFile;
    modified = paramFile.lastModified();
  }
  
  public int compareTo(ModifiedFile paramModifiedFile)
  {
    if (getModified() < paramModifiedFile.getModified()) {
      return -1;
    }
    if (getModified() > paramModifiedFile.getModified()) {
      return 1;
    }
    return getFile().compareTo(paramModifiedFile.getFile());
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0);
  }
  
  File getFile()
  {
    return file;
  }
  
  long getModified()
  {
    return modified;
  }
  
  public int hashCode()
  {
    return (file.hashCode() + 1073) * 37 + (int)(modified % 2147483647L);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.ModifiedFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */