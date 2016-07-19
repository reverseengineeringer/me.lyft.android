package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>>
  extends TypeAdapter<T>
{
  private final Map<T, String> constantToName = new HashMap();
  private final Map<String, T> nameToConstant = new HashMap();
  
  public TypeAdapters$EnumTypeAdapter(Class<T> paramClass)
  {
    try
    {
      Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
      int k = arrayOfEnum.length;
      int i = 0;
      while (i < k)
      {
        Enum localEnum = arrayOfEnum[i];
        Object localObject1 = localEnum.name();
        Object localObject2 = (SerializedName)paramClass.getField((String)localObject1).getAnnotation(SerializedName.class);
        if (localObject2 != null)
        {
          String str = ((SerializedName)localObject2).value();
          localObject2 = ((SerializedName)localObject2).alternate();
          int m = localObject2.length;
          int j = 0;
          for (;;)
          {
            localObject1 = str;
            if (j >= m) {
              break;
            }
            localObject1 = localObject2[j];
            nameToConstant.put(localObject1, localEnum);
            j += 1;
          }
        }
        nameToConstant.put(localObject1, localEnum);
        constantToName.put(localEnum, localObject1);
        i += 1;
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new AssertionError("Missing field in " + paramClass.getName(), localNoSuchFieldException);
    }
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return (Enum)nameToConstant.get(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (paramT == null) {}
    for (paramT = null;; paramT = (String)constantToName.get(paramT))
    {
      paramJsonWriter.value(paramT);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */