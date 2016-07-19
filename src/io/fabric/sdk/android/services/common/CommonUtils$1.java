package io.fabric.sdk.android.services.common;

import java.io.File;
import java.util.Comparator;

final class CommonUtils$1
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    return (int)(paramFile1.lastModified() - paramFile2.lastModified());
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.CommonUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */