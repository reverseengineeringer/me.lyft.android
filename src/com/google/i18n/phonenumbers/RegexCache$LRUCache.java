package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class RegexCache$LRUCache<K, V>
{
  private LinkedHashMap<K, V> map;
  private int size;
  
  public RegexCache$LRUCache(int paramInt)
  {
    size = paramInt;
    map = new LinkedHashMap(paramInt * 4 / 3 + 1, 0.75F, true)
    {
      protected boolean removeEldestEntry(Map.Entry<K, V> paramAnonymousEntry)
      {
        return size() > size;
      }
    };
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = map.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void put(K paramK, V paramV)
  {
    try
    {
      map.put(paramK, paramV);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.RegexCache.LRUCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */