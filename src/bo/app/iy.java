package bo.app;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

abstract class iy
  implements Iterator<E>
{
  ja<E> a;
  E b;
  private ja<E> d;
  
  /* Error */
  iy(ix paramix)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 20	bo/app/iy:c	Lbo/app/ix;
    //   5: aload_0
    //   6: invokespecial 23	java/lang/Object:<init>	()V
    //   9: aload_1
    //   10: getfield 28	bo/app/ix:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 36	bo/app/iy:a	()Lbo/app/ja;
    //   23: putfield 38	bo/app/iy:a	Lbo/app/ja;
    //   26: aload_0
    //   27: getfield 38	bo/app/iy:a	Lbo/app/ja;
    //   30: ifnonnull +15 -> 45
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 40	bo/app/iy:b	Ljava/lang/Object;
    //   40: aload_2
    //   41: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   44: return
    //   45: aload_0
    //   46: getfield 38	bo/app/iy:a	Lbo/app/ja;
    //   49: getfield 47	bo/app/ja:a	Ljava/lang/Object;
    //   52: astore_1
    //   53: goto -18 -> 35
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	iy
    //   0	63	1	paramix	ix
    //   13	45	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   18	33	56	finally
    //   35	40	56	finally
    //   45	53	56	finally
  }
  
  private void b()
  {
    Object localObject4 = null;
    ReentrantLock localReentrantLock = c.c;
    localReentrantLock.lock();
    label101:
    for (;;)
    {
      try
      {
        Object localObject3 = a;
        ja localja = a((ja)localObject3);
        if (localja == null)
        {
          localObject1 = null;
          a = ((ja)localObject1);
          if (a == null)
          {
            localObject1 = localObject4;
            b = localObject1;
          }
        }
        else
        {
          localObject1 = localja;
          if (a != null) {
            continue;
          }
          if (localja != localObject3) {
            break label101;
          }
          localObject1 = a();
          continue;
        }
        Object localObject1 = a.a;
        continue;
        localObject3 = localja;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  abstract ja<E> a();
  
  abstract ja<E> a(ja<E> paramja);
  
  public boolean hasNext()
  {
    return a != null;
  }
  
  public E next()
  {
    if (a == null) {
      throw new NoSuchElementException();
    }
    d = a;
    Object localObject = b;
    b();
    return (E)localObject;
  }
  
  public void remove()
  {
    ja localja = d;
    if (localja == null) {
      throw new IllegalStateException();
    }
    d = null;
    ReentrantLock localReentrantLock = c.c;
    localReentrantLock.lock();
    try
    {
      if (a != null) {
        c.a(localja);
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.iy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */