package io.fabric.sdk.android.services.network;

import java.io.InputStream;

public abstract interface PinningInfoProvider
{
  public abstract String getKeyStorePassword();
  
  public abstract InputStream getKeyStoreStream();
  
  public abstract long getPinCreationTimeInMillis();
  
  public abstract String[] getPins();
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.PinningInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */