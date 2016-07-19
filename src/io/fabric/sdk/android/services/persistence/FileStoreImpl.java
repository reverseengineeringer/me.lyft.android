package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import java.io.File;

public class FileStoreImpl
  implements FileStore
{
  private final String contentPath;
  private final Context context;
  private final String legacySupport;
  
  public FileStoreImpl(Kit paramKit)
  {
    if (paramKit.getContext() == null) {
      throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }
    context = paramKit.getContext();
    contentPath = paramKit.getPath();
    legacySupport = ("Android/" + context.getPackageName());
  }
  
  public File getFilesDir()
  {
    return prepare(context.getFilesDir());
  }
  
  File prepare(File paramFile)
  {
    if (paramFile != null)
    {
      if ((paramFile.exists()) || (paramFile.mkdirs())) {
        return paramFile;
      }
      Fabric.getLogger().w("Fabric", "Couldn't create file");
    }
    for (;;)
    {
      return null;
      Fabric.getLogger().d("Fabric", "Null File");
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.persistence.FileStoreImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */