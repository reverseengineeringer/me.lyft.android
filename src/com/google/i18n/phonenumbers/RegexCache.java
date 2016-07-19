package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class RegexCache
{
  private LRUCache<String, Pattern> cache;
  
  public RegexCache(int paramInt)
  {
    cache = new LRUCache(paramInt);
  }
  
  public Pattern getPatternForRegex(String paramString)
  {
    Pattern localPattern2 = (Pattern)cache.get(paramString);
    Pattern localPattern1 = localPattern2;
    if (localPattern2 == null)
    {
      localPattern1 = Pattern.compile(paramString);
      cache.put(paramString, localPattern1);
    }
    return localPattern1;
  }
  
  private static class LRUCache<K, V>
  {
    private LinkedHashMap<K, V> map;
    private int size;
    
    public LRUCache(int paramInt)
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
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.RegexCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */