package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> vH;
  protected int vI;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    vH = ((DataBuffer)zzab.zzaa(paramDataBuffer));
    vI = -1;
  }
  
  public boolean hasNext()
  {
    return vI < vH.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext())
    {
      i = vI;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    DataBuffer localDataBuffer = vH;
    int i = vI + 1;
    vI = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */