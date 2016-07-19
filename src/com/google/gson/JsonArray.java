package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray
  extends JsonElement
  implements Iterable<JsonElement>
{
  private final List<JsonElement> elements = new ArrayList();
  
  public void add(JsonElement paramJsonElement)
  {
    Object localObject = paramJsonElement;
    if (paramJsonElement == null) {
      localObject = JsonNull.INSTANCE;
    }
    elements.add(localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonArray)) && (elements.equals(elements)));
  }
  
  public boolean getAsBoolean()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsBoolean();
    }
    throw new IllegalStateException();
  }
  
  public double getAsDouble()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsDouble();
    }
    throw new IllegalStateException();
  }
  
  public int getAsInt()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsInt();
    }
    throw new IllegalStateException();
  }
  
  public long getAsLong()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsLong();
    }
    throw new IllegalStateException();
  }
  
  public Number getAsNumber()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsNumber();
    }
    throw new IllegalStateException();
  }
  
  public String getAsString()
  {
    if (elements.size() == 1) {
      return ((JsonElement)elements.get(0)).getAsString();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return elements.hashCode();
  }
  
  public Iterator<JsonElement> iterator()
  {
    return elements.iterator();
  }
  
  public int size()
  {
    return elements.size();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.JsonArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */