package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import io.fabric.sdk.android.services.common.QueueFile.ElementReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class QueueFileLogStore
  implements FileLogStore
{
  private QueueFile logFile;
  private final int maxLogSize;
  private final File workingFile;
  
  public QueueFileLogStore(File paramFile, int paramInt)
  {
    workingFile = paramFile;
    maxLogSize = paramInt;
  }
  
  private void doWriteToLog(long paramLong, String paramString)
  {
    if (logFile == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = "null";
      }
      try
      {
        int i = maxLogSize / 4;
        paramString = str;
        if (str.length() > i) {
          paramString = "..." + str.substring(str.length() - i);
        }
        paramString = paramString.replaceAll("\r", " ").replaceAll("\n", " ");
        paramString = String.format(Locale.US, "%d %s%n", new Object[] { Long.valueOf(paramLong), paramString }).getBytes("UTF-8");
        logFile.add(paramString);
        while ((!logFile.isEmpty()) && (logFile.usedBytes() > maxLogSize)) {
          logFile.remove();
        }
        return;
      }
      catch (IOException paramString)
      {
        Fabric.getLogger().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", paramString);
      }
    }
  }
  
  private void openLogFile()
  {
    if (logFile == null) {}
    try
    {
      logFile = new QueueFile(workingFile);
      return;
    }
    catch (IOException localIOException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Could not open log file: " + workingFile, localIOException);
    }
  }
  
  public void closeLogFile()
  {
    CommonUtils.closeOrLog(logFile, "There was a problem closing the Crashlytics log file.");
    logFile = null;
  }
  
  public void deleteLogFile()
  {
    closeLogFile();
    workingFile.delete();
  }
  
  public ByteString getLogAsByteString()
  {
    if (!workingFile.exists()) {}
    do
    {
      return null;
      openLogFile();
    } while (logFile == null);
    final int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    final byte[] arrayOfByte = new byte[logFile.usedBytes()];
    try
    {
      logFile.forEach(new QueueFile.ElementReader()
      {
        public void read(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          try
          {
            paramAnonymousInputStream.read(arrayOfByte, arrayOfInt[0], paramAnonymousInt);
            int[] arrayOfInt = arrayOfInt;
            arrayOfInt[0] += paramAnonymousInt;
            return;
          }
          finally
          {
            paramAnonymousInputStream.close();
          }
        }
      });
      return ByteString.copyFrom(arrayOfByte, 0, arrayOfInt[0]);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Fabric.getLogger().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", localIOException);
      }
    }
  }
  
  public void writeToLog(long paramLong, String paramString)
  {
    openLogFile();
    doWriteToLog(paramLong, paramString);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.QueueFileLogStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */