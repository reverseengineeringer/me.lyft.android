package dagger.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E>
  extends AbstractCollection<E>
  implements Serializable, Cloneable, Queue<E>
{
  private static final int MIN_INITIAL_CAPACITY = 8;
  private static final long serialVersionUID = 2340985798034038923L;
  private transient Object[] elements;
  private transient int head;
  private transient int tail;
  
  public ArrayQueue()
  {
    elements = new Object[16];
  }
  
  public ArrayQueue(int paramInt)
  {
    allocateElements(paramInt);
  }
  
  public ArrayQueue(Collection<? extends E> paramCollection)
  {
    allocateElements(paramCollection.size());
    addAll(paramCollection);
  }
  
  private void allocateElements(int paramInt)
  {
    int i = 8;
    if (paramInt >= 8)
    {
      paramInt |= paramInt >>> 1;
      paramInt |= paramInt >>> 2;
      paramInt |= paramInt >>> 4;
      paramInt |= paramInt >>> 8;
      paramInt = (paramInt | paramInt >>> 16) + 1;
      i = paramInt;
      if (paramInt < 0) {
        i = paramInt >>> 1;
      }
    }
    elements = new Object[i];
  }
  
  private boolean delete(int paramInt)
  {
    Object[] arrayOfObject = elements;
    int i = arrayOfObject.length - 1;
    int j = head;
    int k = tail;
    int m = paramInt - j & i;
    int n = k - paramInt & i;
    if (m >= (k - j & i)) {
      throw new ConcurrentModificationException();
    }
    if (m < n)
    {
      if (j <= paramInt) {
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      }
      for (;;)
      {
        arrayOfObject[j] = null;
        head = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (tail = (k - 1);; tail = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  private void doubleCapacity()
  {
    int i = head;
    int j = elements.length;
    int k = j - i;
    int m = j << 1;
    if (m < 0) {
      throw new IllegalStateException("Sorry, queue too big");
    }
    Object[] arrayOfObject = new Object[m];
    System.arraycopy(elements, i, arrayOfObject, 0, k);
    System.arraycopy(elements, 0, arrayOfObject, k, i);
    elements = arrayOfObject;
    head = 0;
    tail = j;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int j = paramObjectInputStream.readInt();
    allocateElements(j);
    head = 0;
    tail = j;
    int i = 0;
    while (i < j)
    {
      elements[i] = paramObjectInputStream.readObject();
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    int j = elements.length;
    for (int i = head; i != tail; i = i + 1 & j - 1) {
      paramObjectOutputStream.writeObject(elements[i]);
    }
  }
  
  public boolean add(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("e == null");
    }
    elements[tail] = paramE;
    int i = tail + 1 & elements.length - 1;
    tail = i;
    if (i == head) {
      doubleCapacity();
    }
    return true;
  }
  
  public void clear()
  {
    int i = head;
    int k = tail;
    if (i != k)
    {
      tail = 0;
      head = 0;
      int m = elements.length;
      int j;
      do
      {
        elements[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public ArrayQueue<E> clone()
  {
    try
    {
      ArrayQueue localArrayQueue = (ArrayQueue)super.clone();
      Object[] arrayOfObject = (Object[])Array.newInstance(elements.getClass().getComponentType(), elements.length);
      System.arraycopy(elements, 0, arrayOfObject, 0, elements.length);
      elements = arrayOfObject;
      return localArrayQueue;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = elements.length;
    for (int i = head;; i = i + 1 & j - 1)
    {
      Object localObject = elements[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
  }
  
  public E element()
  {
    Object localObject = elements[head];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public boolean isEmpty()
  {
    return head == tail;
  }
  
  public Iterator<E> iterator()
  {
    return new QueueIterator(null);
  }
  
  public boolean offer(E paramE)
  {
    return add(paramE);
  }
  
  public E peek()
  {
    return (E)elements[head];
  }
  
  public E poll()
  {
    int i = head;
    Object localObject = elements[i];
    if (localObject == null) {
      return null;
    }
    elements[i] = null;
    head = (i + 1 & elements.length - 1);
    return (E)localObject;
  }
  
  public E remove()
  {
    Object localObject = poll();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public boolean remove(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = elements.length;
    for (int i = head;; i = i + 1 & j - 1)
    {
      Object localObject = elements[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        delete(i);
        return true;
      }
    }
  }
  
  public int size()
  {
    return tail - head & elements.length - 1;
  }
  
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    if (head < tail) {
      System.arraycopy(elements, head, localObject, 0, size());
    }
    for (;;)
    {
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return (T[])localObject;
      if (head > tail)
      {
        int j = elements.length - head;
        System.arraycopy(elements, head, localObject, 0, j);
        System.arraycopy(elements, 0, localObject, j, tail);
      }
    }
  }
  
  private class QueueIterator
    implements Iterator<E>
  {
    private int cursor = head;
    private int fence = tail;
    private int lastRet = -1;
    
    private QueueIterator() {}
    
    public boolean hasNext()
    {
      return cursor != fence;
    }
    
    public E next()
    {
      if (cursor == fence) {
        throw new NoSuchElementException();
      }
      Object localObject = elements[cursor];
      if ((tail != fence) || (localObject == null)) {
        throw new ConcurrentModificationException();
      }
      lastRet = cursor;
      cursor = (cursor + 1 & elements.length - 1);
      return (E)localObject;
    }
    
    public void remove()
    {
      if (lastRet < 0) {
        throw new IllegalStateException();
      }
      if (ArrayQueue.this.delete(lastRet))
      {
        cursor = (cursor - 1 & elements.length - 1);
        fence = tail;
      }
      lastRet = -1;
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ArrayQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */