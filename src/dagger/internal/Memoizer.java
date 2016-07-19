package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class Memoizer<K, V>
{
  private final Map<K, V> map = new LinkedHashMap();
  private final Lock readLock;
  private final Lock writeLock;
  
  public Memoizer()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    readLock = localReentrantReadWriteLock.readLock();
    writeLock = localReentrantReadWriteLock.writeLock();
  }
  
  protected abstract V create(K paramK);
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    readLock.lock();
    Object localObject;
    try
    {
      localObject = map.get(paramK);
      if (localObject != null)
      {
        readLock.unlock();
        return (V)localObject;
      }
      readLock.unlock();
      localObject = create(paramK);
      if (localObject == null) {
        throw new NullPointerException("create returned null");
      }
    }
    finally
    {
      readLock.unlock();
    }
    writeLock.lock();
    try
    {
      map.put(paramK, localObject);
      return (V)localObject;
    }
    finally
    {
      writeLock.unlock();
    }
  }
  
  public final String toString()
  {
    readLock.lock();
    try
    {
      String str = map.toString();
      return str;
    }
    finally
    {
      readLock.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Memoizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */