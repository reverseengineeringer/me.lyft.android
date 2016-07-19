package com.crashlytics.android.core;

import java.io.InputStream;

public abstract interface PinningInfoProvider
{
  public abstract String getKeyStorePassword();
  
  public abstract InputStream getKeyStoreStream();
  
  public abstract String[] getPins();
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.PinningInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */