package com.facebook.share;

import com.facebook.internal.Mutable;
import java.util.Iterator;

class ShareApi$5$1
  implements Iterator<Integer>
{
  ShareApi$5$1(ShareApi.5 param5, Mutable paramMutable, int paramInt) {}
  
  public boolean hasNext()
  {
    return ((Integer)val$current.value).intValue() < val$size;
  }
  
  public Integer next()
  {
    Integer localInteger = (Integer)val$current.value;
    Mutable localMutable = val$current;
    value = Integer.valueOf(((Integer)value).intValue() + 1);
    return localInteger;
  }
  
  public void remove() {}
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */