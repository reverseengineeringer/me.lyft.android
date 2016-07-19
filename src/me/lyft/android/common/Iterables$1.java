package me.lyft.android.common;

import rx.functions.Func2;

final class Iterables$1
  implements Func2<TSource, TSource, Boolean>
{
  public Boolean call(TSource paramTSource1, TSource paramTSource2)
  {
    return Boolean.valueOf(Objects.equals(paramTSource1, paramTSource2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Iterables.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */