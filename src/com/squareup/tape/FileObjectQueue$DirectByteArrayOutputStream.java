package com.squareup.tape;

import java.io.ByteArrayOutputStream;

class FileObjectQueue$DirectByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public byte[] getArray()
  {
    return buf;
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.FileObjectQueue.DirectByteArrayOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */