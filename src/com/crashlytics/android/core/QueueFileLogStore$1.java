package com.crashlytics.android.core;

import io.fabric.sdk.android.services.common.QueueFile.ElementReader;
import java.io.IOException;
import java.io.InputStream;

class QueueFileLogStore$1
  implements QueueFile.ElementReader
{
  QueueFileLogStore$1(QueueFileLogStore paramQueueFileLogStore, byte[] paramArrayOfByte, int[] paramArrayOfInt) {}
  
  public void read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    try
    {
      paramInputStream.read(val$logBytes, val$offsetHolder[0], paramInt);
      int[] arrayOfInt = val$offsetHolder;
      arrayOfInt[0] += paramInt;
      return;
    }
    finally
    {
      paramInputStream.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.QueueFileLogStore.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */