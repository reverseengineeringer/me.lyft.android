package com.lyft.rx;

import java.util.HashMap;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Unit;
import rx.Observable;

public class MessageBus
{
  final HashMap<Class, BusEvent> eventMap = new HashMap();
  
  private <TEvent extends BusEvent<TArg>, TArg> BusEvent<TArg> getEvent(Class<TEvent> paramClass)
  {
    if (eventMap.containsKey(paramClass)) {
      return (BusEvent)eventMap.get(paramClass);
    }
    try
    {
      BusEvent localBusEvent = (BusEvent)paramClass.newInstance();
      eventMap.put(paramClass, localBusEvent);
      return localBusEvent;
    }
    catch (InstantiationException paramClass)
    {
      throw new RuntimeException("Cannot construct event class");
    }
    catch (IllegalAccessException paramClass)
    {
      throw new RuntimeException("Cannot construct event class");
    }
  }
  
  public <TEvent extends BusEvent<TArg>, TArg> Observable<TArg> observe(Class<TEvent> paramClass)
  {
    return getEvent(paramClass).observe();
  }
  
  public <TEvent extends BusEvent<Unit>> void post(Class<TEvent> paramClass)
  {
    Preconditions.checkNotNull(paramClass);
    getEvent(paramClass).post(Unit.create());
  }
  
  public <TEvent extends BusEvent<TArg>, TArg> void post(Class<TEvent> paramClass, TArg paramTArg)
  {
    Preconditions.checkNotNull(paramClass);
    getEvent(paramClass).post(paramTArg);
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.MessageBus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */