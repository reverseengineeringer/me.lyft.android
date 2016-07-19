package com.lyft.rx;

import me.lyft.android.common.Objects;

public class Tuple<T1, T2>
{
  public final T1 item1;
  public final T2 item2;
  
  public Tuple(T1 paramT1, T2 paramT2)
  {
    item1 = paramT1;
    item2 = paramT2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Tuple))
    {
      paramObject = (Tuple)paramObject;
      bool1 = bool2;
      if (Objects.equals(item1, item1))
      {
        bool1 = bool2;
        if (Objects.equals(item2, item2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     com.lyft.rx.Tuple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */