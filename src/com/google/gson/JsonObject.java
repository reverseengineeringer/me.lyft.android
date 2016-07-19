package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject
  extends JsonElement
{
  private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
  
  private JsonElement createJsonElement(Object paramObject)
  {
    if (paramObject == null) {
      return JsonNull.INSTANCE;
    }
    return new JsonPrimitive(paramObject);
  }
  
  public void add(String paramString, JsonElement paramJsonElement)
  {
    Object localObject = paramJsonElement;
    if (paramJsonElement == null) {
      localObject = JsonNull.INSTANCE;
    }
    members.put(paramString, localObject);
  }
  
  public void addProperty(String paramString1, String paramString2)
  {
    add(paramString1, createJsonElement(paramString2));
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet()
  {
    return members.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonObject)) && (members.equals(members)));
  }
  
  public JsonElement get(String paramString)
  {
    return (JsonElement)members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString)
  {
    return (JsonPrimitive)members.get(paramString);
  }
  
  public int hashCode()
  {
    return members.hashCode();
  }
  
  public JsonElement remove(String paramString)
  {
    return (JsonElement)members.remove(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.JsonObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */