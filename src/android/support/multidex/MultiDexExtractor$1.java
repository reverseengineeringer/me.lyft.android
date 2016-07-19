package android.support.multidex;

import java.io.File;
import java.io.FileFilter;

final class MultiDexExtractor$1
  implements FileFilter
{
  MultiDexExtractor$1(String paramString) {}
  
  public boolean accept(File paramFile)
  {
    return !paramFile.getName().startsWith(val$extractedFilePrefix);
  }
}

/* Location:
 * Qualified Name:     android.support.multidex.MultiDexExtractor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */