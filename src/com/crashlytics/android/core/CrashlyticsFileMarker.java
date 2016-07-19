package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker
{
  private final FileStore fileStore;
  private final String markerName;
  
  public CrashlyticsFileMarker(String paramString, FileStore paramFileStore)
  {
    markerName = paramString;
    fileStore = paramFileStore;
  }
  
  private File getMarkerFile()
  {
    return new File(fileStore.getFilesDir(), markerName);
  }
  
  public boolean create()
  {
    try
    {
      boolean bool = getMarkerFile().createNewFile();
      return bool;
    }
    catch (IOException localIOException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Error creating marker: " + markerName, localIOException);
    }
    return false;
  }
  
  public boolean isPresent()
  {
    return getMarkerFile().exists();
  }
  
  public boolean remove()
  {
    return getMarkerFile().delete();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsFileMarker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */