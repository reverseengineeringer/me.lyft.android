package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SessionReport
  implements Report
{
  private final Map<String, String> customHeaders;
  private final File file;
  
  public SessionReport(File paramFile)
  {
    this(paramFile, Collections.emptyMap());
  }
  
  public SessionReport(File paramFile, Map<String, String> paramMap)
  {
    file = paramFile;
    customHeaders = new HashMap(paramMap);
    if (file.length() == 0L) {
      customHeaders.putAll(ReportUploader.HEADER_INVALID_CLS_FILE);
    }
  }
  
  public Map<String, String> getCustomHeaders()
  {
    return Collections.unmodifiableMap(customHeaders);
  }
  
  public File getFile()
  {
    return file;
  }
  
  public String getFileName()
  {
    return getFile().getName();
  }
  
  public String getIdentifier()
  {
    String str = getFileName();
    return str.substring(0, str.lastIndexOf('.'));
  }
  
  public boolean remove()
  {
    Fabric.getLogger().d("CrashlyticsCore", "Removing report at " + file.getPath());
    return file.delete();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.SessionReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */