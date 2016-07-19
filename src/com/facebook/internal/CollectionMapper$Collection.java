package com.facebook.internal;

import java.util.Iterator;

public abstract interface CollectionMapper$Collection<T>
{
  public abstract Object get(T paramT);
  
  public abstract Iterator<T> keyIterator();
  
  public abstract void set(T paramT, Object paramObject, CollectionMapper.OnErrorListener paramOnErrorListener);
}

/* Location:
 * Qualified Name:     com.facebook.internal.CollectionMapper.Collection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */