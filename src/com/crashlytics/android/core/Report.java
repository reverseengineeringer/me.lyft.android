package com.crashlytics.android.core;

import java.io.File;
import java.util.Map;

abstract interface Report
{
  public abstract Map<String, String> getCustomHeaders();
  
  public abstract File getFile();
  
  public abstract String getFileName();
  
  public abstract String getIdentifier();
  
  public abstract boolean remove();
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.Report
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */