package me.lyft.android.infrastructure.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LruMemoryCache<T>
  extends LinkedHashMap<String, T>
  implements ICache<T>
{
  private static final int DEFAULT_INITIAL_SIZE = 16;
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  private final int capacity;
  
  public LruMemoryCache(int paramInt)
  {
    super(16, 0.75F, true);
    capacity = paramInt;
  }
  
  public boolean contains(String paramString)
  {
    return containsKey(paramString);
  }
  
  public T get(String paramString)
  {
    return (T)super.get(paramString);
  }
  
  public T put(String paramString, T paramT)
  {
    return (T)super.put(paramString, paramT);
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, T> paramEntry)
  {
    return size() > capacity;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cache.LruMemoryCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */