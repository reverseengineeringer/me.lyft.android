package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters$35$1
  extends TypeAdapter<T1>
{
  TypeAdapters$35$1(TypeAdapters.35 param35, Class paramClass) {}
  
  public T1 read(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader = this$0.val$typeAdapter.read(paramJsonReader);
    if ((paramJsonReader != null) && (!val$requestedType.isInstance(paramJsonReader))) {
      throw new JsonSyntaxException("Expected a " + val$requestedType.getName() + " but was " + paramJsonReader.getClass().getName());
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, T1 paramT1)
    throws IOException
  {
    this$0.val$typeAdapter.write(paramJsonWriter, paramT1);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */