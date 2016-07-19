package io.fabric.sdk.android.services.cache;

import android.content.Context;

public class MemoryValueCache<T>
  extends AbstractValueCache<T>
{
  private T value;
  
  public MemoryValueCache()
  {
    this(null);
  }
  
  public MemoryValueCache(ValueCache<T> paramValueCache)
  {
    super(paramValueCache);
  }
  
  protected void cacheValue(Context paramContext, T paramT)
  {
    value = paramT;
  }
  
  protected T getCached(Context paramContext)
  {
    return (T)value;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.cache.MemoryValueCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */