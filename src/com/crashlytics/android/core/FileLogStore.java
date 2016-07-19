package com.crashlytics.android.core;

abstract interface FileLogStore
{
  public abstract void closeLogFile();
  
  public abstract void deleteLogFile();
  
  public abstract ByteString getLogAsByteString();
  
  public abstract void writeToLog(long paramLong, String paramString);
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.FileLogStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */