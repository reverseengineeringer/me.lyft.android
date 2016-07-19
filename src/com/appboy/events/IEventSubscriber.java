package com.appboy.events;

public abstract interface IEventSubscriber<T>
{
  public abstract void trigger(T paramT);
}

/* Location:
 * Qualified Name:     com.appboy.events.IEventSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */