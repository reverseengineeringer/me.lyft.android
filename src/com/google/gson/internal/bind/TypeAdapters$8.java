package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

final class TypeAdapters$8
  extends TypeAdapter<AtomicInteger>
{
  public AtomicInteger read(JsonReader paramJsonReader)
    throws IOException
  {
    try
    {
      paramJsonReader = new AtomicInteger(paramJsonReader.nextInt());
      return paramJsonReader;
    }
    catch (NumberFormatException paramJsonReader)
    {
      throw new JsonSyntaxException(paramJsonReader);
    }
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicInteger paramAtomicInteger)
    throws IOException
  {
    paramJsonWriter.value(paramAtomicInteger.get());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */