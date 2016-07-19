package me.lyft.android.infrastructure.cache;

public abstract interface ICache<T>
{
  public abstract boolean contains(String paramString);
  
  public abstract T get(String paramString);
  
  public abstract T put(String paramString, T paramT);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cache.ICache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */