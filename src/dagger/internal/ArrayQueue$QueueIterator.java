package dagger.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayQueue$QueueIterator
  implements Iterator<E>
{
  private int cursor = ArrayQueue.access$100(this$0);
  private int fence = ArrayQueue.access$200(this$0);
  private int lastRet = -1;
  
  private ArrayQueue$QueueIterator(ArrayQueue paramArrayQueue) {}
  
  public boolean hasNext()
  {
    return cursor != fence;
  }
  
  public E next()
  {
    if (cursor == fence) {
      throw new NoSuchElementException();
    }
    Object localObject = ArrayQueue.access$300(this$0)[cursor];
    if ((ArrayQueue.access$200(this$0) != fence) || (localObject == null)) {
      throw new ConcurrentModificationException();
    }
    lastRet = cursor;
    cursor = (cursor + 1 & ArrayQueue.access$300(this$0).length - 1);
    return (E)localObject;
  }
  
  public void remove()
  {
    if (lastRet < 0) {
      throw new IllegalStateException();
    }
    if (ArrayQueue.access$400(this$0, lastRet))
    {
      cursor = (cursor - 1 & ArrayQueue.access$300(this$0).length - 1);
      fence = ArrayQueue.access$200(this$0);
    }
    lastRet = -1;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ArrayQueue.QueueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */