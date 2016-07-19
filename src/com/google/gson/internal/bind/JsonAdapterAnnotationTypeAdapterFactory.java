package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  
  public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor)
  {
    constructorConstructor = paramConstructorConstructor;
  }
  
  static TypeAdapter<?> getTypeAdapter(ConstructorConstructor paramConstructorConstructor, Gson paramGson, TypeToken<?> paramTypeToken, JsonAdapter paramJsonAdapter)
  {
    paramJsonAdapter = paramJsonAdapter.value();
    if (TypeAdapter.class.isAssignableFrom(paramJsonAdapter)) {}
    for (paramConstructorConstructor = (TypeAdapter)paramConstructorConstructor.get(TypeToken.get(paramJsonAdapter)).construct();; paramConstructorConstructor = ((TypeAdapterFactory)paramConstructorConstructor.get(TypeToken.get(paramJsonAdapter)).construct()).create(paramGson, paramTypeToken))
    {
      paramGson = paramConstructorConstructor;
      if (paramConstructorConstructor != null) {
        paramGson = paramConstructorConstructor.nullSafe();
      }
      return paramGson;
      if (!TypeAdapterFactory.class.isAssignableFrom(paramJsonAdapter)) {
        break;
      }
    }
    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    JsonAdapter localJsonAdapter = (JsonAdapter)paramTypeToken.getRawType().getAnnotation(JsonAdapter.class);
    if (localJsonAdapter == null) {
      return null;
    }
    return getTypeAdapter(constructorConstructor, paramGson, paramTypeToken, localJsonAdapter);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */