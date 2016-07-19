package me.lyft.android.common;

import java.util.Iterator;

class Iterables$Iterators
{
  static int advance(Iterator<?> paramIterator, int paramInt)
  {
    Preconditions.checkNotNull(paramIterator);
    if (paramInt >= 0) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "numberToAdvance must be nonnegative");
      i = 0;
      while ((i < paramInt) && (paramIterator.hasNext()))
      {
        paramIterator.next();
        i += 1;
      }
    }
    return i;
  }
  
  static void checkNonnegative(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("position (" + paramInt + ") must not be negative");
    }
  }
  
  static <T> T get(Iterator<T> paramIterator, int paramInt)
  {
    checkNonnegative(paramInt);
    int i = advance(paramIterator, paramInt);
    if (!paramIterator.hasNext()) {
      throw new IndexOutOfBoundsException("position (" + paramInt + ") must be less than the number of elements that remained (" + i + ")");
    }
    return (T)paramIterator.next();
  }
  
  static <T> T getNext(Iterator<? extends T> paramIterator, T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = paramIterator.next();
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Iterables.Iterators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */