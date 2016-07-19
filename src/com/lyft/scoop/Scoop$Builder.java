package com.lyft.scoop;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scoop$Builder
{
  private String name;
  private final Scoop parent;
  private final Map<String, Object> services = new LinkedHashMap();
  
  public Scoop$Builder(String paramString)
  {
    name = paramString;
    parent = null;
  }
  
  public Scoop$Builder(String paramString, Scoop paramScoop)
  {
    name = paramString;
    parent = paramScoop;
  }
  
  public Scoop build()
  {
    return new Scoop(name, parent, services, null);
  }
  
  public Builder service(String paramString, Object paramObject)
  {
    services.put(paramString, paramObject);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Scoop.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */