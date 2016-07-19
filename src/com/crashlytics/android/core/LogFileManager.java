package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.util.Set;

class LogFileManager
{
  private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore(null);
  private final Context context;
  private FileLogStore currentLog;
  private final FileStore fileStore;
  
  public LogFileManager(Context paramContext, FileStore paramFileStore)
  {
    this(paramContext, paramFileStore, null);
  }
  
  public LogFileManager(Context paramContext, FileStore paramFileStore, String paramString)
  {
    context = paramContext;
    fileStore = paramFileStore;
    currentLog = NOOP_LOG_STORE;
    setCurrentSession(paramString);
  }
  
  private File getLogFileDir()
  {
    File localFile = new File(fileStore.getFilesDir(), "log-files");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  private String getSessionIdForFile(File paramFile)
  {
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf(".temp");
    if (i == -1) {
      return paramFile;
    }
    return paramFile.substring("crashlytics-userlog-".length(), i);
  }
  
  private File getWorkingFileForSession(String paramString)
  {
    paramString = "crashlytics-userlog-" + paramString + ".temp";
    return new File(getLogFileDir(), paramString);
  }
  
  private boolean isLoggingEnabled()
  {
    return CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectCustomLogs", true);
  }
  
  public void clearLog()
  {
    currentLog.deleteLogFile();
  }
  
  public void discardOldLogFiles(Set<String> paramSet)
  {
    File[] arrayOfFile = getLogFileDir().listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (!paramSet.contains(getSessionIdForFile(localFile))) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public ByteString getByteStringForLog()
  {
    return currentLog.getLogAsByteString();
  }
  
  public final void setCurrentSession(String paramString)
  {
    currentLog.closeLogFile();
    currentLog = NOOP_LOG_STORE;
    if (paramString == null) {
      return;
    }
    if (!isLoggingEnabled())
    {
      Fabric.getLogger().d("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
      return;
    }
    setLogFile(getWorkingFileForSession(paramString), 65536);
  }
  
  void setLogFile(File paramFile, int paramInt)
  {
    currentLog = new QueueFileLogStore(paramFile, paramInt);
  }
  
  public void writeToLog(long paramLong, String paramString)
  {
    currentLog.writeToLog(paramLong, paramString);
  }
  
  private static final class NoopLogStore
    implements FileLogStore
  {
    public void closeLogFile() {}
    
    public void deleteLogFile() {}
    
    public ByteString getLogAsByteString()
    {
      return null;
    }
    
    public void writeToLog(long paramLong, String paramString) {}
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.LogFileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */