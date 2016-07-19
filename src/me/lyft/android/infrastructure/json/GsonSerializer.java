package me.lyft.android.infrastructure.json;

import com.google.gson.Gson;
import java.io.Reader;
import java.lang.reflect.Type;

public class GsonSerializer
  implements IJsonSerializer
{
  final Gson gson;
  
  public GsonSerializer(Gson paramGson)
  {
    gson = paramGson;
  }
  
  public <T> T fromJson(Reader paramReader, Class<T> paramClass)
  {
    return (T)gson.fromJson(paramReader, paramClass);
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    return (T)gson.fromJson(paramString, paramClass);
  }
  
  public <T> T fromJson(String paramString, Type paramType)
  {
    return (T)gson.fromJson(paramString, paramType);
  }
  
  public <T> String toJson(T paramT)
  {
    return gson.toJson(paramT);
  }
  
  public <T> String toJson(T paramT, Class<T> paramClass)
  {
    return gson.toJson(paramT, paramClass);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.json.GsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */