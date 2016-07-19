package com.squareup.tape;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface FileObjectQueue$Converter<T>
{
  public abstract T from(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void toStream(T paramT, OutputStream paramOutputStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.tape.FileObjectQueue.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */