package io.fabric.sdk.android.services.events;

import java.io.IOException;

public abstract interface FileRollOverManager
{
  public abstract void cancelTimeBasedFileRollOver();
  
  public abstract boolean rollFileOver()
    throws IOException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.events.FileRollOverManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */