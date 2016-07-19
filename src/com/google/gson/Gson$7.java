package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

final class Gson$7
  extends TypeAdapter<AtomicLongArray>
{
  Gson$7(TypeAdapter paramTypeAdapter) {}
  
  public AtomicLongArray read(JsonReader paramJsonReader)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(Long.valueOf(((Number)val$longAdapter.read(paramJsonReader)).longValue()));
    }
    paramJsonReader.endArray();
    int j = localArrayList.size();
    paramJsonReader = new AtomicLongArray(j);
    int i = 0;
    while (i < j)
    {
      paramJsonReader.set(i, ((Long)localArrayList.get(i)).longValue());
      i += 1;
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicLongArray paramAtomicLongArray)
    throws IOException
  {
    paramJsonWriter.beginArray();
    int i = 0;
    int j = paramAtomicLongArray.length();
    while (i < j)
    {
      val$longAdapter.write(paramJsonWriter, Long.valueOf(paramAtomicLongArray.get(i)));
      i += 1;
    }
    paramJsonWriter.endArray();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */