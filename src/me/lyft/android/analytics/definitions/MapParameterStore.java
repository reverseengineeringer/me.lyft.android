package me.lyft.android.analytics.definitions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapParameterStore
  extends ParameterStore
{
  final Map<String, Object> map = new HashMap();
  
  public Map<String, Object> getMap()
  {
    return Collections.unmodifiableMap(map);
  }
  
  protected Object getParameterInternal(Parameter paramParameter)
  {
    return map.get(paramParameter.toString());
  }
  
  public void overrideParameters(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramMap.get(str);
        putParameterInternal(Parameter.fromString(str), localObject);
      }
    }
  }
  
  protected void putParameterInternal(Parameter paramParameter, Object paramObject)
  {
    if (paramObject != null)
    {
      paramParameter = paramParameter.toString();
      map.put(paramParameter, paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.definitions.MapParameterStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */