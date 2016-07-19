package me.lyft.android.analytics.core.events;

import java.util.Map;
import me.lyft.android.analytics.core.definitions.Subevent;
import me.lyft.android.analytics.definitions.MapParameterStore;
import me.lyft.android.analytics.definitions.Parameter;

public abstract class CoreEvent
  implements IEvent
{
  protected final MapParameterStore parameterStore = new MapParameterStore();
  protected IEvent.Priority priority = IEvent.Priority.NORMAL;
  
  public abstract boolean contains(Subevent paramSubevent);
  
  public abstract int getEventVersion();
  
  public Map<String, Object> getParameters()
  {
    return parameterStore.getMap();
  }
  
  public IEvent.Priority getPriority()
  {
    return priority;
  }
  
  public Double getSampleRate()
  {
    return parameterStore.getDouble(Parameter.SAMPLE_RATE);
  }
  
  public CoreEvent setParameter(String paramString)
  {
    parameterStore.put(Parameter.PARAMETER, paramString);
    return this;
  }
  
  public CoreEvent setPriority(IEvent.Priority paramPriority)
  {
    priority = paramPriority;
    return this;
  }
  
  public CoreEvent setSampleRate(double paramDouble)
  {
    parameterStore.put(Parameter.SAMPLE_RATE, Double.valueOf(paramDouble));
    return this;
  }
  
  public CoreEvent setTag(String paramString)
  {
    parameterStore.put(Parameter.TAG, paramString);
    return this;
  }
  
  public CoreEvent setValue(long paramLong)
  {
    parameterStore.put(Parameter.VALUE, Long.valueOf(paramLong));
    return this;
  }
  
  public CoreEvent setValue(boolean paramBoolean)
  {
    MapParameterStore localMapParameterStore = parameterStore;
    Parameter localParameter = Parameter.VALUE;
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localMapParameterStore.put(localParameter, Long.valueOf(l));
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.events.CoreEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */