package com.squareup.tape;

import java.io.File;
import java.io.IOException;

public class FileException
  extends RuntimeException
{
  private final File file;
  
  public FileException(String paramString, IOException paramIOException, File paramFile)
  {
    super(paramString, paramIOException);
    file = paramFile;
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.FileException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */