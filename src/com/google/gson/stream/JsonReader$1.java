package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.IOException;

final class JsonReader$1
  extends JsonReaderInternalAccess
{
  public void promoteNameToValue(JsonReader paramJsonReader)
    throws IOException
  {
    if ((paramJsonReader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)paramJsonReader).promoteNameToValue();
      return;
    }
    int j = peeked;
    int i = j;
    if (j == 0) {
      i = paramJsonReader.doPeek();
    }
    if (i == 13)
    {
      peeked = 9;
      return;
    }
    if (i == 12)
    {
      peeked = 8;
      return;
    }
    if (i == 14)
    {
      peeked = 10;
      return;
    }
    throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + " " + " at line " + paramJsonReader.getLineNumber() + " column " + paramJsonReader.getColumnNumber() + " path " + paramJsonReader.getPath());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.stream.JsonReader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */