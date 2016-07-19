package bo.app;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ix<E>
  extends AbstractQueue<E>
  implements iu<E>, Serializable
{
  transient ja<E> a;
  transient ja<E> b;
  final ReentrantLock c = new ReentrantLock();
  private transient int d;
  private final int e = Integer.MAX_VALUE;
  private final Condition f = c.newCondition();
  private final Condition g = c.newCondition();
  
  public ix()
  {
    this((byte)0);
  }
  
  private ix(byte paramByte) {}
  
  private E a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = b();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = f.awaitNanos(paramLong);
      }
      return (E)localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  private boolean a(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new ja(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = b(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = g.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  private E b()
  {
    ja localja1 = a;
    if (localja1 == null) {
      return null;
    }
    ja localja2 = c;
    Object localObject = a;
    a = null;
    c = localja1;
    a = localja2;
    if (localja2 == null) {
      b = null;
    }
    for (;;)
    {
      d -= 1;
      g.signal();
      return (E)localObject;
      b = null;
    }
  }
  
  private boolean b(ja<E> paramja)
  {
    if (d >= e) {
      return false;
    }
    ja localja = b;
    b = localja;
    b = paramja;
    if (a == null) {
      a = paramja;
    }
    for (;;)
    {
      d += 1;
      f.signal();
      return true;
      c = paramja;
    }
  }
  
  private boolean b(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    ja localja = new ja(paramE);
    paramE = c;
    paramE.lock();
    try
    {
      boolean bool = b(localja);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  private E c()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = b();
      return (E)localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private boolean c(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      for (ja localja = a; localja != null; localja = c) {
        if (paramObject.equals(a))
        {
          a(localja);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private E d()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = b();
        if (localObject != null) {
          break;
        }
        f.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  /* Error */
  private E e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	bo/app/ix:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 83	bo/app/ix:a	Lbo/app/ja;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 83	bo/app/ix:a	Lbo/app/ja;
    //   30: getfield 88	bo/app/ja:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ix
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public final E a()
  {
    Object localObject = c();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  final void a(ja<E> paramja)
  {
    ja localja = b;
    Object localObject = c;
    if (localja == null) {
      b();
    }
    do
    {
      return;
      if (localObject != null) {
        break;
      }
      paramja = b;
    } while (paramja == null);
    localja = b;
    localObject = a;
    a = null;
    b = paramja;
    b = localja;
    if (localja == null) {
      a = null;
    }
    for (;;)
    {
      d -= 1;
      g.signal();
      return;
      c = null;
    }
    c = ((ja)localObject);
    b = localja;
    a = null;
    d -= 1;
    g.signal();
  }
  
  /* Error */
  public final boolean a(E paramE)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 71	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 72	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 74	bo/app/ja
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 77	bo/app/ja:<init>	(Ljava/lang/Object;)V
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 34	bo/app/ix:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   31: aload_0
    //   32: getfield 92	bo/app/ix:d	I
    //   35: istore_2
    //   36: aload_0
    //   37: getfield 45	bo/app/ix:e	I
    //   40: istore_3
    //   41: iload_2
    //   42: iload_3
    //   43: if_icmplt +13 -> 56
    //   46: iconst_0
    //   47: istore 4
    //   49: aload_1
    //   50: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: iload 4
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 83	bo/app/ix:a	Lbo/app/ja;
    //   60: astore 6
    //   62: aload 5
    //   64: aload 6
    //   66: putfield 85	bo/app/ja:c	Lbo/app/ja;
    //   69: aload_0
    //   70: aload 5
    //   72: putfield 83	bo/app/ix:a	Lbo/app/ja;
    //   75: aload_0
    //   76: getfield 90	bo/app/ix:b	Lbo/app/ja;
    //   79: ifnonnull +34 -> 113
    //   82: aload_0
    //   83: aload 5
    //   85: putfield 90	bo/app/ix:b	Lbo/app/ja;
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 92	bo/app/ix:d	I
    //   93: iconst_1
    //   94: iadd
    //   95: putfield 92	bo/app/ix:d	I
    //   98: aload_0
    //   99: getfield 40	bo/app/ix:f	Ljava/util/concurrent/locks/Condition;
    //   102: invokeinterface 95 1 0
    //   107: iconst_1
    //   108: istore 4
    //   110: goto -61 -> 49
    //   113: aload 6
    //   115: aload 5
    //   117: putfield 96	bo/app/ja:b	Lbo/app/ja;
    //   120: goto -32 -> 88
    //   123: astore 5
    //   125: aload_1
    //   126: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   129: aload 5
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ix
    //   0	132	1	paramE	E
    //   35	9	2	i	int
    //   40	4	3	j	int
    //   47	62	4	bool	boolean
    //   20	96	5	localja1	ja
    //   123	7	5	localObject	Object
    //   60	54	6	localja2	ja
    // Exception table:
    //   from	to	target	type
    //   31	41	123	finally
    //   56	88	123	finally
    //   88	107	123	finally
    //   113	120	123	finally
  }
  
  public boolean add(E paramE)
  {
    if (!b(paramE)) {
      throw new IllegalStateException("Deque full");
    }
    return true;
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      ja localja;
      for (Object localObject1 = a; localObject1 != null; localObject1 = localja)
      {
        a = null;
        localja = c;
        b = null;
        c = null;
      }
      b = null;
      a = null;
      d = 0;
      g.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      for (ja localja = a; localja != null; localja = c)
      {
        boolean bool = paramObject.equals(a);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, Integer.MAX_VALUE);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, d);
      paramInt = 0;
      while (paramInt < i)
      {
        paramCollection.add(a.a);
        b();
        paramInt += 1;
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E element()
  {
    Object localObject = e();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public Iterator<E> iterator()
  {
    return new iz(this, (byte)0);
  }
  
  public boolean offer(E paramE)
  {
    return b(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramE, paramLong, paramTimeUnit);
  }
  
  public E peek()
  {
    return (E)e();
  }
  
  public E poll()
  {
    return (E)c();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return (E)a(paramLong, paramTimeUnit);
  }
  
  /* Error */
  public void put(E paramE)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 71	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 72	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 74	bo/app/ja
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 77	bo/app/ja:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 34	bo/app/ix:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 80	bo/app/ix:b	(Lbo/app/ja;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 42	bo/app/ix:g	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 114 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ix
    //   0	62	1	paramE	E
    //   20	12	2	localja	ja
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      int i = e;
      int j = d;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E remove()
  {
    return (E)a();
  }
  
  public boolean remove(Object paramObject)
  {
    return c(paramObject);
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      int i = d;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E take()
  {
    return (E)d();
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[d];
      int i = 0;
      ja localja = a;
      while (localja != null)
      {
        arrayOfObject[i] = a;
        localja = c;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = c;
    localReentrantLock.lock();
    Object localObject = paramArrayOfT;
    try
    {
      if (paramArrayOfT.length < d) {
        localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), d);
      }
      int i = 0;
      paramArrayOfT = a;
      while (paramArrayOfT != null)
      {
        localObject[i] = a;
        paramArrayOfT = c;
        i += 1;
      }
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return (T[])localObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	bo/app/ix:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 83	bo/app/ix:a	Lbo/app/ja;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +11 -> 28
    //   20: aload 4
    //   22: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc -45
    //   27: areturn
    //   28: new 213	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: bipush 91
    //   41: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_1
    //   46: getfield 88	bo/app/ja:a	Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: aload_0
    //   54: if_acmpne +6 -> 60
    //   57: ldc -36
    //   59: astore_2
    //   60: aload 5
    //   62: aload_2
    //   63: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: getfield 85	bo/app/ja:c	Lbo/app/ja;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnonnull +21 -> 94
    //   76: aload 5
    //   78: bipush 93
    //   80: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   83: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   92: aload_1
    //   93: areturn
    //   94: aload 5
    //   96: bipush 44
    //   98: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   101: bipush 32
    //   103: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: goto -62 -> 45
    //   110: astore_1
    //   111: aload 4
    //   113: invokevirtual 61	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	ix
    //   15	78	1	localObject1	Object
    //   110	7	1	localObject2	Object
    //   51	12	2	localObject3	Object
    //   49	4	3	localObject4	Object
    //   4	108	4	localReentrantLock	ReentrantLock
    //   35	60	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	110	finally
    //   28	45	110	finally
    //   45	50	110	finally
    //   60	72	110	finally
    //   76	87	110	finally
    //   94	107	110	finally
  }
}

/* Location:
 * Qualified Name:     bo.app.ix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */