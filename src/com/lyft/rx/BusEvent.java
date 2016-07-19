package com.lyft.rx;

import rx.Observable;

public abstract interface BusEvent<T>
{
  public abstract Observable<T> observe();
  
  public abstract void post(T paramT);
}

/* Location:
 * Qualified Name:     com.lyft.rx.BusEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */