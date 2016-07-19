package com.squareup.tape;

import java.io.IOException;
import java.io.InputStream;

public abstract interface QueueFile$ElementReader
{
  public abstract void read(InputStream paramInputStream, int paramInt)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.tape.QueueFile.ElementReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */