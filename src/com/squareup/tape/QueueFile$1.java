package com.squareup.tape;

import java.io.IOException;
import java.io.InputStream;

class QueueFile$1
  implements QueueFile.ElementReader
{
  boolean first = true;
  
  QueueFile$1(QueueFile paramQueueFile, StringBuilder paramStringBuilder) {}
  
  public void read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (first) {
      first = false;
    }
    for (;;)
    {
      val$builder.append(paramInt);
      return;
      val$builder.append(", ");
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.QueueFile.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */