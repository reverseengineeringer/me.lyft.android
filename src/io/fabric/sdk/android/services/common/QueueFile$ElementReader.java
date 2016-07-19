package io.fabric.sdk.android.services.common;

import java.io.IOException;
import java.io.InputStream;

public abstract interface QueueFile$ElementReader
{
  public abstract void read(InputStream paramInputStream, int paramInt)
    throws IOException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.QueueFile.ElementReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */