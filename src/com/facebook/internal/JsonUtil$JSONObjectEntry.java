package com.facebook.internal;

import android.annotation.SuppressLint;
import java.util.Map.Entry;

final class JsonUtil$JSONObjectEntry
  implements Map.Entry<String, Object>
{
  private final String key;
  private final Object value;
  
  JsonUtil$JSONObjectEntry(String paramString, Object paramObject)
  {
    key = paramString;
    value = paramObject;
  }
  
  @SuppressLint({"FieldGetter"})
  public String getKey()
  {
    return key;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("JSONObjectEntry is immutable");
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.JsonUtil.JSONObjectEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */