package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$31
  implements TypeAdapterFactory
{
  TypeAdapters$31(TypeToken paramTypeToken, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.equals(val$type)) {
      return val$typeAdapter;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.31
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */