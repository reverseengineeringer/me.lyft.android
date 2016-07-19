package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

final class TypeAdapters$9
  extends TypeAdapter<AtomicBoolean>
{
  public AtomicBoolean read(JsonReader paramJsonReader)
    throws IOException
  {
    return new AtomicBoolean(paramJsonReader.nextBoolean());
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicBoolean paramAtomicBoolean)
    throws IOException
  {
    paramJsonWriter.value(paramAtomicBoolean.get());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */