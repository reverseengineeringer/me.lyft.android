package me.lyft.android.analytics.core.events;

import java.util.HashSet;
import java.util.Set;
import me.lyft.android.analytics.core.definitions.EventName;
import me.lyft.android.analytics.core.definitions.Subevent;
import me.lyft.android.analytics.definitions.MapParameterStore;
import me.lyft.android.analytics.definitions.Parameter;
import me.lyft.android.common.Strings;

public class ExperimentEvent
  extends CoreEvent
{
  private static final int EVENT_VERSION = 1;
  private static final Set<Subevent> SUBEVENTS = new HashSet(6) {};
  
  public ExperimentEvent(Type paramType, String paramString1, String paramString2)
  {
    parameterStore.put(Parameter.TYPE, paramType.toString());
    parameterStore.put(Parameter.EXPERIMENT, paramString1);
    parameterStore.put(Parameter.VARIANT, paramString2);
    parameterStore.put(Parameter.SOURCE, "client");
  }
  
  public boolean contains(Subevent paramSubevent)
  {
    return SUBEVENTS.contains(paramSubevent);
  }
  
  public int getEventVersion()
  {
    return 1;
  }
  
  public String getName()
  {
    return EventName.EXPERIMENTATION.toString();
  }
  
  public static enum Type
  {
    ASSIGNMENT,  EXPOSURE;
    
    private Type() {}
    
    public static Type fromString(String paramString)
    {
      return valueOf(Strings.toUpperCaseEnglish(paramString));
    }
    
    public String toString()
    {
      return Strings.toLowerCaseEnglish(name());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.events.ExperimentEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */