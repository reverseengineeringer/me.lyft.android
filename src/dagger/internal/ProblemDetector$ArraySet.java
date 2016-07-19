package dagger.internal;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

class ProblemDetector$ArraySet<T>
  extends AbstractSet<T>
{
  private final ArrayList<T> list = new ArrayList();
  
  public boolean add(T paramT)
  {
    list.add(paramT);
    return true;
  }
  
  public Iterator<T> iterator()
  {
    return list.iterator();
  }
  
  public int size()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ProblemDetector.ArraySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */