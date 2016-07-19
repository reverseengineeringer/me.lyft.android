package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$35
  implements TypeAdapterFactory
{
  TypeAdapters$35(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T2> TypeAdapter<T2> create(final Gson paramGson, TypeToken<T2> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if (!val$clazz.isAssignableFrom(paramGson)) {
      return null;
    }
    new TypeAdapter()
    {
      public T1 read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        paramAnonymousJsonReader = val$typeAdapter.read(paramAnonymousJsonReader);
        if ((paramAnonymousJsonReader != null) && (!paramGson.isInstance(paramAnonymousJsonReader))) {
          throw new JsonSyntaxException("Expected a " + paramGson.getName() + " but was " + paramAnonymousJsonReader.getClass().getName());
        }
        return paramAnonymousJsonReader;
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, T1 paramAnonymousT1)
        throws IOException
      {
        val$typeAdapter.write(paramAnonymousJsonWriter, paramAnonymousT1);
      }
    };
  }
  
  public String toString()
  {
    return "Factory[typeHierarchy=" + val$clazz.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */