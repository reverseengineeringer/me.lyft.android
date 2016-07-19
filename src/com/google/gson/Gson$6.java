package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

final class Gson$6
  extends TypeAdapter<AtomicLong>
{
  Gson$6(TypeAdapter paramTypeAdapter) {}
  
  public AtomicLong read(JsonReader paramJsonReader)
    throws IOException
  {
    return new AtomicLong(((Number)val$longAdapter.read(paramJsonReader)).longValue());
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicLong paramAtomicLong)
    throws IOException
  {
    val$longAdapter.write(paramJsonWriter, Long.valueOf(paramAtomicLong.get()));
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */