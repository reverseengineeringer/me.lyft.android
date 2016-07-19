package me.lyft.android.infrastructure.json;

import java.io.Reader;
import java.lang.reflect.Type;

public abstract interface IJsonSerializer
{
  public abstract <T> T fromJson(Reader paramReader, Class<T> paramClass);
  
  public abstract <T> T fromJson(String paramString, Class<T> paramClass);
  
  public abstract <T> T fromJson(String paramString, Type paramType);
  
  public abstract <T> String toJson(T paramT);
  
  public abstract <T> String toJson(T paramT, Class<T> paramClass);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.json.IJsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */